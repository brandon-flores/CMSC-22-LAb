import java.io.*;
import java.util.*;

public class Enroll {
  public static int Register(List<Student> l){
    Student a = new Student();
    Scanner sc = new Scanner(System.in);
    String ans;
    System.out.println("STUDENT INFORMATION");
    System.out.println("Enter Student Number: ");
    a.setStudentNum(sc.nextLine());
    if(search(a.getStudentNum(),l) >= 0){
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
    System.out.println("Enter Year Level: ");
    a.setYearLevel(sc.nextInt());
    l.add(a);
    System.out.println("Student added!");
    return 0;
  }
  
  public static void Retrieve(List<Student> l){
    Scanner sc = new Scanner(System.in);
    System.out.println("Search student: ");
    int i = search(sc.next(), l);
    if(i == -1) System.out.println("Student does not exist");
    else{
      System.out.println((Student)l.get(i));
    }
  }
  
  public static void Delete(List<Student> l){
    Scanner sc = new Scanner(System.in);
    System.out.println("Remove student: ");
    int i = search(sc.next(), l);
    if(i == -1) System.out.println("Student does not exist");
    else{
      System.out.println("Search Student: " + l.get(i).getStudentNum());
      l.remove(i);
    }
  }
  
   public static void Edit(List<Student> l){
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
      System.out.println("Enter New Year Level: ");
      l.get(i).setYearLevel(sc.nextInt());
    }
  }
  
  public static void Save(List<Student> l){
    try {

            File file = new File("save.out");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Student stud : l) {
              bw.write(stud.getStudentNum());
              bw.newLine();
              bw.write(stud.getFirstName());
              bw.newLine();
              bw.write(stud.getMiddleInitial());
              bw.newLine();
              bw.write(stud.getLastName());
              bw.newLine();
              bw.write(stud.getCourse());
              bw.newLine();
              bw.write(stud.getYearLevel() + "\n");
            }
            
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
  }
  
  public static int search(String s, List<Student> l){
    int ctr = 0;
    for (Student stud : l) {
      if(stud.getStudentNum().equals(s)){
        return ctr;
      }
      ctr++;
    }
    return -1;
  }
  
  public static void main(String[] args) {
        BufferedReader br = null;
        int ctr = 1;
        List<Student> myList = new ArrayList<Student>();
        Student a = new Student();
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("C:\\Users\\brand\\Desktop\\Lab 10\\save.out"));
            while ((sCurrentLine = br.readLine()) != null) {
              
              if(ctr%6 == 1) a.setStudentNum(sCurrentLine);  
              if(ctr%6 == 2) a.setFirstName(sCurrentLine);
              if(ctr%6 == 3) a.setMiddleInitial(sCurrentLine.charAt(0));
              if(ctr%6 == 4) a.setLastName(sCurrentLine);
              if(ctr%6 == 5) a.setCourse(sCurrentLine);
              if(ctr%6 == 0) a.setYearLevel(Integer.parseInt(sCurrentLine));
              ctr++;
              if(ctr > 1 && ctr % 6 == 1){
                myList.add(a);
                a = new Student();
              }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        Scanner sc = new Scanner(System.in);
        boolean status = true;
        int choice = 0;
        do{
          do{
            System.out.println("==MENU==");
            System.out.println("1. Register Student");
            System.out.println("2. Retrieve Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Save Information");
            System.out.println("5. Edit Student");
            System.out.println("6. Exit");
            System.out.println("Enter number of choice: ");
            choice = sc.nextInt();
            if(choice >= 1 && choice <= 6) break;
          }while(true);
          switch (choice){
          case 1:
            Register(myList);
            break;
          case 2:
            Retrieve(myList);
            break;
          case 3:
            Delete(myList);
            break;
          case 4:
            Save(myList);
            break;
          case 5:
            Edit(myList);
            break;
          case 6:
            status = false;
            break;
          default: 
            System.out.println("Unrecognized input");
            break;
        }
        }while(status);
        
    }
  
}
