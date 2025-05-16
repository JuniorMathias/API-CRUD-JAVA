package com.spring.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PageModel<T> implements  Serializable{

    private static final long serialVersionUID = 1L;

    private Long totalElement;
    private Integer currentPage;
    private Integer totalPage;
    private Integer pageSize;
    private List<T> elements;

}
