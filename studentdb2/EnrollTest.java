package studentdb;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by brandon on 11/3/2016.
 */
public class EnrollTest {
    public static void main(String[] args) {
        Enroll en = new Enroll();
        List<Student> myList = new ArrayList<Student>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("D:\\School\\CMSC\\CMSC 22\\MP\\src\\studentdb\\save.txt");
            ois = new ObjectInputStream(fis);

            myList = (List) ois.readObject();

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }  catch (ClassNotFoundException ce) {
            // this might be thrown by ois.readObject()
            ce.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
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
                    en.Register(myList);
                    break;
                case 2:
                    en.Retrieve(myList);
                    break;
                case 3:
                    en.Delete(myList);
                    break;
                case 4:
                    en.Save(myList);
                    break;
                case 5:
                    en.Edit(myList);
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
