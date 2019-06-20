import java.util.ArrayList;
import java.util.Scanner;

class Program
{
	public static void main(String []args)
	{
		Scanner input = new Scanner(System.in);
		ArrayList<String> contacts = new ArrayList<String>();

		while(true)
		{
			System.out.println("1. Add Contact");
			System.out.println("2. Display Contacts");
			System.out.println("3. Delete Contact");
			System.out.println("4. Search Contact");
			System.out.println("5. Sort Contacts (A-Z)");
			System.out.println("6. Sort Contacts (Z-A)");
			System.out.println("7. Update Contact");

			int choice = input.nextInt();

			if(choice==1)
			{
				System.out.println("Enter Contact : ");
				String contact = input.nextLine();
				contacts.add(contact);
			}
			else if(choice==2)
			{
				System.out.println("Contacts List");
				for(int i=0;i<contacts.size();i++)
				{
					System.out.println(contacts.get(i));
				}
			}
			else
			{
				System.out.println("Enter Contact : ");
				String contact = input.nextLine();
				contacts.remove(contact);
			}



		}

	}
}