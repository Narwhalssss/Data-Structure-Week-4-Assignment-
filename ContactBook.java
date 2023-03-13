import java.util.LinkedList;
import java.util.Scanner;

public class ContactBook {
    private static LinkedList<Contact> contacts = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("*****************************\n" +
                    "Contact Book\n" +
                    "(A)DD\n" +
                    "(D)ELITE CONTACT\n" +
                    "(S)ERCH CONTACT\n" +
                    "(E)MAIL SEARCH\n" +
                    "(P)RINT ALL\n" +
                    "(Q)UIT\n" +
                    "*****************************\n" +
                    "Enter your choice:");

            String choice = scanner.nextLine();

            switch (choice) {
                case "A","a":
                    addContact();
                    break;
                case "D","d":
                    deleteContact();
                    break;
                case "S","s":
                    searchContact();
                    break;
                case "E","e":
                    searchEmail();
                    break;
                case "P","p":
                    printContactList();
                    break;
                case "Q","q":
                    System.out.println("Exiting Contact Book...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
    }

    private static void addContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter contact name:");
        String name = scanner.nextLine();

        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter email address:");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    private static void deleteContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter contact name:");
        String name = scanner.nextLine();

        boolean contactDeleted = false;

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                contactDeleted = true;
                System.out.println("Contact deleted successfully!");
                break;
            }
        }

        if (!contactDeleted) {
            System.out.println("Contact not found!");
        }
    }

    private static void searchContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter contact name:");
        String name = scanner.nextLine();

        boolean contactFound = false;

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Name: " + contact.getName());
                System.out.println("Phone Number: " + contact.getPhoneNumber());
                System.out.println("Email: " + contact.getEmail());
                contactFound = true;
                break;
            }
        }

        if (!contactFound) {
            System.out.println("Contact not found!");
        }
    }

    private static void searchEmail() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter contact Email name:");
        String email = scanner.nextLine();

        boolean emailFound = false;

        for (Contact contact : contacts) {
            if (contact.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Name: " + contact.getName());
                System.out.println("Phone Number: " + contact.getPhoneNumber());
                System.out.println("Email: " + contact.getEmail());
                emailFound = true;
                break;
            }
        }

        if (!emailFound) {
            System.out.println("Contact not found!");
        }
    }

    private static void printContactList() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found!");
        } else {
            System.out.println("Contact List:");
            for (Contact contact : contacts) {
                System.out.println("Name: " + contact.getName());
                System.out.println("Phone Number: " + contact.getPhoneNumber());
                System.out.println("Email: " + contact.getEmail());
                System.out.println("--------------------");
            }
        }
    }

    private static class Contact {
        private String name;
        private String phoneNumber;
        private String email;

        public Contact(String name, String phoneNumber, String email) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getEmail() {
            return email;
        }
    }
}







