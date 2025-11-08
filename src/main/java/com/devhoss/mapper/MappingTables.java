package com.devhoss.mapper;

import com.devhoss.model.ApiTable;
import com.devhoss.model.Table;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface MappingTables {

    @Mapping(target = "id", ignore = true)
    void mapApiTableToTable(ApiTable apiTable, @MappingTarget Table table);

    ApiTable mapTableToApiTable(Table table);

}
