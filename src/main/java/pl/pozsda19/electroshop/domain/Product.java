package pl.pozsda19.electroshop.domain;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
@Entity
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(generator = "productSeq")
    @SequenceGenerator(name = "productSeq", sequenceName = "product_Seq", allocationSize = 1)
    private Long id;

    private String productName;

    private String productCode;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private SubCategory subCategory;

    private String picture;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String pictureURL) {
        this.picture = pictureURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productCode, product.productCode) &&
                category == product.category &&
                subCategory == product.subCategory &&
                Objects.equals(picture, product.picture) &&
                Objects.equals(description, product.description) &&
                Objects.equals(price, product.price) &&
                Objects.equals(quantity, product.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productCode, category, subCategory, picture, description, price, quantity);
    }
}
