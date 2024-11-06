import java.util.Scanner;
import java.util.ArrayList;
public class Main
{
    public static void main(String[] args)

    {

        Scanner in = new Scanner(System.in);
        ArrayList<String> myArrList = new ArrayList<>();
        boolean done = false;

        do
        {

            printListWithNumbers(myArrList);
            String input = SafeInput.getRegExString(in, "\nA – Add an item to the list \nD – Delete an item from the list \nI – Insert an item into the list \nP – Print the list \nQ – Quit the program\n", "^[AaDdIiPpQq$]", "AaDdIiPpQq");

            switch (input.toUpperCase())
            {
                case "A":
                    add(in, myArrList);
                    break;

                case "D":
                    delete(in, myArrList);
                    break;

                case "I":
                    insert(in, myArrList);
                    break;

                case "P":
                    printListWithNumbers(myArrList);
                    break;

                case "Q":
                    done = quit(in);
                    break;
                default:
                    System.out.println("Invalid option, please choose again.");
                    break;
            }
        }
        while(!done);


    }

    public static void printListWithNumbers(ArrayList<String> list)
    {

            System.out.println("Current list:");
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println((i + 1) + ". " + list.get(i));
            }
    }


    public static void add(Scanner pipe, ArrayList<String> list)
    {
        String item = SafeInput.getNonZeroLenString(pipe, "Enter item to add");

        list.add(item);

        System.out.println("Item added.\n");
    }

    public static void delete(Scanner pipe, ArrayList<String> list)
    {
        if (list.isEmpty()) {
            System.out.println("The list is empty, there is nothing to delete.");
            return;
        }

        printListWithNumbers(list);
        int itemNumber = SafeInput.getRangedInt(pipe, "Enter the number of the item to delete", 1, list.size());


        list.remove(itemNumber - 1);

        System.out.println("Item deleted.\n");
    }

    public static void insert(Scanner pipe, ArrayList<String> list)
    {
        printListWithNumbers(list);

        int position = SafeInput.getRangedInt(pipe, "Enter the position where you want to insert the item", 1, list.size() + 1);

        String item = SafeInput.getNonZeroLenString(pipe, "Enter the item to insert");

        list.add(position - 1, item);

        System.out.println("Item inserted!\n");

    }

    public static boolean quit(Scanner pipe)
    {
        boolean confirmQuit = SafeInput.getYNConfirm(pipe, "Are you sure you would like to quit? ");


        return confirmQuit;

    }

}