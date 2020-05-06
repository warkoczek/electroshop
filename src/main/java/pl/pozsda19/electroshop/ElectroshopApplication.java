package pl.pozsda19.electroshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.Subcategory;

import java.math.BigDecimal;

@SpringBootApplication
public class ElectroshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectroshopApplication.class, args);

	}


}
