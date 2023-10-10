package br.com.example.todolist.users;

public class UserModel {

  private String username;
  private String name;
  private String password;

  // atribui ao modificador privado o valor que vem do serUsername
  public void setUsername(String username) {
    this.username = username;
  }

  // retorna o valor do modificador privado
  public String getUsername() {
    return username;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

}
