package pl.pozsda19.electroshop.domain.dto;


import lombok.ToString;

import java.math.BigDecimal;

@ToString
public class ProductEntityReading {

    public String name;

    public String code;

    public String category;

    public String subcategory;

    public String groupo;

    public String imageURL;

    public String description;

    public BigDecimal price;

}
