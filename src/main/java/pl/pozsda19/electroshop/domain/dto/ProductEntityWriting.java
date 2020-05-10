package pl.pozsda19.electroshop.domain.dto;


public class ProductEntityWriting {
    public String code;
    public String name;
    public String category;
    public String subcategory;
    public String groupo;
    public String imageURL;
    public String description;
    public Double price;
    public int quantity;

    public ProductEntityWriting() {
    }

    public ProductEntityWriting(String code, String name, String category, String subcategory, String groupo, String imageURL, String description, Double price, int quantity) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.subcategory = subcategory;
        this.groupo = groupo;
        this.imageURL = imageURL;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getGroupo() {
        return groupo;
    }

    public void setGroupo(String groupo) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
