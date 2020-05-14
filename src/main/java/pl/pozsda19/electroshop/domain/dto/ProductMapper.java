package pl.pozsda19.electroshop.domain.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import pl.pozsda19.electroshop.domain.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductEntityReading readProductEntity(Product product);

    Product writeProductEntity(ProductEntityWriting toProductEntity);

}
