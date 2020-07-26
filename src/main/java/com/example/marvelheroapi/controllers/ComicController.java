package com.example.marvelheroapi.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.marvelheroapi.models.Comics;
import com.example.marvelheroapi.repository.ComicRepository;
import com.example.marvelheroapi.services.MarvelService;

import antlr.collections.List;

@Controller
@RequestMapping(path="/comics")
public class ComicController {
	@Autowired
	private ComicRepository comicRepository;
	
	
	@GetMapping("/")
	public @ResponseBody Object findAll() throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		MarvelService marvelService = new MarvelService();
		Object service = marvelService.getComics();
	    System.out.println(service);

				
		return service;
		
	}
	
	@PostMapping("/")
	public @ResponseBody String saveComic(@RequestBody Comics comics) {
		

		Comics comic = new Comics();
		comic.setComicName(comics.getComicName());
		comic.setComicReference(comics.getComicReference());
		comic.setDetail(comics.getDetail());
		comic.setPageCount(comics.getPageCount());
		comic.setResourceUri(comics.getResourceUri());
		comicRepository.save(comic);
		return "saved";
			
	}

}
