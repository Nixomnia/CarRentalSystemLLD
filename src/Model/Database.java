package src.Model;
import java.sql.*;
import java.sql.SQLException;

public class Database {
    private String user = "root";
    private String  password = "Aryia@2022";
    private String url = "jdbc:mysql://localhost:3306/carrental";
    private Statement  statement;
    public Database(){
        try{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Connection connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        }
        catch(SQLException e){
        e.printStackTrace();
    }
}

    public Statement getStatement(){
    return statement ;
}

}
