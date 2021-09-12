package com.shopping;

import com.shopping.model.JoinOrder;
import com.shopping.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT new com.shopping.model.JoinOrder(o.id, u.name, p.name, p.price, o.quantity) "
            + "FROM Order o INNER JOIN o.user u INNER JOIN o.product p where o.id =:id")
    JoinOrder fetchDataInnerJoin(int id);

    @Query("SELECT new com.shopping.model.JoinOrder(o.id, u.name, p.name, p.price, o.quantity) "
            + "FROM Order o INNER JOIN o.user u INNER JOIN o.product p where u.id =:id")
    List<JoinOrder> findByUserId(int id);

//    @Query("SELECT o.product "
//            + "FROM Order o INNER JOIN o.user u INNER JOIN o.product p where u.id =:id")
//    List<Product> findByUserId(int id);

}
