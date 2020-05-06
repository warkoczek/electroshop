package pl.pozsda19.electroshop.domain.dto;

import org.mapstruct.Mapper;
import pl.pozsda19.electroshop.domain.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ReadProductModel fromProductEntity(Product product);
}
