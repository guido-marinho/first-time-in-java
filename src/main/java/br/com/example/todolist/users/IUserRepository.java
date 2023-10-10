package br.com.example.todolist.users;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

// interface para definir os metodos que serão implementados
// parametros: tipo da entidade e tipo da chave primaria
public interface IUserRepository extends JpaRepository<UserModel, UUID> {
  // criando um metodo para buscar um usuario pelo username
  UserModel findByUsername(String username);
}
