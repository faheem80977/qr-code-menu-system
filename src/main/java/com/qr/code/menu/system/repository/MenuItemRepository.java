package com.qr.code.menu.system.repository;

import com.qr.code.menu.system.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {
}
