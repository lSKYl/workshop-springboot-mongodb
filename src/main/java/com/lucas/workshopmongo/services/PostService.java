package com.lucas.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.workshopmongo.domain.Post;
import com.lucas.workshopmongo.repository.PostRepository;
import com.lucas.workshopmongo.services.exceptions.ObjectNotFoundException;

//Cuida das regras de negócio
@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	

}
