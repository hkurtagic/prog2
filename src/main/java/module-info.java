module at.ac.fhcampuswien.fhmdb {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.jfoenix;
    requires okhttp3;
    requires com.google.gson;
    requires com.h2database;
    requires ormlite.jdbc;
    requires java.sql;

    opens at.ac.fhcampuswien.fhmdb.database to ormlite.jdbc;
    opens at.ac.fhcampuswien.fhmdb to javafx.fxml;
    opens at.ac.fhcampuswien.fhmdb.models to com.google.gson;
    opens at.ac.fhcampuswien.fhmdb.bin to com.google.gson;

    exports at.ac.fhcampuswien.fhmdb;
    exports at.ac.fhcampuswien.fhmdb.controllers;
    opens at.ac.fhcampuswien.fhmdb.controllers to javafx.fxml;
}