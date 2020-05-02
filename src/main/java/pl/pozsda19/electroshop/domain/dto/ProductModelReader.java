package pl.pozsda19.electroshop.domain.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import pl.pozsda19.electroshop.domain.Product;



public interface ProductModelReader {

    static TypeMap<Product, ShowProductModel>  getTypeMap(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.addMappings(getPropertyMap());


    }

    private static PropertyMap<Product, ShowProductModel> getPropertyMap(){
        return new PropertyMap<Product, ShowProductModel>() {
            @Override
            protected void configure() {
                map().setName(source.getName());
                map().setCode(source.getCode());
                map().setCategory(source.getCategory());
                map().setSubcategory(source.getSubcategory());
                map().setGroupo(source.getGroupo());
                map().setImageURL(source.getImageURL());
                map().setDescription(source.getDescription());
                map().setPrice(source.getPrice());
            }
        };
    }


}
