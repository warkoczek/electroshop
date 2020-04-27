package pl.pozsda19.electroshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProductServiceTest {

    private final ProductService productService;

    ProductServiceTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    void showAllProducts() {

    }

    @Test
    void addProduct() {
    }
}
