package com.devhoss.resource;

import com.devhoss.api.TablesApi;
import com.devhoss.mapper.MappingTables;
import com.devhoss.model.ApiTable;
import com.devhoss.model.Table;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@Transactional
public class TablesResource implements TablesApi {


    private final MappingTables mappingTables;

    @Inject
    public TablesResource(MappingTables mappingTables) {

        this.mappingTables = mappingTables;
    }

    @Override
    public Response createTable(ApiTable apiTable) {
        final Table table = new Table();
        mappingTables.mapApiTableToTable(apiTable, table);
        table.persist();
        return Response.created(URI.create("/tables/" + table.id)).build();
    }

    @Override
    public Response deleteTableById(Long tableId) {

        final Optional<Table> table = Table.findByIdOptional(tableId);
        if (table.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        table.get().delete();
        return Response.ok().build();
    }

    @Override
    public Response getTableById(Long tableId) {
        final Optional<Table> table = Table.findByIdOptional(tableId);
        if (table.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(mappingTables.mapTableToApiTable(table.get())).build();
    }

    @Override
    public Response getTables() {
        final List<Table> tables = Table.listAll();
        return Response.ok(tables.stream().map(mappingTables::mapTableToApiTable).toList())
                .build();
    }

    @Override
    public Response updateTableById(Long tableId, ApiTable apiTable) {
        final Optional<Table> existingTable = Table.findByIdOptional(tableId);
        if (existingTable.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Table table = existingTable.get();
        mappingTables.mapApiTableToTable(apiTable, table);

        return Response.ok().build();
    }
}
