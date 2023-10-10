package br.com.example.todolist.users;

import lombok.Data;

@Data // cria os getters e setters para todos os atributos
public class UserModel {

  private String username;
  private String name;
  private String password;

}
