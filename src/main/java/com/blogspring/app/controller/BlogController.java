package com.blogspring.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogspring.app.model.BlogData;
import com.blogspring.app.service.BlogService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addBlog(@RequestBody String content) {
		try {
			BlogData data = new ObjectMapper().readValue(content, BlogData.class);
			return new ResponseEntity<>(
					blogService.createBlog(data),
					HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_GATEWAY);
		}

	}
	
	@PutMapping("/edit")
	public ResponseEntity<?> editBlog(@RequestBody String content) {
		try {
			BlogData data = new ObjectMapper().readValue(content, BlogData.class);
			return new ResponseEntity<>(
					blogService.editBlog(data),
					HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_GATEWAY);
		}

	}
	
	@GetMapping("/openblog/{Id}")
	public ResponseEntity<List<BlogData>> findBlogById(@PathVariable Long Id) {
		List<BlogData> listData = new ArrayList<>();
		try {
			listData = blogService.findById(Id);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(listData, HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>(listData, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<BlogData>> findAllBlog() {
		List<BlogData> listData = new ArrayList<>();
		try {
			listData = blogService.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(listData, HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>(listData, HttpStatus.OK);
	}
	
	@GetMapping("/list/{page}")
	public ResponseEntity<List<BlogData>> findByPage(@PathVariable int page) {
		List<BlogData> listData = new ArrayList<>();
		try {
			listData = blogService.findAllPagination(page);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(listData, HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>(listData, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<?> addBlog(@PathVariable Long Id) {
		try {
			return new ResponseEntity<>(
					blogService.deleteBlog(Id),
					HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_GATEWAY);
		}

	}
	
	@GetMapping("/test")
	String testRest() {
		return "Cuma test aja";
	}
}
