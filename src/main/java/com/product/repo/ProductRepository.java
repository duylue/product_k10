package com.product.repo;

import com.product.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Objects;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Transactional
    @Modifying
    @Query( value = "insert into product(pid,pname,status) values(?,?,?)",nativeQuery = true)
    void insert(int id, String pname, int status);
    @Transactional
    @Modifying
    @Query( value = "insert into product_detail(did,price,producer,category_id) values(?,?,?,?)",nativeQuery = true)
    void insertDetail(int did, float price,String producer, int cateid);
    @Query(value = "select p.pid,p.cdate,p.pname, d.price, d.producer,c.catename, s.sname from product p , product_detail d\n" +
            ",category c, product_status s\n" +
            "where p.pid = d.did\n" +
            "and p.status = s.sid\n" +
            "and d.category_id = c.cateid\n" +
            "and p.pid = ?;",nativeQuery = true)
    Map<String, Objects> getProductDetail(int id);

}
