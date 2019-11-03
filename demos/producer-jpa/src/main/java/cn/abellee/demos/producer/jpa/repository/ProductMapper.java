package cn.abellee.demos.producer.jpa.repository;

import cn.abellee.demos.producer.jpa.entity.po.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductMapper extends JpaRepository<Product, String> {
}