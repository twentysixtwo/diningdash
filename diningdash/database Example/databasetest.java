import java.sql.*;

public class databasetest {

    public static void main(String[] args)


        {


            try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            // set this to a MS Access DB you have on your machine
            String url = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};DBQ=C:\\Users\\admin\\Documents\\testDatabase1.mdb";
            // now we can get the connection from the DriverManager
            Connection con = DriverManager.getConnection( url ,"","");

            Statement s = con.createStatement();

            s.execute("select nametest from Table1"); // select the data from the table
           // s.execute("create table TEST ( column_name integer, column_string String )");
            s.execute("insert into TEST values(1,'hello')");

            s.execute("update TEST SET column_string='bye'");
            s.execute("select column_string from TEST");
            ResultSet rs = s.getResultSet(); // get any ResultSet that came from our query
            if (rs != null) // if rs == null, then there is no ResultSet to view
            while ( rs.next() ) // this will step through our data row-by-row


                {
                /* the next line will get the first column in our current row's ResultSet 
                as a String ( getString( columnNumber) ) and output it to the screen */ 
                System.out.println("Data from nametest: " + rs.getString(1) );
            }

        }

            catch (Exception e) {
            System.out.println("Error: " + e);
        }

            System.out.println("Hi");
    }
}
