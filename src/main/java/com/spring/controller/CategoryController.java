package com.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Category;
import com.spring.service.CategoryService;

import org.springframework.web.bind.annotation.GetMapping;

import com.spring.model.FilterModel;
import com.spring.model.PageModel;


@RestController
@RequestMapping(value = "categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping    
    public ResponseEntity<PageModel<Category>> list(@RequestParam Map<String, String> params ) {
        FilterModel filter = new FilterModel(params);
        PageModel<Category> pm =  service.list(filter);
        return ResponseEntity.ok(pm);
    }
}
