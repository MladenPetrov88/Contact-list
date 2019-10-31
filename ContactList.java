import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        List<String> names = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            names.add(input[i]);
        }

        String command = scanner.nextLine();

        while (!command.contains("Print")) {
            String[] temp = command.split("\\s+");
            String firstCommand = temp[0];

            if (firstCommand.equals("Add")) {
                if (!names.contains(temp[1])) {
                    names.add(temp[1]);
                } else if (names.contains(temp[1])) {
                    if (Integer.parseInt(temp[2]) >= 0 && Integer.parseInt(temp[2]) < names.size()) {
                        names.add(Integer.parseInt(temp[2]), temp[1]);
                    }
                }
            }

            if (firstCommand.equals("Remove")) {
                if (Integer.parseInt(temp[1]) >= 0 && Integer.parseInt(temp[1]) < names.size()) {
                    names.remove(Integer.parseInt(temp[1]));
                }
            }

            if (firstCommand.equals("Export")) {
                if (Integer.parseInt(temp[1]) >= 0 && Integer.parseInt(temp[1]) < names.size()) {
                    if (Integer.parseInt(temp[2]) > names.size()) {
                        for (int i = Integer.parseInt(temp[1]); i < names.size() - 1; i++) {
                            System.out.print(names.get(i) + " ");
                        }
                        System.out.printf("%s%n",names.get(names.size() -1));
                    } else if (Integer.parseInt(temp[1]) + Integer.parseInt(temp[2]) < names.size()) {
                        for (int i = Integer.parseInt(temp[1]); i < (Integer.parseInt(temp[1]) + Integer.parseInt(temp[2])) - 1; i++) {
                            System.out.print(names.get(i) + " ");
                        }
                        System.out.printf("%s%n",names.get(Integer.parseInt(temp[1])+Integer.parseInt(temp[2])- 1));
                    }
                }
            }


            command = scanner.nextLine();
        }

        String[] a = command.split(" ");

        if (a[0].equals("Print")) {
            System.out.print("Contacts: ");
            if (a[1].equals("Normal")) {
                for (String name : names) {
                    System.out.print(name + " ");
                }
            } else if (a[1].equals("Reversed")) {
                for (int i = names.size() - 1; i >= 0; i--) {
                    System.out.print(names.get(i) + " ");
                }
            }
        }
    }
}