package com.blogspring.app.dao;

import java.util.List;

import com.blogspring.app.model.BlogData;

public interface BlogDao {
	public void createBlog(BlogData blogData) throws Exception;
	public List<BlogData> findById(Long Id) throws Exception;
	public List<BlogData> findAll() throws Exception;
	public boolean editBlog(BlogData blogData) throws Exception;
	public void deleteBlog(Long Id) throws Exception;
}
