package com.devhoss.mapper;

import com.devhoss.model.ApiTable;
import com.devhoss.model.Table;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MappingTables {

    public void mapApiTableToTable(ApiTable apiTable, Table table) {
        table.setName(apiTable.getName());
        table.setSeatCount(apiTable.getSeatCount());
        table.setActive(apiTable.getActive());
    }

    public ApiTable mapTableToApiTable(Table table) {
        final ApiTable apiTable = new ApiTable();
        apiTable.setActive(table.getActive());
        apiTable.setName(table.getName());
        apiTable.setSeatCount(table.getSeatCount());
        apiTable.setId(table.getId());
        return apiTable;
    }
}
