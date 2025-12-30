import java.sql.*;
import java.util.ArrayList;

public class StudentDao {
    public static void createStudent(Student student) throws SQLException{
        Connection con=DB.connect();

        String query=Query.insert;

        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1, student.getId());
        pst.setString(2, student.getName());
        pst.setInt(3, student.getAge());
        pst.setString(4, student.getEmail());

        System.out.println(pst+"\nTable created successfully...!");
        pst.executeUpdate();
        pst.close();
    }

    public static void updateStudent(int id,String name) throws SQLException{
        Connection con=DB.connect();

        String query=Query.update;

        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(2, id);
        pst.setString(1, name);

        System.out.println(pst+"\ntable updated...!");
        pst.executeUpdate();
        pst.close();
    }

    public static ArrayList<Student> readSudent()throws SQLException{
        ArrayList<Student> sdata=new ArrayList<Student>();
        Connection con=DB.connect();

        String query=Query.select;

        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);

        System.out.println(rs+"\nStudent data selected...!");

        while (rs.next()) {
            int id=rs.getInt(1);
            String name=rs.getString(2);
            int age=rs.getInt(3);
            String email=rs.getString(4);

            Student student=new Student(id, name, age, email);
            sdata.add(student);
        }

        return sdata;
    }

    public static void deleteStudent(int id)throws SQLException{
        Connection con=DB.connect();

        String query=Query.delete;

        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1, id);
        pst.executeUpdate();
        System.out.println(pst+"\nOne raw effected...!");

        pst.close();
    }

}
