package Control;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoiCSDL {

    public static Connection KetNoiCSDL(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=BooksSuppliers;username=sa;password=sa");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
