package pl.pozsda19.electroshop.service;



import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.dto.ProductEntityWriting;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProductManagementServiceTest {

    @Autowired
    private ProductManagementService productManagementService;

    @Test
    void showAllProductsEndpointShouldReturn7Products(){
        //given
        int expectedSize = 7;
        //when
        int actualSize = productManagementService.showAllProducts().size();
        //then
        Assert.assertEquals(expectedSize,actualSize);
    }


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
    @Test
    void updateProductWithKnownIdShouldUpdatedTheProduct(){
        //given
        ProductEntityWriting product = new ProductEntityWriting("453"
                , "Wykrywacz przewodów BOSCH DMF 10 Zoom", "CZESCIZAMIENNE"
                , "UZYWANE", "WIRNIKI"
                , "http://www.elektroserw.pl/zdjecia/29_2.jpg", "opis"
                , 500.00, 1);
        String expectedDescription = "opis";
        //when
        productManagementService.updateProduct(product);
        String actualDescription = productManagementService.showProductByCode("453").get().getDescription();
        //then
        Assert.assertEquals(expectedDescription,actualDescription);

    }
}
