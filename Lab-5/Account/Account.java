public class Account{
      private int accountNumber;
      private double balance;

      public Account(){
            this.balance = 0.0;
      }

      public Account(int acc, double bal){
         this.accountNumber = acc;
         this.balance = bal;
      }

      public Account(int acc){
         this(acc, 0.0);
      }

      public int getAccountNumber(){
         return accountNumber;
      }

      public double getBalance(){
         return balance;
      }

      public void setBalance(double bal){
         this.balance = bal;
      }

      public void credit(double add){
         if(add < 0){
            throw new IllegalArgumentException("Negative money!!");
         }
         this.balance += add;
      }

      public void debit(double amount){
         if(balance >= amount){
            balance -= amount;
         }
         else
            throw new IllegalArgumentException("Amount withdrawn exceeds the current balance!!");
      }

      public String toString(){
         return String.format("A/C no:%d, Balance=$%.2f",this.accountNumber, this.balance);
      }

   }
