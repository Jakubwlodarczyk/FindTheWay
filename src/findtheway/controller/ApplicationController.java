package findtheway.controller;

import findtheway.database.DatabaseConnection;

public class ApplicationController {

    DatabaseConnection databaseConnection;

    public void initApplication() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.getVertexes();
        databaseConnection.getEdges();

    }
}