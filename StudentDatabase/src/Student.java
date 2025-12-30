public class Student {
    int sid;
    String sname;
    int age;
    String email;

    Student(int sid,String sname,int age,String email){
        this.sid=sid;
        this.sname=sname;
        this.age=age;
        this.email=email;
    }

    public int getId(){return sid;}
    public String getName(){return sname;}
    public int getAge(){return age;}
    public String getEmail(){return email;}

}
