package com.devhoss;


import com.devhoss.mapper.MappingCategories;
import com.devhoss.model.ApiCategory;
import com.devhoss.model.Category;
import com.devhoss.services.CategoriesService;
import io.quarkus.test.Mock;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Mock
public class MockCategoriesService extends CategoriesService {

   // private final MappingCategories mappingCategories;

    //@Inject
    //public MockCategoriesService(MappingCategories mappingCategories) {

     //   this.mappingCategories = mappingCategories;
    //}

    //private final ApiCategory category = new ApiCategory().name("drinksMockService");
    //public List<ApiCategory> listAll() {

      //  final List<ApiCategory> categories = List.of(category);

        //return categories.stream().map(mappingCategories::mapCategoryToApiCategory).toList();
    //}
}