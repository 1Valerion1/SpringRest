package com.example.springapi.springapi.api.model;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id; //id

    @Column(name="category")
    private String category;

    @Column(name = "manufacturer")
    private String Manufacturer;


    @Column(name = "price")
    private int Price;

    @Column(name = "numberProducts")
    private String NumberProduct;

    @Column(name = "formFactorPC")
    private String FormFactorPC;

    @Column(name = "diagonalLaptop")
    private int diagonalLaptop;

    @Column(name = "diagonalMonitor")
    private int diagonalMonitor;

    @Column(name = "volumeHD")
    private int VolumeHD;

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", Manufacturer='" + Manufacturer + '\'' +
                ", Price=" + Price +
                ", NumberProduct='" + NumberProduct + '\'' +
                ", FormFactorPC='" + FormFactorPC + '\'' +
                ", diagonalLaptop=" + diagonalLaptop +
                ", diagonalMonitor=" + diagonalMonitor +
                ", VolumeHD=" + VolumeHD +
                '}';
    }

    public Products(String category, String manufacturer, int price, String numberProduct,
                    String formFactorPC, int diagonalLaptop, int diagonalMonitor, int volumeHD) {
        this.category = category;
        this.Manufacturer = manufacturer;
        this.Price = price;
        this.NumberProduct = numberProduct;
        this.FormFactorPC = formFactorPC;
        this.diagonalLaptop = diagonalLaptop;
        this.diagonalMonitor = diagonalMonitor;
        this.VolumeHD = volumeHD;
    }
    public Products(String category, String manufacturer, int price, String numberProduct) {
        this.category = category;
        Manufacturer = manufacturer;
        Price = price;
        NumberProduct = numberProduct;
    }

    public Products(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getNumberProduct() {
        return NumberProduct;
    }

    public void setNumberProduct(String numberProduct) {
        NumberProduct = numberProduct;
    }

    public String getFormFactorPC() {
        return FormFactorPC;
    }

    public void setFormFactorPC(String formFactorPC) {
        FormFactorPC = formFactorPC;
    }

    public int getDiagonalLaptop() {
        return diagonalLaptop;
    }

    public void setDiagonalLaptop(int diagonalLaptop) {
        this.diagonalLaptop = diagonalLaptop;
    }

    public int getDiagonalMonitor() {
        return diagonalMonitor;
    }

    public void setDiagonalMonitor(int diagonalMonitor) {
        this.diagonalMonitor = diagonalMonitor;
    }

    public int getVolumeHD() {
        return VolumeHD;
    }

    public void setVolumeHD(int volumeHD) {
        VolumeHD = volumeHD;
    }
}
