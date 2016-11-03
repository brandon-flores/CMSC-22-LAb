package studentdb;

/**
 * Created by brandon on 11/3/2016.
 */
import java.io.*;
import java.util.*;

public class Enroll {
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;

    public int Register(List<Student> l){
        Student a = new Student();
        Course c = new Course();
        Scanner sc = new Scanner(System.in);
        System.out.println("STUDENT INFORMATION");
        System.out.println("Enter Student Number: ");
        a.setStudentNumber(sc.nextLine());
        if(search(a.getStudentNumber(),l) >= 0){
            System.out.println("Student already exists!");
            return 1;
        }
        System.out.println("Enter First Name: ");
        a.setFirstName(sc.nextLine());
        System.out.println("Enter Middle Initial: ");
        a.setMiddleInitial(sc.nextLine().charAt(0));
        System.out.println("Enter Last Name: ");
        a.setLastName(sc.nextLine());
        System.out.println("Enter Course: ");
        a.setCourse(sc.nextLine());
        System.out.println("Enter Crush Name: ");
        a.setCrushName(sc.nextLine());
        System.out.println("Enter Course Code: ");
        c.setCourseCode(sc.nextLine());
        System.out.println("Enter Course Description: ");
        c.setCourseDescription(sc.nextLine());
        a.setFaveSubject(c);
        System.out.println("Enter Year Level: ");
        a.setYearLevel(sc.nextInt());
        l.add(a);
        System.out.println("Student added!");
        return 0;
    }

    public void Retrieve(List<Student> l){
        Scanner sc = new Scanner(System.in);
        System.out.println("Search student: ");
        int i = search(sc.next(), l);
        if(i == -1) System.out.println("Student does not exist");
        else{
            System.out.println((Student)l.get(i));
        }
    }

    public void Delete(List<Student> l){
        Scanner sc = new Scanner(System.in);
        System.out.println("Remove student: ");
        int i = search(sc.next(), l);
        if(i == -1) System.out.println("Student does not exist");
        else{
            System.out.println("Search Student: " + l.get(i).getStudentNumber());
            l.remove(i);
        }
    }

    public void Edit(List<Student> l){
        Scanner sc = new Scanner(System.in);
        System.out.println("Edit student: ");
        int i = search(sc.nextLine(), l);
        if(i == -1) System.out.println("Student does not exist");
        else{
            System.out.println("Enter New First Name: ");
            l.get(i).setFirstName(sc.nextLine());
            System.out.println("Enter New Middle Initial: ");
            l.get(i).setMiddleInitial(sc.nextLine().charAt(0));
            System.out.println("Enter New Last Name: ");
            l.get(i).setLastName(sc.nextLine());
            System.out.println("Enter New Course: ");
            l.get(i).setCourse(sc.nextLine());
            System.out.println("Enter Crush Name: ");
            l.get(i).setCrushName(sc.nextLine());
            System.out.println("Enter Course Code: ");
            l.get(i).getFaveSubject().setCourseCode(sc.next());
            System.out.println("Enter Course Description: ");
            l.get(i).getFaveSubject().setCourseDescription(sc.next());
            System.out.println("Enter New Year Level: ");
            l.get(i).setYearLevel(sc.nextInt());
        }
    }

    public void Save(List<Student> l){
        try {
            fos = new FileOutputStream("D:\\School\\CMSC\\CMSC 22\\MP\\src\\studentdb\\save.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(l);
          oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int search(String s, List<Student> l){
        int ctr = 0;
        for (Student stud : l) {
            if(stud.getStudentNumber().equals(s)){
                return ctr;
            }
            ctr++;
        }
        return -1;
    }
}

