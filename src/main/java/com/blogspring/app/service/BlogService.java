package com.blogspring.app.service;

import java.util.List;

import com.blogspring.app.model.BlogData;

public interface BlogService {
	String createBlog(BlogData blogData) throws Exception;
	List<BlogData> findAll() throws Exception;
	List<BlogData> findById(Long Id) throws Exception;
	String editBlog(BlogData blogData) throws Exception;
	String deleteBlog(Long Id) throws Exception;
	List<BlogData> findAllPagination(int page) throws Exception;
}
