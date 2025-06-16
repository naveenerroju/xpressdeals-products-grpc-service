package org.github.naveenerroju.products_service.mapper;

import org.github.naveenerroju.products_service.Product;
import org.github.naveenerroju.products_service.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RatingsMapper {

    Products.Ratings entityToDto(Product.Ratings ratings);
    Product.Ratings dtoToEntity(Products.Ratings ratings);
}
