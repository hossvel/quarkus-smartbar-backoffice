package com.devhoss.resource;

import com.devhoss.api.TablesApi;
import com.devhoss.model.Table;
import jakarta.ws.rs.core.Response;

public class TablesResource implements TablesApi {
    @Override
    public Response createTable(Table table) {
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
        return null;
    }

    @Override
    public Response updateTableById(String tableId, Table table) {
        return null;
    }
}
