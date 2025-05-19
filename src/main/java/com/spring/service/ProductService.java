package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.spring.domain.Product;
import com.spring.model.FilterModel;
import com.spring.model.PageModel;
import com.spring.repository.ProductRepository;

@Service
public class ProductService implements IListService<Product>{
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> list() {
        List<Product> products = repository.findAll();
        return products;
    }

    @Override
    public PageModel<Product> list(FilterModel filter) {
       
        Page<Product> productPage =  repository.findAll(filter.toSpringPageable());

        PageModel<Product> pm = new PageModel<>(productPage);

        return pm;
    }

}
