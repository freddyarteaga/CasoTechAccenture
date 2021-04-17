package com.example.demo.buy;
import com.example.demo.product.Product;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Buy {

    private UUID id;
    private Integer userId;
    private String address;
    private List<Product> products;
    private Integer delivery;
    private Float tax;
    private Float total;
    private Integer subtotal;
    private Date createAt;



    public Buy(Integer userId, String address, List<Product> products) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.address = address;
        this.products = products;
        this.subtotal = calcTotal(products);
        this.createAt = new Date();


        if (this.subtotal < 70000) {
            this.delivery = 4000;
            this.tax = 0f;
            this.total = (float)this.subtotal + this.delivery;
        }else if (this.subtotal < 100000){
            this.delivery = 4000;
            this.tax = 1.19f;
            this.total = (float)this.subtotal * this.tax + this.delivery;
        }else{
            this.delivery = 0;
            this.tax = 1.19f;
            this.total = (float)this.subtotal * this.tax;
        }

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public Float getTax() {
        return tax;
    }

    public void setTax(Float tax) {
        this.tax = tax;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    private Integer calcTotal(List<Product> products){
        return products.stream()
                .mapToInt((product)->(product.getPrice()))
                .reduce(0, (accumulator, price) -> ( accumulator + price)
        );
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", products=" + products +
                ", delivery=" + delivery +
                ", tax=" + tax +
                ", total=" + total +
                ", subtotal=" + subtotal +
                ", createAt=" + createAt +
                '}';
    }
}