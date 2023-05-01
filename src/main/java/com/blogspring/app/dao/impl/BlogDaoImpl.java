package com.blogspring.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blogspring.app.dao.BlogDao;
import com.blogspring.app.model.BlogData;
import com.blogspring.app.repository.BlogRepo;

@Transactional
@Repository
public class BlogDaoImpl implements BlogDao{
	
	@Autowired
	private BlogRepo blogRepo;

	@Override
	public void createBlog(BlogData blogData) throws Exception {
		// TODO Auto-generated method stub
		blogRepo.save(blogData);
	}

	@Override
	public List<BlogData> findById(Long Id) throws Exception {
		// TODO Auto-generated method stub
		return blogRepo.findAllById(Id);
	}

	@Override
	public List<BlogData> findAll() throws Exception {
		return blogRepo.findAll();
	}

	@Override
	public boolean editBlog(BlogData blogData) throws Exception {
		// TODO Auto-generated method stub
		List<BlogData> datas = blogRepo.findAllById(blogData.getId());
		if (datas==null) {
			return false;
		}else {
			blogRepo.save(blogData);
			return true;
		}
	}

	@Override
	public void deleteBlog(Long Id) throws Exception {
		// TODO Auto-generated method stub
		blogRepo.deleteById(Id);
		
	}

}
