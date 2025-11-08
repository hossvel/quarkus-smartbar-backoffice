package com.devhoss.resource;

import com.devhoss.api.TablesApi;
import com.devhoss.mapper.MappingTables;
import com.devhoss.model.ApiTable;
import com.devhoss.model.Table;
import com.devhoss.repository.TableRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@Transactional
public class TablesResource implements TablesApi {


    private final MappingTables mappingTables;
    private final TableRepository tableRepository;

    @Inject
    public TablesResource(MappingTables mappingTables, TableRepository tableRepository) {

        this.mappingTables = mappingTables;
        this.tableRepository = tableRepository;
    }

    @Override
    public Response createTable(ApiTable apiTable) {
        final Table table = new Table();
        mappingTables.mapApiTableToTable(apiTable, table);
        tableRepository.persist(table);
        return Response.created(URI.create("/tables/" + table.getId())).build();
    }

    @Override
    public Response deleteTableById(Long tableId) {

        final Optional<Table> table = tableRepository.findByIdOptional(tableId);
        if (table.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        tableRepository.delete(table.get());
        return Response.ok().build();
    }

    @Override
    public Response getTableById(Long tableId) {
        final Optional<Table> table = tableRepository.findByIdOptional(tableId);
        if (table.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(mappingTables.mapTableToApiTable(table.get())).build();
    }

    @Override
    public Response getTables() {
        final List<Table> tables = tableRepository.listAll();
        return Response.ok(tables.stream().map(mappingTables::mapTableToApiTable).toList())
                .build();
    }

    @Override
    public Response updateTableById(Long tableId, ApiTable apiTable) {
        final Optional<Table> existingTable = tableRepository.findByIdOptional(tableId);
        if (existingTable.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Table table = existingTable.get();
        mappingTables.mapApiTableToTable(apiTable, table);

        return Response.ok().build();
    }
}
