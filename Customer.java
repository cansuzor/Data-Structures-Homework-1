package homework1;
//import java.util.Scanner;
//import java.util.Arrays;

public class Customer {
    //instance variables
   private int customerNumber;
   private String customerName;
   private int balance;
    
    //Constructor
     public Customer (int customerNumber, String customerName,int balance) {
		this.customerNumber=customerNumber;
        this.customerName=customerName;
		this.balance=balance;
	}

    public void setBalance (int balance) {
            this.balance = balance;
    }
    public int getBalance () {
            return balance;    
    }
    public void setCustomerName (String customerName) {
            this.customerName= customerName;
    }
    public String getCustomerName () {
            return customerName;
    }
    public void setCustomerNumber (int customerNumber) {
            this.customerNumber= customerNumber;
    }
    public int getCustomerNumber () {
            return customerNumber;
    }
    
    public String toString() {
        String s = "";
        //NOw, we build s
        s += "" + customerNumber + " " + customerName + " " + balance + "\n";
        return s;
        
    }
} 
        