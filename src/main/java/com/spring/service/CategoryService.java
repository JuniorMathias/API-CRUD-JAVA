package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.Category;
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

}
