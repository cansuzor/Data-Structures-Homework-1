package homework1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Runner {
    
    static ArrayList<Customer> custList;

public static void main (String [] args) throws Exception {
    
    //Scanner to read in the master.txt
    Scanner MF= new Scanner (new File ("master.txt")); 
    //Scanner to read in the trans.txt
    Scanner TF= new Scanner (new File ("trans.txt"));
    
    //Make new Customer Array List
    custList = new ArrayList<Customer>();
    
    //Fill the custList
    while(MF.hasNext()) {
        int number = MF.nextInt();
        String name = MF.next();
        int balance = MF.nextInt();
        
        custList.add(new Customer(number, name, balance));
    }
    
    //Now, we have a full custList, and ready to be editted!
    
    //Let's go through the transaction list
    while(TF.hasNext()) {
        //Example
        //O 1001 1 ABC 1 5
        //If O, then order
        if(TF.next().equals("O")) {
            //Order
            int custNum = TF.nextInt();
            TF.next(); //ignore
            TF.next();
            int whatWasOrdered = TF.nextInt();
            int howMany = TF.nextInt();
            updateCustomer(custNum, (whatWasOrdered*howMany));
            
            
        } else {
            //Payment
            int custNum = TF.nextInt();
            TF.next(); //ignore
            int substract = TF.nextInt();
            updateCustomer(custNum, (-1*substract));
        }
        
    }
    
    //Write to a file
    BufferedWriter br = new BufferedWriter(new FileWriter("master2.txt"));
    
    for(Customer c : custList) {
        br.write(c.toString());
        br.flush();
    }
    
    
           
    }
    
    public static void updateCustomer(int cust, int change) {
        //Find right customer
        int custIndex = -1;
        for(int i = 0; i < custList.size(); i++) {
            if(custList.get(i).getCustomerNumber() == cust) {
                custIndex = i;
            }
        }
        
        //Now, update that customer
        int currBalance = custList.get(custIndex).getBalance();
        custList.get(custIndex).setBalance(currBalance + change);
    }
}

