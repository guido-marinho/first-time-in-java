package br.com.example.todolist.users;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data // cria os getters e setters para todos os atributos
@Entity(name = "todo_users") // indica que é uma entidade do banco de dados
public class UserModel {

  @Id // indica que é a chave primaria
  @GeneratedValue(generator = "UUID") // indica que o valor é gerado automaticamente
  private UUID id;

  @Column(name = "username", nullable = false, unique = true) // indica que é uma coluna do banco de dados
  private String username;
  private String name;
  private String password;

  @CreationTimestamp // indica que o valor é gerado automaticamente
  private LocalDateTime createdAt;

}
