import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        System.out.println("Welcome to Student Management App");
        Scanner scanner=new Scanner(System.in);

        while(true)
        {
            System.out.println("Press 1 to ADD Student");
            System.out.println("Press 2 to DELETE Student");
            System.out.println("Press 3 to DISPLAY Student");
            System.out.println("Press any key to exit app");

            int input=Integer.parseInt(scanner.nextLine());

            if(input==1)
            {
                System.out.println("Enter user name : ");
                String name=scanner.nextLine();

                System.out.println("Enter user phone : ");
                String phone=scanner.nextLine();

                System.out.println("Enter user city : ");
                String city=scanner.nextLine();

                Student st=new Student(name,phone,city);

                System.out.println(st);

                boolean ans=StudentDao.insertStudentToDB(st);
                if(ans)
                {
                    System.out.println("Student is added successfully!!");
                }
                else {
                    System.out.println("Something went wrong!!");
                }
            }
            else if(input==2)
            {
                // delete user
                System.out.println("Enter student id to delete: ");
                int user_id=Integer.parseInt(scanner.nextLine());
                boolean ans=StudentDao.deleteStudent(user_id);
                if(ans)
                {
                    System.out.println("Deleted Successfully");
                }
                else
                {
                    System.out.println("Something, went wrong. Try again !!! ");
                }
            }
            else if(input==3)
            {
                StudentDao.showAllStudent();
            }
            else if(input==4)
            {
                // update student

                System.out.println("Enter Student id to update: ");
                int id=Integer.parseInt(scanner.nextLine());

                System.out.println("Enter Student Name to update: ");
                String name=scanner.nextLine();

                System.out.println("Enter Student Phone to update: ");
                String phone=scanner.nextLine();

                System.out.println("Enter Student city to update: ");
                String city=scanner.nextLine();

                boolean ans=StudentDao.updateStudent(id,name,phone,city);

                if(ans)
                {
                    System.out.println("Updated Successfully");
                }
                else
                {
                    System.out.println("Something, went wrong. Try again !!!");
                }
            }
            else
            {
                break;
            }
        }
        System.out.println("Bye!!");
    }
}
