package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Category;
import com.spring.service.CategoryService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping    
    public ResponseEntity<List<Category>> list() {
        List<Category> categories = service.list();
        return ResponseEntity.ok(categories);
    }
}
