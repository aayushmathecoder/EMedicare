package com.health.medicare.emedicare;

import java.io.Serializable;


class CartDetails implements Serializable{
    private float totalPrice;
    private int totalItemsInCart;
    private Medicine medicine;
    private String itemQuantity;

    String getItemQuantity() {
        return itemQuantity;
    }

    CartDetails(float totalCartPrice, int totalItemsInCart, String quantty, Medicine medicine) {
        this.totalPrice = totalCartPrice;

        this.totalItemsInCart = totalItemsInCart;
        this.medicine = medicine;
        itemQuantity=quantty;

    }

    float getTotalPrice() {
        return totalPrice;
    }

    public int getTotalItemsInCart() {
        return totalItemsInCart;
    }

    public Medicine getMedicine() {
        return medicine;
    }

 /*   public CartDetails(float totalPrice, int totalItemsInCart, Medicine medicine) {
        this.totalPrice = totalPrice;

        this.totalItemsInCart = totalItemsInCart;
        this.medicine = medicine;
    }*/
}

