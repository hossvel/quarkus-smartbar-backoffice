package com.devhoss.resource;

import com.devhoss.api.TablesApi;
import com.devhoss.model.ApiTable;
import com.devhoss.model.Table;
import com.devhoss.services.CategoriesService;
import com.devhoss.services.TablesService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.net.URI;

public class TablesResource implements TablesApi{

    private final TablesService tablesService;

    @Inject
    public TablesResource(TablesService tablesService) {

        this.tablesService = tablesService;
    }

    @Override
    public Response createTable(ApiTable apiTable) {

        final Table table = new Table();
        table.setName(apiTable.getName());
        table.setSeatCount(apiTable.getSeatCount());
        table.setActive(apiTable.getActive());

        final Table persitedTable = tablesService.persit(table);
        System.out.println("TABLE ID: " + persitedTable.getId());
        return Response.created(URI.create("/tables/" + persitedTable.getId())).build();


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
       return null;
       // return Response.ok(tablesService.getAll()).build();
    }

    @Override
    public Response updateTableById(String tableId, ApiTable apiTable) {
        return null;
    }
}
