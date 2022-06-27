package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    public static boolean insertStudentToDB(Student student)
    {
        boolean f=false;
        try {
            // jdbc code
            Connection connection=ConnectionProvider.createConnection();
            String query="insert into students(sname,sphone,scity) values(?,?,?)"; // dynamic query or parametric query

            // PreparedStatement
            PreparedStatement pstmt=connection.prepareStatement(query);

            // set the values of parameter
            pstmt.setString(1,student.getStudentName());
            pstmt.setString(2,student.getStudentPhone());
            pstmt.setString(3,student.getStudentCity());

            //execute
            pstmt.executeUpdate();
            f=true;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return f;
    }

    public static boolean deleteStudent(int user_id) {
        boolean f=false;
        try {
            // jdbc code
            Connection connection=ConnectionProvider.createConnection();
            String query="delete from students sid=?"; // dynamic query or parametric query

            // PreparedStatement
            PreparedStatement pstmt=connection.prepareStatement(query);

            // set the values of parameter
            pstmt.setInt(1,user_id);

            //execute
            pstmt.executeUpdate();
            f=true;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return f;
    }

    public static void showAllStudent()
    {
        try {
            // jdbc code
            Connection connection=ConnectionProvider.createConnection();
            String query="delete * from students "; // dynamic query or parametric query

            // Statement
            Statement stmt=connection.createStatement();

            ResultSet set=stmt.executeQuery(query);

            while(set.next())
            {
                int id=set.getInt(1);
                String name=set.getString(2);
                String phone=set.getString(3);
                String city=set.getString(4);

                System.out.println("Student ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Phone: "+phone);
                System.out.println("City: "+city);
                System.out.println("-------------------------------------");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    public static boolean updateStudent(int id,String name, String phone, String city) {
        boolean f=false;
        try {
            // jdbc code
            Connection connection=ConnectionProvider.createConnection();
            String query="update students set sname=?,sphone=?,scity=? where sid=?"; // dynamic query or parametric query

            // PreparedStatement
            PreparedStatement pstmt=connection.prepareStatement(query);

            // set the values of parameter
            pstmt.setString(1,name);
            pstmt.setString(2,phone);
            pstmt.setString(3,city);
            pstmt.setInt(4,id);

            //execute
            pstmt.executeUpdate();
            f=true;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return f;
    }
}
