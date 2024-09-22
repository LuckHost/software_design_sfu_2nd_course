import java.util.ArrayList;
import java.util.Scanner;

public class ToyCollectionApp {
    private ArrayList<Toy> toyCollection = new ArrayList<>();


    public void start() {
        int choice;
        do {
            System.out.println("\n1. Add a new toy");
            System.out.println("2. Delete the toy by index");
            System.out.println("3. Bring out all the toys");
            System.out.println("4. Compare two toys");
            System.out.println("5. Finish the job");
            choice = getCorrectInput(null);

            switch (choice) {
                case 1:
                    addNewToy();
                    break;
                case 2:
                    removeToy();
                    break;
                case 3:
                    printAllToys();
                    break;
                case 4:
                    compareToys();
                    break;
                case 5:
                    System.out.println("Shutdown.");
                    break;
                default:
                    System.out.println("Wrong choice. Try again.");
            }
        } while (choice != 5);
    }

    private void addNewToy() {
        System.out.println("Select the type of toy:");
        System.out.println("1. A soft toy");
        System.out.println("2. The constructor");
        System.out.println("3. Radio-controlled toy");
        int type = getCorrectInput(null);

        switch (type) {
            case 1:
                addSoftToy();
                break;
            case 2:
                addConstructorToy();
                break;
            case 3:
                addRemoteControlToy();
                break;
            default:
                System.out.println("Wrong choice.");
        }
    }

    // Методы для добавления разных типов игрушек
    private void addSoftToy() {
        String name = getCorrectStrInput("Enter the name of the toy: ");
        double price = getCorrectDoubleInput(
            "Enter the price of the toy: ");
        String material = getCorrectStrInput("Enter the material: ");
        double softnessLevel = getCorrectDoubleInput(
            "Enter the softness level (1-10): ");

        toyCollection.add(new SoftToy(name, price, material, softnessLevel));
    }

    private void addConstructorToy() {
        String name = getCorrectStrInput(
            "Enter the name of the constructor: ");
        double price = getCorrectDoubleInput(
            "Enter the price of the constructor: ");
        int pieces = getCorrectInput(
            "Enter the number of parts: ");

        String theme = getCorrectStrInput(
            "Enter the subject of the constructor: ");

        toyCollection.add(new ConstructorToy(name, price, pieces, theme));
    }

    private void addRemoteControlToy() {
        String name = getCorrectStrInput("Enter the name of the toy: ");
        double price = getCorrectDoubleInput(
            "Enter the price of the toy: ");
        double range = getCorrectDoubleInput(
            "Enter the control range: ");
        String controlType = getCorrectStrInput(
            "Enter the control type: ");

        toyCollection.add(
          new RemoteControlToy(name, price, range, controlType)
          );
    }

    private void removeToy() {

        int index = getCorrectInput(
            "Enter the index to delete: ");
        if (index >= 0 && index < toyCollection.size()) {
            toyCollection.remove(index);
            System.out.println("Toy deleted.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private void printAllToys() {
        if (toyCollection.isEmpty()) {
            System.out.println("Collection is empty.");
        } else {
            for (int i = 0; i < toyCollection.size(); i++) {
                System.out.println(i + ". " + toyCollection.get(i));
            }
        }
    }

    private void compareToys() {
        int index1 = getCorrectInput("Enter the index of the first toy: ");
        int index2 = getCorrectInput("Enter the index of the second toy: ");

        if (index1 >= 0 && index1 < toyCollection.size() && 
        index2 >= 0 && index2 < toyCollection.size()) {
            boolean areEqual = toyCollection
              .get(index1)
              .equals(toyCollection.get(index2));
            System.out.println("Toys " + 
              (areEqual ? "the same." : "different."));
        } else {
            System.out.println("Invalid indexes.");
        }
    }

    /*
    * Функция импорта корректного значения типа Double
    * 
    * Принимает сообщение, которое надо выдать пользователю
    * 
    * Возвращает значение Double 
    */
    public static Double getCorrectDoubleInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        while (true) {
        if(scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            scanner = new Scanner(System.in);
            System.out.println("Try again. Example input: \"4,3\"");
        }
        }
    }

     /*
    * Функция импорта корректного строкового значения
    * 
    * Принимает сообщение, которое надо выдать пользователю
    * 
    * Возвращает строку без спец. символов 
    */
    public static String getCorrectStrInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String output = null;
        String[] wrongValues = new String[]{"@", "#", "$", "%", "^", "&", "*", "+", "="};
        Boolean cntnue = true;
        while (cntnue) {
        if (scanner.hasNextLine()) output = scanner.nextLine();
        else continue;
        
        for (String wrongValue : wrongValues) {
            if(output.indexOf(wrongValue) != -1){
            System.out.println("The input has forbidden characters. Please try again");
            continue;
            } else {
            cntnue = false;
            break;
            }
        }
        }
        return output;
    }

    /*
    * Функция перегрузки для функции ввода переменных
    */
    public static int getCorrectInput(String message) {
        return getCorrectInput(0, 0, message);
    }

    /*
    * Функция корректного ввода
    * Просит пользователя ввести значение
    * до тех пор, пока оно не будет корректным 
    * 
    * Получет на вход область допустимых
    * значений в виде начала и конца массива 
    * и строку сообщения
    * для пользователя
    * 
    * Возвращает число, введенное пользователем
    */
    public static int getCorrectInput(int crctVlsStart, int crctVlsEnd, String message) {
        if (message != null) {
            System.out.println(message);
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
          scanner = new Scanner(System.in);
          if(scanner.hasNextInt()) {
            int result = Integer.parseInt(scanner.nextLine());
            if((result >= crctVlsStart && result <= crctVlsEnd) || crctVlsStart == crctVlsEnd) {
              return result;
            }
            System.out.println("The input is incorrect. Please try again");
            
          } else {
            System.out.println("Try again");
          }
        }
      }

    public static void main(String[] args) {
        new ToyCollectionApp().start();
    }
}
