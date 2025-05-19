package com.spring.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import static com.spring.constant.ApiConstants.*;

import lombok.Getter;

@Getter
public class FilterModel {
    private Integer page;
    private Integer limit;
    private String  sort;

    public FilterModel(Map<String, String> params){
       this.limit = params.containsKey(LIMIT_KEY) ? Integer.valueOf(params.get(LIMIT_KEY)) : DEFAULT_LIMIT;
       this.page = params.containsKey(PAGE_KEY) ? Integer.valueOf(params.get(PAGE_KEY)) : DEFAULT_PAGE;
       this.sort = params.containsKey(SORT_KEY) ? params.get(SORT_KEY) : DEFAULT_SORT;
    }

    public Pageable toSpringPageable() {
        List<Order> orders = getOrders();
        
        return PageRequest.of(page, limit, Sort.by(orders));
    }

    private List<Order> getOrders(){
         List<Order> orders = new ArrayList<>();

        String[] properties = sort.split(",");
        
        for(String propety : properties){
            if(propety.trim().isEmpty()){
                String column = "";
                if(propety.startsWith("-")){
                    column = propety.replace("-", "").trim();
                    orders.add(Order.desc(column));
                }else {
                    column = propety.trim();
                    orders.add(Order.asc(column));
                }

            }
        }
        return orders;
    }
    
}