import java.util.Scanner;

public class MetricConverter {

    // Defining the correct conversion factors between different units.
    final private double kgToLb = 2.20462;
    final private double gToOz = 0.03527396;
    final private double kmToMile = 0.621371;
    final private double mmToIn = 0.0393701;

    public static void main(String[] args) {
        MetricConverter converter = new MetricConverter();
        converter.runConverter();
    }

    private void runConverter() {
        // Creating a Scanner object to read user input.
        Scanner input = new Scanner(System.in);

        // Declaring variables to store the input and output values.
        double inputValue;
        double outputValue;

        // Declaring a variable to store the user's choice of unit.
        int choice;

        // Welcome message.
        System.out.println("Welcome to the unit converter!");
        System.out.println("This program strictly either converts kilograms to pounds, grams to ounces, kilometers to miles, or milimeters to inches.");

        // While loop to continually accept user inputs.
        while (true) {
            // Prompt to the user to enter a value and a unit.
            System.out.print("Please enter a number and a unit (e.g., 50kg) or type 'exit' to quit:");
            String inputString = input.next();

            // Checking if the user wants to exit.
            if (inputString.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for the learning experience. Take care!");
                break;
            }

            // Extracting numeric value and unit.
            String numericPart = inputString.replaceAll("[^0-9.]", "");
            String unitPart = inputString.replaceAll("[0-9.]", "");

            try {
                inputValue = Double.parseDouble(numericPart);
            } catch (NumberFormatException e) {
                System.out.println("Ah ah ah, you didn't say the magic word(Jurassic Park Reference:) Anyway, please try again.");
                continue; // Continue to the next iteration of the loop.
            }

            // Displaying menu of options for the output unit.
            System.out.println("Enter the option number for the desired output unit:");
            System.out.println("1. Pounds");
            System.out.println("2. Ounces");
            System.out.println("3. Miles");
            System.out.println("4. Inches");
            System.out.println("5. Exit");

            // Reading the user's choice.
            choice = input.nextInt();

            // Switch statement to perform the conversion based on the user's choice.
            switch (choice) {
                case 1:
                    outputValue = inputValue * kgToLb;
                    System.out.println(inputValue + " " + unitPart + " is equal to " + outputValue + " lb.");
                    break;
                case 2:
                    outputValue = inputValue * gToOz;
                    System.out.println(inputValue + " " + unitPart + " is equal to " + outputValue + " oz.");
                    break;
                case 3:
                    outputValue = inputValue * kmToMile;
                    System.out.println(inputValue + " " + unitPart + " is equal to " + outputValue + " mi.");
                    break;
                case 4:
                    outputValue = inputValue * mmToIn;
                    System.out.println(inputValue + " " + unitPart + " is equal to " + outputValue + " in.");
                    break;
                case 5:
                    System.out.println("Thank you for the learning experience. Take care!");
                    return; // Terminate the program
                default:
                    System.out.println("Ah ah ah, you didn't say the magic word(Jurassic Park Quote:) Please try again.");
            }
        }

        // Closing the Scanner object.
        input.close();
    }
}
