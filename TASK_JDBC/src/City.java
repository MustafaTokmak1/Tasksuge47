import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class City {
    String name;
    int population;
    String CountryCode;

    public City(String name, int population, String countryCode) {
        this.name = name;
        this.population = population;
        CountryCode = countryCode;
    }
    public static List fillListWithData() throws SQLException {
        List<City> cities = new ArrayList<>();
        City city = null;
        Statement stmt = null;
        ResultSet res = null;
        String sql = "SELECT * FROM city WHERE Population > 5000000;";
        Connection con = getConnection();
        stmt = con.createStatement();
        res = stmt.executeQuery(sql);
        while (res.next()) {
            String name = res.getString("Name");
            int population = res.getInt("Population");
            String contryCode = res.getString("CountryCode");
            city = new City(name, population, contryCode);
            cities.add(city);

        }
        return cities;
    }
    public static Connection getConnection() throws SQLException {
        String user = "root";
        String password = "julemanden";
        String url = "jdbc:mysql://localhost:3306/world3";

        Connection connection = null;
        connection = DriverManager.getConnection(url,user,password);
        try {
            connection = DriverManager.getConnection(url,user,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public String toString() {
        return "name ='" + name  +
                ", population =" + population +
                ", CountryCode ='" + CountryCode + "\n";
    }

}
