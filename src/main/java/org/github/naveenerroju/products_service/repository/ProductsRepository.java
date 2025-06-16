package org.github.naveenerroju.products_service.repository;

import org.bson.types.ObjectId;
import org.github.naveenerroju.products_service.entity.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends MongoRepository<Products, ObjectId> {
}
