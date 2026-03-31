package com.oops.inventorymanagement;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private int lowStockLimit;

    Product(int productId, String productName, int quantity, int lowStockLimit) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.lowStockLimit = lowStockLimit;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLowStockLimit() {
        return lowStockLimit;
    }

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }
}