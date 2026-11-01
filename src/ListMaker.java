import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{
    public static void main(String[] args)
    {
        ArrayList<String> myList = new ArrayList<>();

        Scanner console = new Scanner(System.in);

        boolean done = false;
        String command = "";

        do
        {
            // Display the current list and menu
            printList(myList);
            displayMenu();

            // Get a valid menu command
            command = SafeInput.getRegExString(console,
                    "Enter your choice [A/D/I/P/Q]",
                    "[AaDdIiPpQq]");

            switch(command.toUpperCase())
            {
                case "A":
                    addItem(console, myList);
                    break;

                case "D":
                    deleteItem(console, myList);
                    break;

                case "I":
                    insertItem(console, myList);
                    break;

                case "P":
                    printList(myList);
                    break;

                case "Q":
                    done = quitProgram(console);
                    break;

                default:
                    System.out.println("Invalid command!");
                    break;
            }

        }while(!done);

        System.out.println("Goodbye!");

        console.close();
    }

    public static void displayMenu()
    {
        System.out.println();
        System.out.println("List Maker Menu");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
        System.out.println();
    }

    public static void printList(ArrayList<String> myList)
    {
        System.out.println();
        System.out.println("Current List");
        System.out.println("------------------------------");

        if(myList.size() == 0)
        {
            System.out.println("The list is empty.");
        }
        else
        {
            for(int x = 0; x < myList.size(); x++)
            {
                System.out.println((x + 1) + ". " + myList.get(x));
            }
        }

        System.out.println("------------------------------");
    }

    public static void addItem(Scanner console,
                               ArrayList<String> myList)
    {
        String item = "";

        item = SafeInput.getNonZeroLenString(console,
                "Enter the item to add");

        myList.add(item);

        System.out.println("Item added to the end of the list.");
    }

    public static void deleteItem(Scanner console,
                                  ArrayList<String> myList)
    {
        if(myList.size() == 0)
        {
            System.out.println("The list is empty. Nothing to delete.");
        }
        else
        {
            printList(myList);

            int itemNumber = SafeInput.getRangedInt(console,
                    "Enter the item number to delete",
                    1, myList.size());

            myList.remove(itemNumber - 1);

            System.out.println("Item deleted.");
        }
    }

    public static void insertItem(Scanner console,
                                  ArrayList<String> myList)
    {
        String item = "";
        int location = 0;

        item = SafeInput.getNonZeroLenString(console,
                "Enter the item to insert");

        location = SafeInput.getRangedInt(console,
                "Enter the location to insert the item",
                1, myList.size() + 1);

        myList.add(location - 1, item);

        System.out.println("Item inserted into the list.");
    }

    public static boolean quitProgram(Scanner console)
    {
        boolean sure = false;

        sure = SafeInput.getYNConfirm(console,
                "Are you sure you want to quit?");

        return sure;
    }
}
