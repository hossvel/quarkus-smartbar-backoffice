package com.devhoss.mapper;

import com.devhoss.model.ApiCategory;
import com.devhoss.model.Category;
import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface MappingCategories {

    @Mapping(target = "id", ignore = true)
    void mapApiCategoryToCategory(ApiCategory apiCategory, @MappingTarget Category category);

    ApiCategory mapCategoryToApiCategory(Category category);

}
