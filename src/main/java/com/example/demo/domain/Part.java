package com.example.demo.domain;

import com.example.demo.validators.ValidMinMax;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Entity
@ValidMinMax
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="part_type",discriminatorType = DiscriminatorType.INTEGER)
@Table(name="Parts")
public abstract class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "Inventory value must be positive")
    int inv;
    @Column(name = "MAX_INV")
    int max_inv;
    @Column(name = "MIN_INV")
    int min_inv;


    @ManyToMany
    @JoinTable(name="product_part", joinColumns = @JoinColumn(name="part_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    Set<Product> products= new HashSet<>();

    public Part() {
    }

    public Part(String name, double price, int inv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
    }

    public Part(long id, String name, double price, int inv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
    }

        public Part(String name, double price, int inv, int max_inv, int min_inv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.max_inv = max_inv;
        this.min_inv = min_inv;
    }

    public Part(long id, String name, double price, int inv, int max_inv, int min_inv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.max_inv = max_inv;
        this.min_inv = min_inv;
    }

    public void multiPart() {
        this.setName(this.getName() + " (multi)");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInv() {
        return inv;
    }

    public void setInv(int inv) {
        this.inv = inv;
    }

    public int getMax_inv() {
        return max_inv;
    }

    public void setMax_inv(int max_inv) {
        this.max_inv = max_inv;
    }

    public int getMin_inv() {
        return min_inv;
    }

    public void setMin_inv(int min_inv) {
        this.min_inv = min_inv;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String toString(){
        return this.name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        return id == part.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
