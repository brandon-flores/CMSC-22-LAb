import java.util.*;

public class TestAccount {
   public static void main(String[] args) {
      // Test constructor and toString()
      Account d1 = new Account(201504, 1000.0);
      System.out.println(d1);  // toString()
 
      // Test Setters and Getters
      d1.setBalance(2000.0);

      System.out.println(d1);  // run toString() to inspect the modified instance
      d1.credit(1000.0);
      System.out.println(d1);
      d1.debit(1500.0);
      System.out.println(d1);
      d1.debit(3000.0);
 
   }
}
