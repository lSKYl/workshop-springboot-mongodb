package com.lucas.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucas.workshopmongo.domain.User;

//Repository cuida dos comandos como encontrar tal entidade no banco de dados, ou inserir.
@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
