package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.spring.domain.Supplier;
import com.spring.model.FilterModel;
import com.spring.model.PageModel;
import com.spring.repository.SupplierRepository;

@Service
public class SupplierService implements IListService<Supplier>{
    @Autowired
    private SupplierRepository repository;

    @Override
    public List<Supplier> list() {
        List<Supplier> suppliers = repository.findAll();
        return suppliers;
    }

    @Override
    public PageModel<Supplier> list(FilterModel filter) {
        Page<Supplier> supplierPage =  repository.findAll(filter.toSpringPageable());

        PageModel<Supplier> pm = new PageModel<>(supplierPage);

        return pm;
    }
    
}
