
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.*;

class Model {

    static final String user = "postgres";
    static final String password = "password";
    static final String url = "jdbc:postgresql://localhost:5432/BusDepot";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static String findAllmodel(Connection connection, String model_id, String name, String category, String capacity) throws SQLException {

        if (!model_id.matches("\\d+|") || !capacity.matches("\\d+|")) {
            return "Некоректний ввід даних!";
        }

        String sql = "SELECT * FROM public.model WHERE";
        sql += " model_id = " + (model_id.length() > 0 ? model_id : "model_id");
        sql += " and name like " + (name.length() > 0 ? ("'%" + name + "%'") : "name");
        sql += " and category = " + (category.length() > 0 ? category : "category");
        sql += " and capacity = " + (capacity.length() > 0 ? capacity : "capacity");

        System.out.println("sql: " + sql);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String resultStr = "Результат пошуку по заданим параметрам:\n";
            try {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    resultStr += "-> model_id = " + resultSet.getInt(1);
                    resultStr += " name = " + resultSet.getString(2);
                    resultStr += " category = " + resultSet.getString(3);
                    resultStr += " capacity = " + resultSet.getInt(4);
                    resultStr += "\n";
                }
            } catch (Exception ex) {
                return ex.getMessage();
            }
            return (!resultStr.equals("Результат пошуку по заданим параметрам:\n") ? resultStr : "Нічого не знайдено!");
        }
    }

    public static String findAllbus(Connection connection, String bus_id, String model_id, String route_id) throws SQLException {

        if (!bus_id.matches("\\d+|") || !model_id.matches("\\d+|") || !route_id.matches("\\d+|")) {
            return "Некоректний ввід даних!";
        }

        String sql = "SELECT * FROM public.bus WHERE";
        sql += " bus_id = " + (bus_id.length() > 0 ? bus_id : "bus_id");
        sql += " and model_id = " + (model_id.length() > 0 ? model_id : "model_id");
        sql += " and route_id = " + (route_id.length() > 0 ? route_id : "route_id");

        System.out.println("sql: " + sql);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String resultStr = "Результат пошуку по заданим параметрам:\n";
            try {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    resultStr += "-> bus_id = " + resultSet.getInt(1);
                    resultStr += " model_id = " + resultSet.getInt(2);
                    resultStr += " route_id = " + resultSet.getInt(3);
                    resultStr += "\n";
                }
            } catch (Exception ex) {
                return ex.getMessage();
            }
            return (!resultStr.equals("Результат пошуку по заданим параметрам:\n") ? resultStr : "Нічого не знайдено!");
        }
    }

    public static String findAllroute(Connection connection, String route_id, String name, String length, String passenger_traffic) throws SQLException {

        if (!route_id.matches("[+]?\\d+|") || !length.matches("[+]?\\d+|") || !passenger_traffic.matches("[+]?\\d+|")) {
            return "Некоректний ввід даних!";
        }

        String sql = "SELECT * FROM public.route WHERE";
        sql += " route_id = " + (route_id.length() > 0 ? route_id : "route_id");
        sql += " and name like " + (name.length() > 0 ? ("'%" + name + "%'") : "name");
        sql += " and length = " + (length.length() > 0 ? length : "length");
        sql += " and passenger_traffic = " + (passenger_traffic.length() > 0 ? passenger_traffic : "passenger_traffic");

        System.out.println("sql: " + sql);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String resultStr = "Результат пошуку по заданим параметрам:\n";
            try {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    resultStr += "-> route_id = " + resultSet.getInt(1);
                    resultStr += " name = " + resultSet.getString(2);
                    resultStr += " length = " + resultSet.getInt(3);
                    resultStr += " passenger_traffic = " + resultSet.getInt(4);
                    resultStr += "\n";
                }
            } catch (Exception ex) {
                return ex.getMessage();
            }
            return (!resultStr.equals("Результат пошуку по заданим параметрам:\n") ? resultStr : "Нічого не знайдено!");
        }
    }

    public static String findAlldriver(Connection connection, String driver_id, String bus_id, String full_name, String allowed_categories, String working_hours) throws SQLException {

        if (!driver_id.matches("\\d+|") || !bus_id.matches("\\d+|") || !working_hours.matches("\\d+|")) {
            return "Некоректний ввід даних!";
        }

        String sql = "SELECT * FROM public.driver WHERE";
        sql += " driver_id = " + (driver_id.length() > 0 ? driver_id : "driver_id");
        sql += " and bus_id = " + (bus_id.length() > 0 ? bus_id : "bus_id");
        sql += " and full_name like " + (full_name.length() > 0 ? ("'%" + full_name + "%'") : "full_name");
        sql += " and allowed_categories like " + (allowed_categories.length() > 0 ? ("'%" + allowed_categories + "%'") : "allowed_categories");
        sql += " and working_hours = " + (working_hours.length() > 0 ? working_hours : "working_hours");

        System.out.println("sql: " + sql);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String resultStr = "Результат пошуку по заданим параметрам:\n";
            try {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    resultStr += "-> driver_id = " + resultSet.getInt(1);
                    resultStr += " bus_id = " + resultSet.getInt(2);
                    resultStr += " full_name = " + resultSet.getString(3);
                    resultStr += " allowed_categories = " + resultSet.getString(4);
                    resultStr += " working_hours = " + resultSet.getInt(5);
                    resultStr += "\n";
                }
            } catch (Exception ex) {
                return ex.getMessage();
            }
            return (!resultStr.equals("Результат пошуку по заданим параметрам:\n") ? resultStr : "Нічого не знайдено!");
        }
    }

    public static String createModel(Connection connection, String model_id, String name, String category, String capacity) throws SQLException {

        if (!model_id.matches("\\d+")|| !capacity.matches("\\d+|") || name.equals("") || category.equals("")) {
            return "Некоректний ввід даних!";
        }

        String sql = "INSERT INTO public.model (model_id, name, category, capacity) VALUES (";
        sql += model_id + ", ";
        sql += "'" + name + "', ";
        sql += "'" + category + "', ";
        sql += capacity + ")";

        System.out.println("sql: " + sql);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        String answer = "Створено:\n";
        answer += "-> model_id = " + model_id;
        answer += " name = " + name;
        answer += " category = " + category;
        answer += " capacity = " + capacity;

        return answer;
    }

    public static String createBus(Connection connection, String bus_id, String model_id, String route_id) throws SQLException {

        if (!bus_id.matches("\\d+") || !model_id.matches("\\d+") || !route_id.matches("\\d+")) {
            return "Некоректний ввід даних!";
        }

        String sql = "INSERT INTO public.bus (bus_id, model_id, route_id) VALUES (";
        sql += bus_id + ", ";
        sql += model_id + ", ";
        sql += route_id + ")";

        System.out.println("sql: " + sql);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        String answer = "Створено:\n";
        answer += "-> bus_id = " + bus_id;
        answer += " model_id = " + model_id;
        answer += " route_id = " + route_id;

        return answer;
    }

    public static String createRoute(Connection connection, String route_id, String name, String length, String passenger_traffic) throws SQLException {

        if (!route_id.matches("[+]?\\d+|") || !length.matches("[+]?\\d+|") || !passenger_traffic.matches("[+]?\\d+|") || name.equals("")) {
            return "Некоректний ввід даних!";
        }

        String sql = "INSERT INTO public.route (route_id, name, length, passenger_traffic) VALUES (";
        sql += route_id + ", ";
        sql += "'" + name + "', ";
        sql += length + ", ";
        sql += passenger_traffic + ")";

        System.out.println("sql: " + sql);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        String answer = "Створено:\n";
        answer += "-> route_id = " + route_id;
        answer += " name = " + name;

        return answer;
    }

    public static String createDriver(Connection connection, String driver_id, String bus_id, String full_name, String allowed_categories, String working_hours) throws SQLException {

        if (!driver_id.matches("\\d+|") || !bus_id.matches("\\d+|") || !working_hours.matches("\\d+|") || full_name.equals("") || allowed_categories.equals("")) {
            return "Некоректний ввід даних!";
        }

        String sql = "INSERT INTO public.driver (driver_id, bus_id, full_name, allowed_categories, working_hours) VALUES (";
        sql += driver_id + ", ";
        sql += bus_id + ", ";
        sql += "'" + full_name + "', ";
        sql += "'" + allowed_categories + "', ";
        sql += working_hours + ")";

        System.out.println("sql: " + sql);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        String answer = "Створено:\n";
        answer += "-> driver_id = " + driver_id;
        answer += " bus_id = " + bus_id;
        answer += " full_name = " + full_name;
        answer += " allowed_categories = " + allowed_categories;
        answer += " working_hours = " + working_hours;

        return answer;
    }

    public static String deleteModel(Connection connection, String model_id, String name, String category, String capacity) throws SQLException {

        if (!model_id.matches("\\d+|") || !capacity.matches("\\d+|")) {
            return "Некоректний ввід даних!";
        }

        String sql = "DELETE from driver where bus_id in (select bus_id from bus where model_id in (select model_id from model where";
        sql += " model_id = " + (model_id.length() > 0 ? model_id : "model_id");
        sql += " and name like " + (name.length() > 0 ? ("'%" + name + "%'") : "name");
        sql += " and category = " + (category.length() > 0 ? category : "category");
        sql += " and capacity = " + (capacity.length() > 0 ? capacity : "capacity") + "));\n";

        sql += "DELETE from bus where model_id in (select model_id from model where";
        sql += " model_id = " + (model_id.length() > 0 ? model_id : "model_id");
        sql += " and name like " + (name.length() > 0 ? ("'%" + name + "%'") : "name");
        sql += " and category = " + (category.length() > 0 ? category : "category");
        sql += " and capacity = " + (capacity.length() > 0 ? capacity : "capacity") + ");\n";

        sql += "DELETE from model where";
        sql += " model_id = " + (model_id.length() > 0 ? model_id : "model_id");
        sql += " and name like " + (name.length() > 0 ? ("'%" + name + "%'") : "name");
        sql += " and category = " + (category.length() > 0 ? category : "category");
        sql += " and capacity = " + (capacity.length() > 0 ? capacity : "capacity") + ";\n";

        System.out.println("sql: " + sql);

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        String answer = "Видалено все, де:\n->";
        if (model_id.length() > 0) answer += " model_id = " + model_id;
        if (name.length() > 0) answer += " name = " + name;
        if (category.length() > 0) answer += " category = " + category;
        if (capacity.length() > 0) answer += " capacity = " + capacity;

        return answer;
    }

    public static String deleteBus(Connection connection, String bus_id, String model_id, String route_id) throws SQLException {

        if (!bus_id.matches("\\d+") || !model_id.matches("\\d+") || !route_id.matches("\\d+")) {
            return "Некоректний ввід даних!";
        }

        String sql = "DELETE from driver where bus_id in (select bus_id from bus where";
        sql += " bus_id = " + (bus_id.length() > 0 ? bus_id : "bus_id");
        sql += " and model_id = " + (model_id.length() > 0 ? model_id : "model_id");
        sql += " and route_id = " + (route_id.length() > 0 ? route_id : "route_id") + ");\n";

        sql += "DELETE from bus where";
        sql += " bus_id = " + (bus_id.length() > 0 ? bus_id : "bus_id");
        sql += " and model_id = " + (model_id.length() > 0 ? model_id : "model_id");
        sql += " and route_id = " + (route_id.length() > 0 ? route_id : "route_id") + ";\n";
        System.out.println("sql: " + sql);

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        String answer = "Видалено все, де:\n->";
        if (bus_id.length() > 0) answer += "-> bus_id = " + bus_id;
        if (model_id.length() > 0) answer += " model_id = " + model_id;
        if (route_id.length() > 0) answer += " route_id = " + route_id;

        return answer;
    }

    public static String deleteRoute(Connection connection, String route_id, String name, String length, String passenger_traffic) throws SQLException {

        if (!route_id.matches("[+]?\\d+|") || !length.matches("[+]?\\d+|") || !passenger_traffic.matches("[+]?\\d+|")) {
            return "Некоректний ввід даних!";
        }
        String sql = "DELETE from driver where bus_id in (select bus_id from bus where route_id in (select route_id from route where";
        sql += " route_id = " + (route_id.length() > 0 ? route_id : "route_id");
        sql += " and name like " + (name.length() > 0 ? ("'%" + name + "%'") : "name");
        sql += " and length = " + (length.length() > 0 ? length : "length");
        sql += " and passenger_traffic = " + (passenger_traffic.length() > 0 ? passenger_traffic : "passenger_traffic") + "));\n";

        sql += "DELETE from bus where route_id in (select route_id from route where";
        sql += " route_id = " + (route_id.length() > 0 ? route_id : "route_id");
        sql += " and name like " + (name.length() > 0 ? ("'%" + name + "%'") : "name");
        sql += " and length = " + (length.length() > 0 ? length : "length");
        sql += " and passenger_traffic = " + (passenger_traffic.length() > 0 ? passenger_traffic : "passenger_traffic") + ");\n";

        sql += "DELETE from route where";
        sql += " route_id = " + (route_id.length() > 0 ? route_id : "route_id");
        sql += " and name like " + (name.length() > 0 ? ("'%" + name + "%'") : "name");
        sql += " and length = " + (length.length() > 0 ? length : "length");
        sql += " and passenger_traffic = " + (passenger_traffic.length() > 0 ? passenger_traffic : "passenger_traffic") + ";\n";

        System.out.println("sql: " + sql);

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        String answer = "Видалено все, де:\n->";
        if (route_id.length() > 0) answer += " route_id = " + route_id;
        if (name.length() > 0) answer += " name = " + name;

        return answer;
    }

    public static String deleteDriver(Connection connection, String driver_id, String bus_id, String full_name, String allowed_categories, String working_hours) throws SQLException {

        if (!driver_id.matches("\\d+|") || !bus_id.matches("\\d+|") || !working_hours.matches("\\d+|")) {
            return "Некоректний ввід даних!";
        }

        String sql = "DELETE from driver where";
        sql += " driver_id = " + (driver_id.length() > 0 ? driver_id : "driver_id");
        sql += " and bus_id = " + (bus_id.length() > 0 ? bus_id : "bus_id");
        sql += " and full_name like " + (full_name.length() > 0 ? ("'%" + full_name + "%'") : "full_name");
        sql += " and allowed_categories like " + (allowed_categories.length() > 0 ? ("'%" + allowed_categories + "%'") : "allowed_categories");
        sql += " and working_hours = " + (working_hours.length() > 0 ? working_hours : "working_hours");

        System.out.println("sql: " + sql);

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        String answer = "Видалено все, де:\n->";
        if (driver_id.length() > 0) answer += " driver_id = " + driver_id;
        if (bus_id.length() > 0) answer += " bus_id = " + bus_id;
        if (full_name.length() > 0) answer += " full_name = " + full_name;
        if (allowed_categories.length() > 0) answer += " allowed_categories = " + allowed_categories;
        if (working_hours.length() > 0) answer += " working_hours = " + working_hours;

        return answer;
    }

    public static String genRandom(Connection connection, String count, int currentTab) throws SQLException {
        if (count.equals("")) count = "20";
        if (!count.matches("\\d+")) {
            return "Некоректний ввід даних!";
        }
        String sql = "";

        switch (currentTab) {
            case 1:
                sql = "INSERT INTO public.model (model_id, name, category, capacity) VALUES ((select max(model_id) from model) + 1, substr(md5(random()::text), 0, 25), substr(md5(random()::text), 0, 25), FLOOR(RANDOM() * 100))";
                break;
            case 2:
                sql = "INSERT INTO public.bus (bus_id, model_id, route_id) VALUES ((select max(bus_id) from bus) + 1,(select model_id from model order by random() limit 1), (select route_id from route order by random() limit 1))";
                break;
            case 3:
                sql = "INSERT INTO public.route (route_id, name, length, passenger_traffic) VALUES ((select max(route_id) from route) + 1, substr(md5(random()::text), 0, 25), FLOOR(RANDOM() * 100), FLOOR(RANDOM() * 100))";
                break;
            case 4:
                sql = "INSERT INTO public.driver (driver_id, bus_id, full_name, allowed_categories, working_hours) VALUES ((select max(driver_id) from driver) + 1, (select bus_id from bus order by random() limit 1), substr(md5(random()::text), 0, 25), substr(md5(random()::text), 0, 25), FLOOR(RANDOM() * 100))";
                break;
            default:
                break;
        }

        for (int i = 0; i < parseInt(count); i++) {
            System.out.println(i);

            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return "Об'єкти створені!";
    }

    public static String changeModel(Connection connection, String model_id, String name, String category, String capacity, String id) throws SQLException {

        if (!id.matches("\\d+") || !model_id.matches("\\d+") || !capacity.matches("\\d+|") || name.equals("") || category.equals("")) {
            return "Некоректний ввід даних!";
        }

        String sql = "UPDATE public.bus SET";
        sql += " model_id = " + (model_id.length() > 0 ? model_id : "model_id") + ";\n";

        sql += "UPDATE public.model SET";
        sql += " model_id = " + (model_id.length() > 0 ? model_id : "model_id");
        sql += ", name = " + (name.length() > 0 ? ("'" + name + "'") : "name");
        sql += ", category = " + (category.length() > 0 ? category : "category");
        sql += ", capacity = " + (capacity.length() > 0 ? capacity : "capacity");
        sql += " WHERE model_id = " + id;

        System.out.println("sql: " + sql);

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        return "Оновлено обьект з id = " + id;
    }

    public static String changeBus(Connection connection, String bus_id, String model_id, String route_id, String id) throws SQLException {

        if (!id.matches("\\d+") || !bus_id.matches("\\d+") || !model_id.matches("\\d+") || !route_id.matches("\\d+")) {
            return "Некоректний ввід даних!";
        }

        String sql = "UPDATE public.bus SET";
        sql += " bus_id = " + (bus_id.length() > 0 ? bus_id : "bus_id");
        sql += ", model_id = " + (model_id.length() > 0 ? model_id : "model_id");
        sql += ", route_id = " + (route_id.length() > 0 ? route_id : "route_id");
        sql += " WHERE bus_id = " + id;

        System.out.println("sql: " + sql);

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        return "Оновлено обьект з id = " + id;
    }

    public static String changeRoute(Connection connection, String route_id, String name, String length, String passenger_traffic, String id) throws SQLException {

        if (!id.matches("[+]?\\d+|") || !route_id.matches("[+]?\\d+|") || !length.matches("[+]?\\d+|") || !passenger_traffic.matches("[+]?\\d+|")) {
            return "Некоректний ввід даних!";
        }

        String sql = "UPDATE public.route SET";
        sql += " route_id = " + (route_id.length() > 0 ? route_id : "route_id");
        sql += ", name = " + (name.length() > 0 ? ("'" + name + "'") : "name");
        sql += " WHERE route_id = " + id;

        System.out.println("sql: " + sql);

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        return "Оновлено обьект з id = " + id;
    }

    public static String changeDriver(Connection connection, String driver_id, String bus_id, String full_name, String allowed_categories, String working_hours, String id) throws SQLException {

        if (!id.matches("\\d+|") || !driver_id.matches("\\d+|") || !bus_id.matches("\\d+|") || !working_hours.matches("\\d+|")) {
            return "Некоректний ввід даних!";
        }

        String sql = "UPDATE public.driver SET";
        sql += " driver_id = " + (driver_id.length() > 0 ? driver_id : "driver_id");
        sql += ", bus_id = " + (bus_id.length() > 0 ? bus_id : "bus_id");
        sql += ", full_name = " + (full_name.length() > 0 ? ("'" + full_name + "'") : "full_name");
        sql += ", allowed_categories = " + (allowed_categories.length() > 0 ? ("'" + allowed_categories + "'") : "allowed_categories");
        sql += ", working_hours = " + (working_hours.length() > 0 ? working_hours : "working_hours");
        sql += " WHERE driver_id = " + id;

        System.out.println("sql: " + sql);

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        return "Оновлено обьект з id = " + id;
    }


    public static String getInterface1(Connection connection, String capacity, String length) {

        if (!capacity.matches("\\d+") || !length.matches("\\d+")) {
            return "Некоректний ввід даних!";
        }

        String sql = "Select s.capacity, f.length from public.model s, public.route f, public.bus h where h.model_id = s.id and h.route_id = f.id and";
        sql += " s.capacity < (?)";
        sql += " and s.length < (?)";

        System.out.println("sql: " + sql);
        String resultStr = "Результат пошуку по заданим параметрам:\n";

        long m = System.currentTimeMillis();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, parseInt(capacity));
            statement.setInt(2, parseInt(length));

            try {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    resultStr += "-> Пасажиромісткість '" + resultSet.getInt(1) + ",";
                    resultStr += " Довжина " + resultSet.getInt(2);
                    resultStr += "\n";
                }
            } catch (Exception ex) {
                return ex.getMessage();
            }
        } catch (SQLException exception) {
            return exception.getMessage();
        }

        m = System.currentTimeMillis() - m;

        return (!resultStr.equals("Результат пошуку по заданим параметрам:\n") ? resultStr + "\nВитрачено " + m + " мілісекунд" : "Нічого не знайдено!");
    }

    public static String HASH(Connection connection) {
        String sql = "select count(*) from public.test_hash where id % 2 = 0";
        String result = sql + "\n";
        long m = System.currentTimeMillis();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result += "-> " + resultSet.getInt(1) + "\n";
                }
            } catch (Exception ex) {
                return ex.getMessage();
            }
        } catch (SQLException exception) {
            return exception.getMessage();
        }
        m = System.currentTimeMillis() - m;
        result += "Time: " + m + " ms.\n\n";

        sql = "select count(*) from public.test_hash where id % 2 = 0 or test_text like 'a%'";
        result += sql + "\n";
        m = System.currentTimeMillis();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result += "-> " + resultSet.getInt(1) + "\n";
                }
            } catch (Exception ex) {
                return ex.getMessage();
            }
        } catch (SQLException exception) {
            return exception.getMessage();
        }
        m = System.currentTimeMillis() - m;
        result += "Time: " + m + " ms.\n\n";

        sql = "select count(id), sum(id) from public.test_hash where test_text like '%x%' group by id % 4";
        result += sql + "\n";
        m = System.currentTimeMillis();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result += "[count = " + resultSet.getInt(1) +"; sum = " + resultSet.getLong(2) +"]\n";
                }
            } catch (Exception ex) {
                return ex.getMessage();
            }
        } catch (SQLException exception) {
            return exception.getMessage();
        }
        m = System.currentTimeMillis() - m;
        result += "Time: " + m + " ms.\n\n";

        return result;
    }

    public static String BRIN(Connection connection) {
        String sql = "select count(*) from public.test_brin where id % 2 = 0";
        String result = sql + "\n";
        long m = System.currentTimeMillis();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result += "-> " + resultSet.getInt(1) + "\n";
                }
            } catch (Exception ex) {
                return ex.getMessage();
            }
        } catch (SQLException exception) {
            return exception.getMessage();
        }
        m = System.currentTimeMillis() - m;
        result += "Time: " + m + " ms.\n\n";

        sql = "select count(*) from public.test_brin where id % 2 = 0 or test_text like 'a%'";
        result += sql + "\n";
        m = System.currentTimeMillis();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result += "-> " + resultSet.getInt(1) + "\n";
                }
            } catch (Exception ex) {
                return ex.getMessage();
            }
        } catch (SQLException exception) {
            return exception.getMessage();
        }
        m = System.currentTimeMillis() - m;
        result += "Time: " + m + " ms.\n\n";

        sql = "select count(id), sum(id) from public.test_brin where test_text like '%x%' group by id % 4";
        result += sql + "\n";
        m = System.currentTimeMillis();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result += "[count = " + resultSet.getInt(1) +"; sum = " + resultSet.getLong(2) +"]\n";
                }
            } catch (Exception ex) {
                return ex.getMessage();
            }
        } catch (SQLException exception) {
            return exception.getMessage();
        }
        m = System.currentTimeMillis() - m;
        result += "Time: " + m + " ms.\n\n";

        return result;
    }
}

