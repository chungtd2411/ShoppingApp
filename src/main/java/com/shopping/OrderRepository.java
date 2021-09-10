package com.shopping;

import com.shopping.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT order_test.id, user.username, product.name" +
            " FROM order_test" +
            " INNER JOIN user ON order_test.uid = user.id" +
            " INNER JOIN product  ON order_test.productid = product.id" +
            " WHERE order_test.id = :id",  nativeQuery = true)
    Order queryBy(@Param("id") int id);
}
