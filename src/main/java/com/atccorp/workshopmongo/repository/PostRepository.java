package com.atccorp.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.atccorp.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
