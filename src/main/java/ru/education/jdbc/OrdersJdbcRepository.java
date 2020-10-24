package ru.education.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.education.entity.OrdersJdbcDemo;
import ru.education.jpa.Product;

import java.util.List;

@Repository
public class OrdersJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrdersJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer count(){
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM public.order", Integer.class);
    }

    public List<OrdersJdbcDemo> getOrders(){
        return jdbcTemplate.query("SELECT * FROM public.order",(rs, rowNum) ->
                new OrdersJdbcDemo(
                        rs.getInt("id"),
                        rs.getDate("date"),
                        rs.getLong("price"),
                        rs.getInt("quantity"),
                        rs.getString("customer"),
                        rs.getInt("product")
                ));
    }

    public List<Product> orderedProduct(){
        return jdbcTemplate.query("select public.product.id, public.product.name  from public.product inner join " +
                "public.order on public.product.id = public.order.product where customer = 'Anny'",(rs,rowNum) ->
                new Product(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
    }

    public int delete(String id){

        return jdbcTemplate.update("delete from order where id = ?", id);
    }
}
