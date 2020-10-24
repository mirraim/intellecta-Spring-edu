package ru.education.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.education.entity.OrdersJpaDemo;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersJpaDemo, Integer> {

}
