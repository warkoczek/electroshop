package pl.pozsda19.electroshop.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.Subcategory;

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProductServiceTest {

    @Autowired
    private ProductService productService;


    @Test
    void showProductByCodeShouldReturnGivenCategoryForCode330435(){
        //given
        String code = "330435";
        Category expectedCategory = Category.CZESCIZAMIENNE;

        //when
        Optional<Product> product = productService.showProductByCode(code);
        Category actualCategory = product.get().getCategory();

        //then
        Assert.assertEquals(expectedCategory,actualCategory);

    }

    @Test
    void showProductByCodeShouldReturnGivenCategoryForCode0601010000(){
        //given
        String code = "0601010000";
        Subcategory expectedSubcategory = Subcategory.WYKRYWACZE;

        //when
        Optional<Product> product = productService.showProductByCode(code);
        Subcategory actualSubcategory = product.get().getSubcategory();

        //then
        Assert.assertEquals(expectedSubcategory,actualSubcategory);

    }



    @Test
    void addProduct() {
    }
}
