
import java.sql.Connection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.hibernate.Session;

public class Controller {

    Connection connection;

    @FXML
    private Tab model;

    @FXML
    private TextField model_model_id;

    @FXML
    private TextField model_name;

    @FXML
    private TextField model_category;

    @FXML
    private TextField model_capacity;

    @FXML
    private Tab bus;

    @FXML
    private TextField bus_bus_id;

    @FXML
    private TextField bus_model_id;

    @FXML
    private TextField bus_route_id;

    @FXML
    private Tab route;

    @FXML
    private TextField route_route_id;

    @FXML
    private TextField route_name;

    @FXML
    private TextField route_length;

    @FXML
    private TextField route_passenger_traffic;

    @FXML
    private Tab driver;

    @FXML
    private TextField driver_driver_id;

    @FXML
    private TextField driver_bus_id;

    @FXML
    private TextField driver_full_name;

    @FXML
    private TextField driver_allowed_categories;

    @FXML
    private TextField driver_working_hours;

    @FXML
    private TextField capacity;

    @FXML
    private TextField length;

    @FXML
    private TextField idChange;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField randomCount;

    int currentTab() {
        if (model.isSelected()) return 1;
        if (bus.isSelected()) return 2;
        if (route.isSelected()) return 3;
        if (driver.isSelected()) return 4;
        return 0;
    }

    @FXML
    //Поиск по коду товара
    public void findALL(ActionEvent actionEvent) throws SQLException {
        textArea.clear();
        connection = Model.getConnection();
        switch (currentTab()) {
            case 1:
                textArea.setText(textArea.getText() + Model.findAllmodel(connection, model_model_id.getText(), model_name.getText(), model_category.getText(), model_capacity.getText()));
                break;
            case 2:
                textArea.setText(textArea.getText() + Model.findAllbus(connection, bus_bus_id.getText(), bus_model_id.getText(), bus_route_id.getText()));
                break;
            case 3:
                textArea.setText(textArea.getText() + Model.findAllroute(connection, route_route_id.getText(), route_name.getText(), route_length.getText(), route_passenger_traffic.getText()));
                break;
            case 4:
                textArea.setText(textArea.getText() + Model.findAlldriver(connection, driver_driver_id.getText(), driver_bus_id.getText(), driver_full_name.getText(), driver_allowed_categories.getText(), driver_working_hours.getText()));
                break;
            default:
                break;
        }
    }

    @FXML
    //Поиск по коду товара
    public void create(ActionEvent actionEvent) throws SQLException {
        textArea.clear();
        connection = Model.getConnection();
        switch (currentTab()) {
            case 1:
                textArea.setText(textArea.getText() + Model.createModel(connection, model_model_id.getText(), model_name.getText(), model_category.getText(), model_capacity.getText()));
                break;
            case 2:
                textArea.setText(textArea.getText() + Model.createBus(connection, bus_bus_id.getText(), bus_model_id.getText(), bus_route_id.getText()));
                break;
            case 3:
                textArea.setText(textArea.getText() + Model.createRoute(connection, route_route_id.getText(), route_name.getText(), route_length.getText(), route_passenger_traffic.getText()));
                break;
            case 4:
                textArea.setText(textArea.getText() + Model.createDriver(connection, driver_driver_id.getText(), driver_bus_id.getText(), driver_full_name.getText(), driver_allowed_categories.getText(), driver_working_hours.getText()));
                break;
            default:
                break;
        }
    }

    @FXML
    //Поиск по коду товара
    public void delete(ActionEvent actionEvent) throws SQLException {
        textArea.clear();
        connection = Model.getConnection();
        switch (currentTab()) {
            case 1:
                textArea.setText(textArea.getText() + Model.deleteModel(connection, model_model_id.getText(), model_name.getText(), model_category.getText(), model_capacity.getText()));
                break;
            case 2:
                textArea.setText(textArea.getText() + Model.deleteBus(connection, bus_bus_id.getText(), bus_model_id.getText(), bus_route_id.getText()));
                break;
            case 3:
                textArea.setText(textArea.getText() + Model.deleteRoute(connection, route_route_id.getText(), route_name.getText(), route_length.getText(), route_passenger_traffic.getText()));
                break;
            case 4:
                textArea.setText(textArea.getText() + Model.deleteDriver(connection, driver_driver_id.getText(), driver_bus_id.getText(), driver_full_name.getText(), driver_allowed_categories.getText(), driver_working_hours.getText()));
                break;
            default:
                break;
        }
    }

    public void genRandom(ActionEvent actionEvent) throws SQLException {
        textArea.clear();
        connection = Model.getConnection();
        textArea.setText(textArea.getText() + Model.genRandom(connection, randomCount.getText(), currentTab()));
    }


    @FXML
    //Поиск по коду товара
    public void change(ActionEvent actionEvent) throws SQLException {
        textArea.clear();
        connection = Model.getConnection();
        switch (currentTab()) {
            case 1:
                textArea.setText(textArea.getText() + Model.changeModel(connection, model_model_id.getText(), model_name.getText(), model_category.getText(), model_capacity.getText(), idChange.getText()));
                break;
            case 2:
                textArea.setText(textArea.getText() + Model.changeBus(connection, bus_bus_id.getText(), bus_model_id.getText(), bus_route_id.getText(), idChange.getText()));
                break;
            case 3:
                textArea.setText(textArea.getText() + Model.changeRoute(connection, route_route_id.getText(), route_name.getText(), route_length.getText(), route_passenger_traffic.getText(), idChange.getText()));
                break;
            case 4:
                textArea.setText(textArea.getText() + Model.changeDriver(connection, driver_driver_id.getText(), driver_bus_id.getText(), driver_full_name.getText(), driver_allowed_categories.getText(), driver_working_hours.getText(), idChange.getText()));
                break;
            default:
                break;
        }
    }


    @FXML
    public void interface1(ActionEvent actionEvent) throws SQLException {
        textArea.clear();
        connection = Model.getConnection();
        textArea.setText(textArea.getText() + Model.getInterface1(connection, capacity.getText(), length.getText()));
    }

    @FXML
    //Поиск по коду товара
    public void testHASH(ActionEvent actionEvent) throws SQLException {
        textArea.clear();
        connection = Model.getConnection();
        textArea.setText(textArea.getText() + Model.HASH(connection));
    }

    public void testBRIN(ActionEvent actionEvent) throws SQLException {
        textArea.clear();
        connection = Model.getConnection();
        textArea.setText(textArea.getText() + Model.BRIN(connection));
    }
}
