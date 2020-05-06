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
import pl.pozsda19.electroshop.domain.dto.ReadProductModel;
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
        Optional<ReadProductModel> readProductModel = productService.showProductByCode(code);
        String actualCategory = readProductModel.get().category;
        //then
        Assert.assertEquals(expectedCategory,actualCategory);
    }



    @Test()
    void addProductShouldThrowDuplicateCodeExceptionForProductWithCode0601010000() {
       //given
        Product product = new Product("0601010000", "bla", Category.TECHNIKAPOMIAROWA, Subcategory.WYKRYWACZE
                ,"url","des", BigDecimal.valueOf(500));
        String expectedMessage = "Product code 0601010000 in use";

        //when
        DuplicateProductCodeException exception = assertThrows(DuplicateProductCodeException.class, ()->
                productService.addProduct(product));
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

}
