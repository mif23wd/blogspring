package com.blogspring.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogspring.app.model.BlogData;

@Repository
public interface BlogRepo extends JpaRepository<BlogData, Integer> {

	List<BlogData> findAllById(Long id);

	void deleteById(Long id);

}
