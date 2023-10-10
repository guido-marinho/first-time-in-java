package br.com.example.todolist.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// o nome da classe precisa ser o  msm nome do arquivo
// começa sempre com letra maiuscula
/**
 * Modificador:
 * public: pode ser acessado por qualquer classe
 * private: só pode ser acessado pela classe
 * protected: pode ser acessado pela classe e pelas classes filhas
 */

// anotação para indicar que é um controller
@RestController
// anotação para indicar o caminho da url (localhost:8080/users)
@RequestMapping("/users")
public class UserController {

  @Autowired
  private IUserRepository userRepository;

  // metodo de cadastro
  // anotação para indicar que é um metodo post
  @PostMapping("/")
  public ResponseEntity create(@RequestBody UserModel userModel) {

    var user = this.userRepository.findByUsername(userModel.getUsername());

    // diferente em java !+=
    if (user != null) {
      System.out.println("Usuário já existe");
      return ResponseEntity.status(400).body("Usuário já existe");
    }

    var userCreated = this.userRepository.save(userModel);

    return ResponseEntity.status(200).body(userCreated);
  }
}
