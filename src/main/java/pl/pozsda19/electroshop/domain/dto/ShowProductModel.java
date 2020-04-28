package pl.pozsda19.electroshop.domain.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ShowProductModel {

    private String name;

    private String imageURL;

    private String description;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                Objects.equals(imageURL, that.imageURL) &&
                Objects.equals(description, that.description) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imageURL, description, price);
    }
}
