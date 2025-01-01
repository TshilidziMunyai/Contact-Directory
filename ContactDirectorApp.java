import java.sql.SQLException;
import java.util.Scanner;

public class ContactDirectorApp {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        ContactDAO contactDAO = new ContactDAO();

        while (true) {
            
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();


            switch(choice){

                case 1:

                    System.out.println("Enter name: ");
                    String name = scan.nextLine();
                    System.out.println("Enter Phone Number: ");
                    String phone = scan.nextLine();
                    System.out.println("Enter email: ");
                    String email = scan.nextLine();
                    contactDAO.addContact(name, phone, email);
                    break;
                
                case 2:

                    contactDAO.getAllContacts();
                    break;

                case 3:

                    System.out.println("Enter conatct ID to update: ");
                    int updateID =scan.nextInt();
                    System.out.println("Enter new phone number: ");
                    String newPhone = scan.nextLine();
                    contactDAO.UpdateContact(updateID, newPhone);
                    break;
                
                case 4:

                    System.out.println("Enter ID to delete: ");
                    String IdToDelete = scan.nextLine();
                    contactDAO.deleteContact(IdToDelete);
                    break;

                case 5:

                    System.out.println("GoodBye!");
                    scan.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice. Try Again!");
            }
        }
    }
    
}
