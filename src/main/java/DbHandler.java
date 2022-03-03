import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHandler {
    private static final String CON_STR = "jdbc:sqlite:C:/Users/mongr/Desktop/Work/Sportsoft/qr.db";

    // Используем шаблон одиночка, чтобы не плодить множество
    // экземпляров класса DbHandler
    private static DbHandler instance = null;

    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    // Объект, в котором будет храниться соединение с БД
    private Connection connection;

    private DbHandler() throws SQLException {
        // Регистрируем драйвер, с которым будем работать
        // в нашем случае Sqlite
        DriverManager.registerDriver(new JDBC());
        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(CON_STR);
    }

    public List<Photo> getAllBase64() {
        try (Statement statement = this.connection.createStatement()) {
            List<Photo> photos = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT PersonId, PhotoData FROM Photo");
            while (resultSet.next()) {
                Photo photo = new Photo(resultSet.getLong(1),resultSet.getString(2));
                photos.add(photo);
            }
            return photos;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Person> getAllPersons() {
        try (Statement statement = this.connection.createStatement()) {
            List<Person> persons = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT Id, FullName, Company, Position FROM Person");
            while (resultSet.next()) {
                Person person = new Person(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                persons.add(person);
            }
            return persons;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
