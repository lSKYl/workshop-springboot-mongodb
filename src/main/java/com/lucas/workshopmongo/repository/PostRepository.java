package com.lucas.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucas.workshopmongo.domain.Post;

//Repository cuida dos comandos como encontrar tal entidade no banco de dados, ou inserir.
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	List<Post> findByTitleContainingIgnoreCase(String text);
}
