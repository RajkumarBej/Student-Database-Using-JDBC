import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("*****************Wellcome to student database*******************");
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("___________________________________________________________________________________________________________________");
            System.out.println("Choose from following option:\n1.INSERT TABLE\n2.READ VALUE\n3.UPDATE VALUE\n4.DELETE VALUE\n5.EXIT");
            int choice=sc.nextInt();
        
            if(choice<0 || choice>6)break;

            switch (choice) {
                case 1:
                    System.out.println("Enter student id,name,age & email:");
                    int id=sc.nextInt();
                    String name=sc.next();
                    int age=sc.nextInt();
                    String email=sc.next();

                    Student std=new Student(id, name, age, email);

                    StudentDao.createStudent(std);
                    break;
                case 2:
                    ArrayList<Student> sdata=StudentDao.readSudent();
                    for(Student student:sdata)
                    {
                        System.out.println("id= "+student.sid+"\tname= "+student.sname+"\tage= "+student.age+"\tEmail= "+student.email);
                    }
                    break;
                case 3:
                    System.out.println("Enter student id & name:");
                    int id1=sc.nextInt();
                    String name1=sc.next();

                    StudentDao.updateStudent(id1, name1);
                    break;
                case 4:
                    System.out.println("Enter student id:");
                    int id2=sc.nextInt();

                    StudentDao.deleteStudent(id2);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("invalid choice.....?");
                    break;
            }
        }
        sc.close();
    }
}
