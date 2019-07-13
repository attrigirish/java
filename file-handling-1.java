package bytestreamdemo;

import java.io.*;
import java.util.Scanner;

public class ByteStreamDemo {
    
    public static void Save()
    {
        try
        {
            Scanner input = new Scanner(System.in);
            FileWriter writer = new FileWriter("d:\\file.txt",true);    //Append Mode
            
            System.out.print("ID : ");
            String id=input.nextLine();
            System.out.print("Name : ");
            String name=input.nextLine();
            System.out.print("Fees : ");
            String fees=input.nextLine();
            System.out.print("Course : ");
            String course=input.nextLine();
            
            writer.write(id+","+name+","+course+","+fees+"\n");
            
            writer.close();
        }
        catch(Exception e)
        {
            System.out.print("Error Occured : " + e.getMessage());
        }
    }
    
    public static void Display()
    {
        try
        {
            FileReader reader = new FileReader("d:\\file.txt");
            BufferedReader buffer = new BufferedReader(reader);
            
            String line=buffer.readLine();
            while(line!=null)
            {
                String[] values=line.split(",");
                System.out.println("ID : " + values[0]);
                System.out.println("Name : " + values[1]);
                System.out.println("Course : " + values[2]);
                System.out.println("Fees : " + values[3]);
                
                line=buffer.readLine();
            }
            
            reader.close();
        }
        catch(Exception e)
        {
            
        }
    }
    
    public static void Search()
    {
        
        Scanner input=new Scanner(System.in);
        
        System.out.println("Enter Id to Search Record : ");
        String id=input.nextLine();
        try
        {
            FileReader reader = new FileReader("d:\\file.txt");
            BufferedReader buffer = new BufferedReader(reader);
            
            String line=buffer.readLine();
            boolean isfound=false;
            while(line!=null)
            {
                String[] values=line.split(",");
                if(values[0].equals(id))
                {
                    isfound=true;
                    System.out.println("ID : " + values[0]);
                    System.out.println("Name : " + values[1]);
                    System.out.println("Course : " + values[2]);
                    System.out.println("Fees : " + values[3]);
                }
                
                line=buffer.readLine();
            }
            
            reader.close();
            
            if(isfound==false)
            {
                System.out.println("Not Found");
            }
        }
        catch(Exception e)
        {
            
        }
    }
    
   public static void Delete()
    {        
        Scanner input=new Scanner(System.in);
        
        System.out.println("Enter Id to Delete Record : ");
        String id=input.nextLine();
        try
        {
            FileReader reader = new FileReader("d:\\file.txt");
            FileWriter writer = new FileWriter("d:\\temp.txt");
            BufferedReader buffer = new BufferedReader(reader);
            
            String line=buffer.readLine();
            boolean isfound=false;
            while(line!=null)
            {
                String[] values=line.split(",");
                if(!values[0].equals(id))
                {
                    isfound=true;
                    writer.write(values[0]+","+values[1]+","+values[2]+","+values[3]+"\n");
                }
                
                line=buffer.readLine();
            }
            
            reader.close();
            writer.close();
            
            //Remove and Rename
            File oldfile = new File("d:\\file.txt");
            File newfile = new File("d:\\temp.txt");
            oldfile.delete();
            newfile.renameTo(oldfile);
            
            if(isfound==false)
            {
                System.out.println("Not Found");
            }
        }
        catch(Exception e)
        {
            
        }
    }
    
    public static void Update()
    {        
        Scanner input=new Scanner(System.in);
        
        System.out.println("Enter Id to Delete Record : ");
        String id=input.nextLine();
        try
        {
            FileReader reader = new FileReader("d:\\file.txt");
            FileWriter writer = new FileWriter("d:\\temp.txt");
            BufferedReader buffer = new BufferedReader(reader);
            
            String line=buffer.readLine();
            boolean isfound=false;
            while(line!=null)
            {
                String[] values=line.split(",");
                if(values[0].equals(id))
                {
                    isfound=true;
                    System.out.print("Enter Updated Name : ");
                    values[1]=input.nextLine();
                    System.out.println("Enter Updated Course : ");
                    values[2]=input.nextLine();
                    System.out.println("Enter Update Fees : ");
                    values[3]=input.nextLine();
                }
                writer.write(values[0]+","+values[1]+","+values[2]+","+values[3]+"\n");
                
                line=buffer.readLine();
            }
            
            reader.close();
            writer.close();
            
            //Remove and Rename
            File oldfile = new File("d:\\file.txt");
            File newfile = new File("d:\\temp.txt");
            oldfile.delete();
            newfile.renameTo(oldfile);
            
            if(isfound==false)
            {
                System.out.println("Not Found");
            }
        }
        catch(Exception e)
        {
            
        }
    }
    
    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        while(true)
        {
            System.out.println("1. Add Record");
            System.out.println("2. Display Record");
            System.out.println("3. Search");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            
            System.out.println("Enter Choice : ");
            int choice=input.nextInt();
            
            switch(choice)
            {
                case 1: Save(); break;
                case 2: Display(); break;
                case 3: Search(); break;
                case 4: Update(); break;
                case 5: Delete(); break;
                default: System.out.println("Invalid Input");
            }
        }
    }    
}





