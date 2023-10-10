package br.com.example.todolist.users;

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

  // metodo de cadastro
  /*
   * principais tipos de dados:
   * String
   * Intenger
   * Double
   * Float
   * char
   * Date
   * Void
   */

  // anotação para indicar que é um metodo post
  @PostMapping("/")
  // modificador -> tipo de retorno -> nome do metodo -> parametros (definindo que
  // as informações vão vir no corpo da requisição)
  public void create(@RequestBody UserModel userModel) {
    // prntar no terminal (recuperando o valor do username pelo metodo getUsername)
    System.out.println(userModel.getUsername());
  }
}
