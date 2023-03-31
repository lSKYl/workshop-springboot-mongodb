package com.lucas.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.lucas.workshopmongo.domain.Post;

/*
 * Referências com query methods:
https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
 * 
 * Referências para utilizar Query:
https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
https://docs.mongodb.com/manual/reference/operator/query/regex/
 */

//Repository cuida dos comandos como encontrar tal entidade no banco de dados, ou inserir.
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//Utilizar query para procurar no banco de dados
	@Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } } , { $or: [ { 'title' : { $regex: ?0, $options: 'i' } }, { 'body' : { $regex: ?0, $options: 'i' } }, { 'comments.text' : { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate); 
		
	
}
