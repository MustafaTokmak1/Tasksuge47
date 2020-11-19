import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String username = "root";
        String password = "julemanden";
        String url = "jdbc:mysql://localhost:3306/world3";
        Connection cn = null;

        cn = DriverManager.getConnection(url, username, password);


        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT COUNT(ID) FROM city");

        ResultSetMetaData rsmd = rs.getMetaData();
        //System.out.println("querying SELECT * FROM city");
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }

        //Statement st1 = cn.createStatement();
        ResultSet rs1 = st.executeQuery("SELECT * FROM city WHERE Population > 5000000;");
        while(rs1.next()){
            System.out.println(rs1.getString("Name"));
        }
        System.out.println(City.fillListWithData());
        cn.close();

        }

    }

