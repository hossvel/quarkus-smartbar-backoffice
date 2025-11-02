package com.devhoss.resource;

import com.devhoss.api.TablesApi;
import com.devhoss.mapper.MappingTables;
import com.devhoss.model.ApiTable;
import com.devhoss.model.Table;
import com.devhoss.services.CategoriesService;
import com.devhoss.services.TablesService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class TablesResource implements TablesApi {

    private final TablesService tablesService;
    private final MappingTables mappingTables;

    @Inject
    public TablesResource(TablesService tablesService,MappingTables mappingTables) {
        this.tablesService = tablesService;
        this.mappingTables = mappingTables;
    }

    @Override
    public Response createTable(ApiTable apiTable) {
        final Table table = new Table();
        mappingTables.mapApiTableToTable(apiTable, table);
        final Table persitedTable = tablesService.persit(table);
        return Response.created(URI.create("/tables/" + persitedTable.getId())).build();
    }

    @Override
    public Response deleteTableById(Long tableId) {

        final Optional<Table> table = tablesService.deleteById(tableId);
        if (table.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().build();
    }

    @Override
    public Response getTableById(Long tableId) {
        final Optional<Table> table = tablesService.getById(tableId);
        if (table.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(mappingTables.mapTableToApiTable(table.get())).build();
    }

    @Override
    public Response getTables() {
        final List<Table> tables = tablesService.listAll();
        return Response.ok(tables.stream().map(mappingTables::mapTableToApiTable).toList())
                .build();
    }

    @Override
    public Response updateTableById(Long tableId, ApiTable apiTable) {
        final Optional<Table> existingTable = tablesService.getById(tableId);
        if (existingTable.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Table table = existingTable.get();
        mappingTables.mapApiTableToTable(apiTable, table);
        tablesService.update(table);
        return Response.ok().build();
    }
}
