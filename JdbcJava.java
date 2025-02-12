import java.sql.*;


public class JdbcJava {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgmt1","root", "Sateez@242075");
            /*****SELECT Query*****/
//            String sql = "SELECT * from EmplyDetails";
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()){
//                System.out.println(rs.getInt("empno") + " - " + rs.getString("ename"));
//            }

            /*****Create Query*****/

//            String createTableSQL = "CREATE TABLE employees ("
//                    + "empid INT, "
//                    + "empname VARCHAR(100), "
//                    + "empage INT, "
//                    + "salary DECIMAL(10, 2)"
//                    + ");";
//
//            Statement statement = con.createStatement();
//
//            statement.executeUpdate(createTableSQL);
//            System.out.println("Table 'employees' created successfully!");

            /*****Insert Query*****/
            String insertSQL = "INSERT INTO employees (empid, empname, empage, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement psmpt = con.prepareStatement(insertSQL);
            psmpt.setInt(1, 105);
            psmpt.setString(2, "Shameer");
            psmpt.setInt(3, 25);
            psmpt.setInt(4, 90000);

            int status = psmpt.executeUpdate();

            System.out.println("Status =" +status);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            con.close();
        }
    }
}
