package br.com.example.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.example.todolist.users.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

  @Autowired
  private IUserRepository userRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    // autenticar usuario
    var auth = request.getHeader("Authorization");
    // cortar o equivalente ao tamanho de "Basic" e remover os espaços com trim
    var authEncoded = auth.substring("Basic".length()).trim();
    // descriptografar
    byte[] authDecoded = Base64.getDecoder().decode(authEncoded);
    // converter o array de bytes para string
    var authDecodedString = new String(authDecoded);
    // separar o usuario e senha
    String[] credentials = authDecodedString.split(":");
    var username = credentials[0];
    var password = credentials[1];

    // validar usuario
    var user = this.userRepository.findByUsername(username);
    if (user == null) {
      response.sendError(401);
      return;
    } else {
      // validar senha
      var passwordHashred = user.getPassword();
      var passwordValid = BCrypt.verifyer().verify(password.toCharArray(), passwordHashred).verified;
      if (passwordValid) {
        // segue o fluxo
        filterChain.doFilter(request, response);
      } else {
        response.sendError(401);
        return;
      }
    }

  }

}
