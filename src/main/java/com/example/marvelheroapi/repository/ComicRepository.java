package com.example.marvelheroapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.marvelheroapi.models.Comics;


public interface ComicRepository extends CrudRepository<Comics, Integer> {

}
