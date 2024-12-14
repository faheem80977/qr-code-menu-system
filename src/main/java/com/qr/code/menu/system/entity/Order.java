package com.qr.code.menu.system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private Long menuItemId;
    private int quantity;

//    @ManyToOne
//    @JoinColumn(name = "menu_item_id", nullable = false)
//    private MenuItem menuItem;


}
