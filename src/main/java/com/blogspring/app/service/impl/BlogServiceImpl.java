package com.blogspring.app.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogspring.app.dao.BlogDao;
import com.blogspring.app.model.BlogData;
import com.blogspring.app.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService{
	
	@Autowired
	BlogDao blogDao;

	@Override
	public String createBlog(BlogData blogData) throws Exception {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		blogData.setCreateDate(calendar.getTime());
		blogData.setUpdateDate(calendar.getTime());
		blogDao.createBlog(blogData);
		return "New blog has been included";
	}

	@Override
	public List<BlogData> findAll() throws Exception {
		// TODO Auto-generated method stub
		return blogDao.findAll();
	}

	@Override
	public List<BlogData> findById(Long Id) throws Exception {
		// TODO Auto-generated method stub
		return blogDao.findById(Id);
	}

	@Override
	public String editBlog(BlogData blogData) throws Exception {
		// TODO Auto-generated method stub
		String notif = "";
		Calendar calendar = Calendar.getInstance();
		blogData.setUpdateDate(calendar.getTime());
		boolean editSuccess = blogDao.editBlog(blogData);
		if (editSuccess) {
			notif = "Blog has been edited";
		}else {
			notif = "Blog edit failed";
		}
		return notif;
	}

	@Override
	public String deleteBlog(Long Id) throws Exception {
		// TODO Auto-generated method stub
		blogDao.deleteBlog(Id);
		return "Blog has been deleted";
	}

	@Override
	public List<BlogData> findAllPagination(int page) throws Exception {
		// TODO Auto-generated method stub
		int pageData = 5;
		int startLoop, endLoop, sizeList, jumPage;
		List<BlogData> blogDatas = blogDao.findAll();
		List<BlogData> blogDataPage = new ArrayList<>();
		sizeList = blogDatas.size();
		
		if (sizeList%pageData == 0) {
			jumPage = sizeList/pageData;
		}else {
			jumPage = (sizeList/pageData)+1;
		}
		
		if (page == 1) {
			startLoop = 0;
			if (sizeList % pageData == 0) {
				endLoop = sizeList;
			}else {
				endLoop = pageData;
			}
			
		}else if (page == jumPage) {
			startLoop = (page-1)*pageData;
			
			endLoop = sizeList;
		}else {
			startLoop = (page-1)*pageData;
			
			endLoop = (page)*pageData;
		}
		
		
		for (int i = startLoop; i < endLoop; i++) {
			if (!blogDatas.isEmpty()) {
				blogDataPage.add(blogDatas.get(i));
			}
			
		}
		
		return blogDataPage;
	}

}
