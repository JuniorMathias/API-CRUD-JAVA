package com.spring.service;

import java.util.List;

import com.spring.model.FilterModel;
import com.spring.model.PageModel;

public interface IListService<T> {
    public List<T> list();

    public PageModel<T> list(FilterModel filter);
    
}
