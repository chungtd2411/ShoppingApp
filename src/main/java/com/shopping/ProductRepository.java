package com.shopping;


import com.shopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p from Product p where p.name like %:name%")
    List<Product> findByName(String name);

    @Query("from Product where price between :min and :max")
    List<Product> findByPrice(@Param("min") int min, @Param("max") int max);
}
