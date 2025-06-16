package org.github.naveenerroju.products_service.mapper;

import org.github.naveenerroju.products_service.Product;
import org.github.naveenerroju.products_service.entity.FlashSales;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { CustomConverters.class })
public interface FlashsaleMapper {


    @Mapping(source = "startTime", target = "startTime", qualifiedByName = "dateToTimestamp")
    @Mapping(source = "endTime", target = "endTime", qualifiedByName = "dateToTimestamp")
    Product.FlashSale entityToDto(FlashSales flashSale);

    @Mapping(source = "startTime", target = "startTime", qualifiedByName = "timestampToDate")
    @Mapping(source = "endTime", target = "endTime", qualifiedByName = "timestampToDate")
    FlashSales dtoToEntity(Product.FlashSale flashSale);
}

