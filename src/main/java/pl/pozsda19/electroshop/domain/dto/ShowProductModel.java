package pl.pozsda19.electroshop.domain.dto;


import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.Group;
import pl.pozsda19.electroshop.domain.Subcategory;

import java.math.BigDecimal;
import java.util.Objects;

public class ShowProductModel {

    private String name;

    private String code;

    private Category category;

    private Subcategory subcategory;

    private Group groupo;

    private String imageURL;

    private String description;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Group getGroupo() {
        return groupo;
    }

    public void setGroupo(Group groupo) {
        this.groupo = groupo;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    @Override
    public String toString() {
        return name + " " + imageURL + " " + description + " " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowProductModel that = (ShowProductModel) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(code, that.code) &&
                category == that.category &&
                subcategory == that.subcategory &&
                groupo == that.groupo &&
                Objects.equals(imageURL, that.imageURL) &&
                Objects.equals(description, that.description) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, category, subcategory, groupo, imageURL, description, price);
    }
}
