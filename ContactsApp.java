package contactdemo1;

import java.util.Scanner;
import java.util.ArrayList;

class Contact
{
    String name;
    String email;
    long phone;
    
    public Contact()
    {
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        email = input.nextLine();
        phone = input.nextLong();
    }
    
    public void Output()
    {
        System.out.println("enter name:" +name);
        System.out.println("enter email:" +email);
        System.out.println("enter phone :" +phone);
    }    
    
    public String getName()
    {
        return name;
    }
}
        
public class ContactDemo1 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Contact> contacts=new ArrayList<Contact>();
        
        
        while (true)
        {
            System.out.println("Add contact");
            System.out.println("Remove contact");
            System.out.println("Search contact");
            System.out.println("Display contact");
             
            int choice=input.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Add contact:");
                    Contact contact = new Contact();
                    contacts.add(contact);
                    break;
                case 2:
                    input.nextLine();
                    String name=input.nextLine();
                    boolean isfound=false;
                    for(int i=0;i<contacts.size();i++)
                    {                        
                        contact = contacts.get(i);
                        if(contact.getName().equals(name)){
                            contacts.remove(contact);
                            isfound=true;
                        }
                    }                    
                    if(isfound==false)
                    {
                        System.out.print("Contact Not Found");
                    }
                    break;                    
                case 3:
                    input.nextLine();
                    name=input.nextLine();
                    isfound=false;
                    for(int i=0;i<contacts.size();i++)
                    {                        
                        contact = contacts.get(i);
                        if(contact.getName().equals(name)){
                            contact.Output();
                            isfound=true;
                        }
                    }                    
                    if(isfound==false)
                    {
                        System.out.print("Contact Not Found");
                    }
                    break;
                case 4:
                    for(int i=0;i<contacts.size();i++)
                    {                        
                        contact = contacts.get(i);
                        contact.Output();
                    }                
            } 
        }
    }
}
    
    

