import java.util.Scanner;

public class OnlineExamSystem {
    private String username;
    private String password;
    private boolean loggedIn = false;

    public static void main(String[] args) {
        OnlineExamSystem examSystem = new OnlineExamSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Update Profile and Password");
            System.out.println("3. Take Exam");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    examSystem.login(scanner);
                    break;
                case 2:
                    examSystem.updateProfileAndPassword(scanner);
                    break;
                case 3:
                    if (examSystem.loggedIn) {
                        examSystem.takeExam();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 4:
                    examSystem.logout();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    public void login(Scanner scanner) {
        System.out.print("Enter your username: ");
        username = scanner.next();
        System.out.print("Enter your password: ");
        password = scanner.next();
        loggedIn = true;
        System.out.println("Logged in successfully as " + username);
    }

    public void updateProfileAndPassword(Scanner scanner) {
        if (loggedIn) {
            System.out.print("Enter your new username: ");
            username = scanner.next();
            System.out.print("Enter your new password: ");
            password = scanner.next();
            System.out.println("Profile and password updated successfully.");
        } else {
            System.out.println("Please login first.");
        }
    }

    public void takeExam() {
        // Implement exam functionality, including MCQs, timer, and auto-submit.
        System.out.println("Taking the exam...");
        Scanner scanner=new Scanner(System.in);
        int score = 0;

        String[] questions = {
                "1. What is the most common way to declare a constant in Java?",
                "2. Which keyword is used to define a class in Java?",
                "3. What is the primary purpose of the 'public' access modifier?",
                "4. What is a class constructor in Java?",
                "5. In Java, which type of variable is used to store text?",
                "6. How do you create a new instance (object) of a class in Java?",
                "7. What is the 'main' method used for in Java?",
                "8. What is the purpose of the 'static' keyword in Java?",
                "9. How do you declare a variable that can hold a decimal number in Java?",
                "10. What is the 'this' keyword used for in Java?"
        };

        String[] options = {
                "A) final  B) static  C) constant",
                "A) class  B) void  C) new",
                "A) To limit access to the class  B) To define a method  C) To create an object",
                "A) A special method that is called when an object is created  B) A method for displaying text  C) A variable that cannot be changed",
                "A) int  B) String  C) float",
                "A) callClass()  B) new Class()  C) create Class;",
                "A) To print 'Hello, World!' to the console  B) Entry point for the program  C) To create a new class",
                "A) It defines a class as abstract  B) It creates a new instance of a class  C) It allows access to a class's members without creating an object",
                "A) double  B) char  C) decimal",
                "A) To refer to the current instance of the class  B) To create a new class  C) To call a static method"
        };

        int[] correctAnswers = {1, 1, 1, 1, 2, 2, 2, 3, 3, 1}; // 1-based index of correct answers

        System.out.println("Welcome to the Java Quiz!\n");

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println(options[i]);

            System.out.print("Enter the letter corresponding to your answer: ");
            String userAnswer = scanner.next().toLowerCase();

            int userChoice;
            switch (userAnswer) {
                case "a":
                    userChoice = 1;
                    break;
                case "b":
                    userChoice = 2;
                    break;
                case "c":
                    userChoice = 3;
                    break;
                default:
                    userChoice = 0;
            }

            if (userChoice == correctAnswers[i]) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + options[i].charAt(correctAnswers[i] - 1) + "\n");
            }
        }

        System.out.println("Quiz completed! Your score: " + score + " out of " + questions.length);

    }

    public void logout() {
        loggedIn = false;
        System.out.println("Logged out successfully.");
    }
}
