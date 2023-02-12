import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnesPepeleOracleDataBase {

    public static void main(String[] args) throws ClassNotFoundException {


        String url="jdbc:oracle:thin:@//localhost:1521/XE";
        String user="system";
        String password="oracle";


        try{
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Load success");
            Connection con= DriverManager.getConnection(url,user,password);
            System.out.println("Baglanti basarili"+con);
            Random rand = new Random();
            int numberOfEntries = 37589;
            long startTime = System.currentTimeMillis();

            for (int i = 0; i < numberOfEntries; i++) {
                    String query="insert into TABLE1(no) values ('"+rand.nextInt(1000)+"')";
                    Statement stmt=con.createStatement();
                    stmt.execute(query);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time to put " + numberOfEntries + " entries: " + (endTime - startTime) + "ms");
            List<String>data = new ArrayList<>();
            startTime = System.currentTimeMillis();
            Statement stmt=con.createStatement();
            String query="select * from TABLE1";
            int rowCount = 0;
            ResultSet rs = stmt.executeQuery(query);
            for (int i=0;i<numberOfEntries;i++) {
                rs.next();
                String columnValue = rs.getString("no");
                data.add(columnValue);
                rowCount++;
            }
            endTime = System.currentTimeMillis();
            System.out.println("Time to get " + rowCount + " entries: " + (endTime - startTime) + "ms");
        }catch (ClassNotFoundException e){
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
     }
        
}
}