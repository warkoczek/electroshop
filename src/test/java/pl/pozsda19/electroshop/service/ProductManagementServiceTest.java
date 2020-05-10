package pl.pozsda19.electroshop.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pl.pozsda19.electroshop.controller.mvc.ProductManagementMVCController;
import pl.pozsda19.electroshop.controller.rest.ProductManagementController;
import pl.pozsda19.electroshop.domain.dto.ProductEntityWriting;
import pl.pozsda19.electroshop.domain.dto.ProductMapper;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductManagementController.class)
@ExtendWith(SpringExtension.class)
class ProductManagementServiceTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ProductManagementService productManagementService;
    @Captor
    private ArgumentCaptor<ProductEntityWriting> argumentCaptor;

    @Test
    void postingShouldCreateANewProductInTheDatabase() throws Exception {
        //given
        ProductEntityWriting writtenProductEntity = new ProductEntityWriting();
        writtenProductEntity.setCode("1234");
        writtenProductEntity.setName("wiertarka udarowa");
        writtenProductEntity.setCategory("ELEKTRONARZEDZIA");
        writtenProductEntity.setSubcategory("AKUMULATOROWE");
        writtenProductEntity.setGroupo("BOSCH");
        writtenProductEntity.setDescription("fajna");
        writtenProductEntity.setImageURL("imageURLWiertarkiUdarowej");
        writtenProductEntity.setPrice(50.00);
        writtenProductEntity.setQuantity(20);

        when(productManagementService.createProduct(argumentCaptor.capture()).getCode()).thenReturn("1234");

        this.mockMvc.perform(post("/productManagement/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(writtenProductEntity)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect((header().string("Location", "http://localhost/productManagement/create/1234")));

        assertThat(argumentCaptor.getValue().getCode(), is("1234"));
        assertThat(argumentCaptor.getValue().getName(), is("wiertarka udarowa"));
        assertThat(argumentCaptor.getValue().getCategory(), is("ELEKTRONARZEDZIA"));
        assertThat(argumentCaptor.getValue().getSubcategory(), is("AKUMULATOROWE"));
        assertThat(argumentCaptor.getValue().getGroupo(), is("BOSCH"));
        assertThat(argumentCaptor.getValue().getDescription(), is("fajna"));
        assertThat(argumentCaptor.getValue().getImageURL(), is("imageURLWiertarkiUdarowej"));
        assertThat(argumentCaptor.getValue().getPrice(), is(50.00));
        assertThat(argumentCaptor.getValue().getQuantity(), is(20));

    }
}
