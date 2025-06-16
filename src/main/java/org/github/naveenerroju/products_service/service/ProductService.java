package org.github.naveenerroju.products_service.service;

import io.grpc.stub.StreamObserver;
import org.bson.types.ObjectId;
import org.github.naveenerroju.products_service.*;
import org.github.naveenerroju.products_service.entity.Products;
import org.github.naveenerroju.products_service.mapper.ProductMapper;
import org.github.naveenerroju.products_service.repository.ProductsRepository;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class ProductService extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductMapper productMapper;
    private final ProductsRepository repository;

    public ProductService(ProductMapper productMapper, ProductsRepository repository) {
        this.productMapper = productMapper;
        this.repository = repository;
    }

    @Override
    public void createProduct(Product request, StreamObserver<Product> responseObserver) {
        Products entity = productMapper.mapProductToEntity(request);
        Products response = repository.save(entity);
        Product productResponse = productMapper.mapEntityToProduct(response);
        responseObserver.onNext(productResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getProduct(ProductRequest request, StreamObserver<Product> responseObserver) {
        repository.findById(new ObjectId(request.getProductId())).ifPresent(
                o->{
                    responseObserver.onNext(productMapper.mapEntityToProduct(o));
                }
        );
        responseObserver.onCompleted();
    }
}
