package br.com.example.todolist.task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

// extende o jpa passando qual vai ser a entidade e qual vai sero id
public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {

}
