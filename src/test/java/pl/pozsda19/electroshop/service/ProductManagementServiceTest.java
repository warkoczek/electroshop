package pl.pozsda19.electroshop.service;



import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import pl.pozsda19.electroshop.domain.dto.ProductEntityWriting;




@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProductManagementServiceTest {

    @Autowired
    private ProductManagementService productManagementService;


    @Test
    void createProductShouldAddANewProductToTheDatabase(){
        //given
        ProductEntityWriting product = new ProductEntityWriting("1234", "Wyrzynarka", "ELEKTRONARZEDZIA", "AKUMULATOROWE"
                , "WYRZYNARKI", "image","wyrzyna dobrze", 30.00,30);
        String expectedCode = "1234";
        //when
        String actualProductCode = productManagementService.createProduct(product).getCode();
        //then
        Assert.assertEquals(expectedCode, actualProductCode);

    }
}
