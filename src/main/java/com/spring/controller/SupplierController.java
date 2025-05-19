package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Supplier;
import com.spring.model.FilterModel;
import com.spring.model.PageModel;
import com.spring.service.SupplierService;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@RestController
@RequestMapping(value = "suppliers")
public class SupplierController {
    
     @Autowired
    private SupplierService service;

    @GetMapping    
    public ResponseEntity<PageModel<Supplier>> list(@RequestParam Map<String, String> params) {
        FilterModel filter = new FilterModel(params);
        PageModel<Supplier> pm =  service.list(filter);
        return ResponseEntity.ok(pm);
    }
}
