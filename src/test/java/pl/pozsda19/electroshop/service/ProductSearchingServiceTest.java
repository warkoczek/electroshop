package pl.pozsda19.electroshop.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.dto.ProductEntityReading;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProductSearchingServiceTest {

    @Autowired
    private ProductSearchingService productSearchingService;

    @Test
    void showProductsByCategoryPriceUpShouldReturnLowestPrice500ForFirstProductInTheList() {
        //given
        Category category = Category.TECHNIKAPOMIAROWA;
        int firstProductIndex = 0;
        BigDecimal expectedPrice = BigDecimal.valueOf(50000, 2);
        //when
        BigDecimal actualPrice = productSearchingService.showProductsByCategoryPriceUp(category).get(0).price;
        //then
        Assert.assertEquals(expectedPrice, actualPrice);

    }

    @Test
    void showProductsByCategoryPriceDownShouldReturnHighestPrice850ForFirstProductInTheList() {
        //given
        Category category = Category.TECHNIKAPOMIAROWA;
        int firstProductIndex = 0;
        BigDecimal expectedPrice = BigDecimal.valueOf(85000, 2);
        //when
        BigDecimal actualPrice = productSearchingService.showProductsByCategoryPriceDown(category).get(0).price;
        //then
        Assert.assertEquals(expectedPrice, actualPrice);
    }


}
