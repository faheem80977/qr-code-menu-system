package com.qr.code.menu.system.repository;

import com.qr.code.menu.system.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
