package pl.pozsda19.electroshop.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.Group;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.Subcategory;
import pl.pozsda19.electroshop.domain.dto.ProductEntityReading;
import pl.pozsda19.electroshop.domain.dto.ProductEntityWriting;
import pl.pozsda19.electroshop.exception.DuplicateProductCodeException;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void createProductShouldAddANewProductToTheDatabase(){
        //given
        ProductEntityWriting product = new ProductEntityWriting("1234", "Wyrzynarka", "ELEKTRONARZEDZIA", "AKUMULATOROWE"
                , "WYRZYNARKI", "image","wyrzyna dobrze", 30.00,30);
        String expectedCode = "1234";
        //when
        String actualProductCode = productService.createProduct(product).getCode();
        //then
        Assert.assertEquals(expectedCode, actualProductCode);

    }

    @Test
    void showAllProductsEndpointShouldReturn7Products(){
        //given
        int expectedSize = 7;
        //when
        int actualSize = productService.showAllProducts().size();
        //then
        Assert.assertEquals(expectedSize,actualSize);
    }

    @Test
    void showProductsByCategoryShouldReturnSetSize3ForCZESCIZAMIENNE(){
        //given
        Category category = Category.CZESCIZAMIENNE;
        int expectedSize = 3;
        //when
        int actualSize = productService.retrieveProductsByCategory(category).size();
        //then
        Assert.assertEquals(expectedSize,actualSize);
    }
    @Test
    void showProductsBySubcategoryShouldReturnSetSize2For(){
        //given
        Subcategory subcategory = Subcategory.UZYWANE;
        int expectedSize = 2;
        //when
        int actualSize = productService.retrieveProductsBySubcategory(subcategory).size();
        //then
        Assert.assertEquals(expectedSize,actualSize);
    }
    @Test
    void showProductsByGroupShouldReturnSetSize1ForORINGI(){
        //given
        Group group = Group.ORINGI;
        int expectedSize = 1;
        //when
        int actualSize = productService.retrieveProductsByGroup(group).size();
        //then
        Assert.assertEquals(expectedSize,actualSize);
    }
    @Test
    void showProductByCodeShouldReturnGivenCategoryForCode330435() {
        //given
        String code = "330435";
        Category expectedCategory = Category.TECHNIKAPOMIAROWA;

        //when
        Category actualCategory = null;
        Optional<Product> product = productService.retrieveProductByCode(code);
        if (product.isPresent()) {
            actualCategory = product.get().getCategory();
        }

        //then
        Assert.assertEquals(expectedCategory, actualCategory);

    }

    @Test
    void showProductByCodeShouldReturnGivenSubcategoryForCode0601010000() {
        //given
        String code = "0601010000";
        Subcategory expectedSubcategory = Subcategory.WYKRYWACZE;

        //when
        Optional<Product> product = productService.retrieveProductByCode(code);
        Subcategory actualSubcategory = product.get().getSubcategory();

        //then
        Assert.assertEquals(expectedSubcategory, actualSubcategory);

    }
    @Test
    void showProductByCodeShouldReturnReadProductModelWithCategoryTECHNIKAPOMIAROWA(){
        //given
        String code = "0601010000";
        String expectedCategory = "TECHNIKAPOMIAROWA";
        //when
        Optional<ProductEntityReading> readProductModel = productService.getProductByCode(code);
        String actualCategory = readProductModel.get().category;
        //then
        Assert.assertEquals(expectedCategory,actualCategory);
    }

    @Test()
    void createProductShouldThrowDuplicateCodeExceptionForProductWithCode0601010000() {
       //given
        ProductEntityWriting product = new ProductEntityWriting("0601010000", "bla", "TECHNIKAPOMIAROWA", "WYKRYWACZE",
                "ORINGI","url","des", 500.00, 1);
        String expectedMessage = "Product code 0601010000 in use";

        //when
        DuplicateProductCodeException exception = assertThrows(DuplicateProductCodeException.class, ()->
                productService.createProduct(product));
        String actualMessage = exception.getMessage();

        //then
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void getStringFromCategoryShouldReturnStringForGivenEnum(){
        //given
        Product product = new Product("0601010000", "bla", Category.TECHNIKAPOMIAROWA, Subcategory.WYKRYWACZE
                ,"url","des", BigDecimal.valueOf(500));

        String expectedCategoryString = "TECHNIKAPOMIAROWA";
        //when
        String actualCategoryString = product.getStringFromCategory();
        //then
        Assert.assertEquals(expectedCategoryString,actualCategoryString);
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
        productService.updateProduct(product);
        String actualDescription = productService.retrieveProductByCode("453").get().getDescription();
        //then
        Assert.assertEquals(expectedDescription,actualDescription);

    }



}
