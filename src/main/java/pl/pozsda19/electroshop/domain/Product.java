package pl.pozsda19.electroshop.domain;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
@Entity
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String name;

    private String code;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private SubCategory subcategory;

    private String imageURL;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long id) {
        this.productId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String productName) {
        this.name = productName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String productCode) {
        this.code = productCode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(SubCategory subCategory) {
        this.subcategory = subCategory;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String pictureURL) {
        this.imageURL = pictureURL;
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
        return Objects.equals(productId, product.productId) &&
                Objects.equals(name, product.name) &&
                Objects.equals(code, product.code) &&
                category == product.category &&
                subcategory == product.subcategory &&
                Objects.equals(imageURL, product.imageURL) &&
                Objects.equals(description, product.description) &&
                Objects.equals(price, product.price) &&
                Objects.equals(quantity, product.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, code, category, subcategory, imageURL, description, price, quantity);
    }
}
