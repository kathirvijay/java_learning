import java.sql.*;

public class demo {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/demo",
                    "postgres",
                    "K@thir17"
            );

            System.out.println("Connected successfully!");

//            String sql = "Select name From student where id = 1";
            String sql = "Select * From student";
//            String sql = "Insert into student (id, name, marks) values (5, 'soundar', 22)";
            Statement st = con.createStatement();
//            boolean ins= st.execute(sql);
//            System.out.println("Inserted "+ ins);
            ResultSet res = st.executeQuery(sql);

            if (res.next()) {
                while (res.next()){
                    System.out.println("out : " + res.getString(3));
                }
//                System.out.println("out : " + res.getString("name"));
            } else {
                System.out.println("Not found");
            }

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}