package com.devhoss.resource;

import com.devhoss.api.TablesApi;
import com.devhoss.model.ApiTable;
import com.devhoss.services.CategoriesService;
import com.devhoss.services.TablesService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

public class TablesResource implements TablesApi{

    private final TablesService tablesService;

    @Inject
    public TablesResource(TablesService tablesService) {
        this.tablesService = tablesService;
    }

    @Override
    public Response createTable(ApiTable apiTable) {
        return null;
    }

    @Override
    public Response deleteTableById(String tableId) {
        return null;
    }

    @Override
    public Response getTableById(String tableId) {
        return null;
    }

    @Override
    public Response getTables() {
        return Response.ok(tablesService.getAll()).build();
    }

    @Override
    public Response updateTableById(String tableId, ApiTable apiTable) {
        return null;
    }
}
