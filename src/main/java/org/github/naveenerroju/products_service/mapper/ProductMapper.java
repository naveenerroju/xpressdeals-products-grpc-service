package org.github.naveenerroju.products_service.mapper;

import org.github.naveenerroju.products_service.Product;
import org.github.naveenerroju.products_service.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Objects can throw NullPointerException when they are null
 */
@Mapper(componentModel = "spring", uses = {FlashsaleMapper.class, RatingsMapper.class, CustomConverters.class})
public interface ProductMapper {

    @Mapping(source = "id", target = "id", qualifiedByName = "stringToObjectId")
    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "timestampToDate")
    @Mapping(source = "updatedAt", target = "updatedAt", qualifiedByName = "timestampToDate")
    @Mapping(source = "flashSale", target = "flashSale")
    @Mapping(source = "ratings", target = "ratings")
    Products mapProductToEntity(Product product);

    @Mapping(source = "id", target = "id", qualifiedByName = "objectIdToString")
    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "dateToTimestamp")
    @Mapping(source = "updatedAt", target = "updatedAt", qualifiedByName = "dateToTimestamp")
    @Mapping(source = "flashSale", target = "flashSale")
    @Mapping(source = "ratings", target = "ratings")
    Product mapEntityToProduct(Products product);

}
