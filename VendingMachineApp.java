package vendingmachineapp;

import java.util.Scanner;


class CashRegister
{
    int cashOnHand;
    
    public CashRegister()
    {
        cashOnHand=500;
    }
    
    public CashRegister(int cash)
    {
        cashOnHand=cash;
    }
    
    public int getCurrentBalance()
    {
        return cashOnHand;
    }
    
    public void acceptAmount(int cost)
    {
        cashOnHand += cost;
    }
}


class DispenserType
{
    int noOfItems;
    int cost;
    
    public DispenserType()
    {
        noOfItems=50;
        cost=50;
    }
    
    public DispenserType(int nitems, int c)
    {
        noOfItems=nitems;
        cost=c;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public int getCost() {
        return cost;
    }

    public void makeSale()
    {
        noOfItems--;
    }
}

public class VendingMachineApp {
    public static void sellProduct(DispenserType item, CashRegister cr)
    {
        Scanner input = new Scanner(System.in);
        
        if(item.getNoOfItems()==0)
        {
            System.out.println("Out of Stock");
            return;
        }
        
        int cost = item.getCost();
        System.out.println("Cost : " + cost);
        
        int amount = input.nextInt();
        
        if(amount>=cost)
        {
            item.makeSale();
            cr.acceptAmount(cost);
            System.out.println("Thank You for Shopping With Us");
            System.out.println("Please collect your item and balance : " + (amount-cost));
        }
        else
        {
            System.out.print("Invalid Amount");
        }        
    }
    
    public static void showMenu()
    {
        Scanner input = new Scanner(System.in);
        
        DispenserType candy = new DispenserType(1000,10);
        DispenserType gums = new DispenserType(500,20);
        DispenserType cookies = new DispenserType(200,100);
        CashRegister cr = new CashRegister(2000);
        
        while(true)
        {
            System.out.println("1. Candy");
            System.out.println("2. Gums");
            System.out.println("3. Cookies");
            
            int choice = input.nextInt();
            
            switch(choice)
            {
                case 1:
                    sellProduct(candy,cr);
                    break;
                case 2:
                    sellProduct(gums,cr);
                    break;
                case 3:
                    sellProduct(cookies,cr);
                    break;
                case 98765:
                    System.out.println("Available Stock");
                    System.out.println("Candy : " + candy.getNoOfItems());
                    System.out.println("Gums : " + gums.getNoOfItems());
                    System.out.println("Cookies : " + cookies.getNoOfItems());
                    System.out.println("Available Cash : " + cr.getCurrentBalance());
                    
            }
        }
    }
    
    public static void main(String[] args) {
        showMenu();
    }    
}
