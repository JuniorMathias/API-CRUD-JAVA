package com.spring.specification;

import org.springframework.data.jpa.domain.Specification;

import com.spring.builder.ExpressionBuilder;
import com.spring.domain.Product;
import com.spring.model.EqualFilterModel;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ProductSpecification {

    public static Specification<Product> equal(EqualFilterModel eq) {
        return new Specification<Product>() {
            
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                ExpressionBuilder<Product> expBuilder = new ExpressionBuilder<>(Product.class);
                Expression<Product> expression = expBuilder.get(root, eq.getColumn());
                
                Predicate predicate = null;

                if(expression != null){
                    predicate = (eq.getIsEqual() ? cb.equal(expression, eq.getValue())
                            : cb.notEqual(expression, eq.getValue()));
                }

                return predicate;
            }
        };
    }
}
