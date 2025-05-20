package com.spring.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import static com.spring.constant.ApiConstants.*;
import com.spring.model.EqualFilterModel;

import lombok.Getter;

@Getter
public class FilterModel {
    private Integer page;
    private Integer limit;
    private String  sort;
    private String equalFilters;

    public FilterModel(Map<String, String> params){
       this.limit = params.containsKey(LIMIT_KEY) ? Integer.valueOf(params.get(LIMIT_KEY)) : DEFAULT_LIMIT;
       this.page = params.containsKey(PAGE_KEY) ? Integer.valueOf(params.get(PAGE_KEY)) : DEFAULT_PAGE;
       this.sort = params.containsKey(SORT_KEY) ? params.get(SORT_KEY) : DEFAULT_SORT;
       this.equalFilters = params.containsKey(EQUAL_FILTER_KEY) ? params.get(EQUAL_FILTER_KEY) : DEFAULT_EQUAL_FILTERS;
    }

    public Pageable toSpringPageable() {
        List<Order> orders = getOrders();
        
        return PageRequest.of(page, limit, Sort.by(orders));
    }
    
    public List<EqualFilterModel> getEqualFilters() {
        List<EqualFilterModel> filters = new ArrayList<EqualFilterModel>();
        
        if (equalFilters == null || equalFilters.trim().isEmpty())
            return filters;
        
        String[] filtersParam = equalFilters.split(";");
        
        for (String param : filtersParam) {
            if (param.contains(":")) {
                String[] elements = param.split(":");
                
                if (elements.length == 2) {
                    String column = elements[0];
                    String value = elements[1];
                    
                    filters.add(new EqualFilterModel(column, value, true));
                }
            }
            
            if (param.contains("~")) {
                String[] elements = param.split("~");
                
                if (elements.length == 2) {
                    String column = elements[0];
                    String value = elements[1];
                    
                    filters.add(new EqualFilterModel(column, value, false));
                }
            }
        }
        
        return filters;
    }
              
    private List<Order> getOrders(){
         List<Order> orders = new ArrayList<>();

        String[] properties = sort.split(",");
        
        for(String propety : properties){
           if (!propety.trim().isEmpty()) {
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