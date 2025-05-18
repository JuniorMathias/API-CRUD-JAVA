package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.spring.domain.Category;
import com.spring.model.FilterModel;
import com.spring.model.PageModel;
import com.spring.repository.CategoryRepository;

@Service
public class CategoryService implements IListService<Category>{

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> list() {
        List<Category> categories = repository.findAll();
        return categories;
    }

    @Override
    public PageModel<Category> list(FilterModel filter) {
      

        Page<Category> categoryPage =  repository.findAll(filter.toSpringPageable());

        PageModel<Category> pm = new PageModel<>(categoryPage);

        return pm;
    }

    
}
