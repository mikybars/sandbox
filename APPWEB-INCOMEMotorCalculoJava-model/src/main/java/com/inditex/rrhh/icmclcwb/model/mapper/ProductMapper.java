package com.inditex.rrhh.icmclcwb.model.mapper;

import com.inditex.rrhh.icmclcwb.api.dto.ProductDTO;
import com.inditex.rrhh.icmclcwb.model.repository.Product;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface ProductMapper {

    ProductDTO asProductDTO(Product src);

    Product asProduct(ProductDTO src);

    List<ProductDTO> asProductDTOs(List<Product> src);
}
