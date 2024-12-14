// ApiController.java
package com.qr.code.menu.system.controller;

import com.qr.code.menu.system.entity.MenuItem;
import com.qr.code.menu.system.entity.Order;
import com.qr.code.menu.system.repository.MenuItemRepository;
import com.qr.code.menu.system.repository.OrderRepository;
import com.qr.code.menu.system.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private QRCodeService qrCodeService;

    @PostMapping("/menu-items")
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @GetMapping("/menu-items")
    public List<MenuItem> getMenuItems() {
        return menuItemRepository.findAll();
    }

    @GetMapping("/menu-qr")
    public String generateMenuQRCode() throws Exception {
        List<MenuItem> menuItems = menuItemRepository.findAll();
        StringBuilder data = new StringBuilder("Menu:\n");
        for (MenuItem item : menuItems) {
            data.append(item.getName()).append(" - $").append(item.getPrice()).append("\n");
        }
        return qrCodeService.generateQRCode(data.toString());
    }

    @PostMapping("/orders")
    public Order placeOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
