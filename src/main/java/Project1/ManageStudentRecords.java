package Project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Question: Build a console-based application to manage student records with features like
// add, update, delete, and view.
// Focuses on core Java, OOP, collections, and file handling

public class ManageStudentRecords {

    private static final Scanner scan = new Scanner(System.in);

    public interface StudentInputScanner {
        int scanMenuChoice();
        String scanName();
        LocalDate scanDob();
        String scanGrade();
        String scanSection();
        Integer[] scanSubjectMarks(String[] subjects);

        String scanSearchTerm();
        int scanChoice(String prompt, int min, int max);
        boolean scanConfirmation(String prompt);
    }

    public static class ConsoleStudentInputScanner implements StudentInputScanner {
        private final Scanner scanner;
        //private final Scanner scanner = new Scanner(System.in);
        public ConsoleStudentInputScanner(Scanner scan) {
            this.scanner = scan;
        }

        private String readNonEmptyInput(String prompt) {
            while(true) {
                System.out.println(prompt);
                String input = scanner.nextLine().trim();

                // Handle empty string input
                if(input.isEmpty()) {
                    System.out.println("Input can't be empty.");
                }
                // Handle comma  (for now to avoid having issues in csv)
                else if(input.contains(",")) {
                    System.out.println("Commas are not allowed.");
                } else {
                    return input;
                }
            }
        }

        @Override
        public int scanMenuChoice() {
            return scanChoice("Choose an option", 1, 5);
        }

        @Override
        public String scanName() {
//            while (true) {
//                System.out.print("Name: ");
//                String name = scanner.nextLine().trim();
//
//                // Handle empty name
//                if(!name.isEmpty()) {
//                    return name;
//                }
//                System.out.println("Name can't be empty. Please try again.");
//            }
            return readNonEmptyInput("Name: ");
        }

        @Override
        public LocalDate scanDob() {
            while (true) {
                System.out.print("D.O.B (yyyy-MM-dd): ");
                try {
                    LocalDate dob = LocalDate.parse(scanner.nextLine().trim());

                    // Handle future D.O.B
                    if(dob.isAfter(LocalDate.now())) {
                        System.out.println("Date of birth cannot be in the future.");
                        continue;
                    }
                    return dob;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid format! Please use yyyy-MM-dd.");
                }
            }
        }

        @Override
        public String scanGrade() {
//            System.out.print("Grade: ");
//            return scanner.nextLine().trim();
            return readNonEmptyInput("Grade: ");
        }

        @Override
        public String scanSection() {
//            System.out.print("Section: ");
//            return scanner.nextLine().trim();
            return readNonEmptyInput("Section: ");
        }

        @Override
        public Integer[] scanSubjectMarks(String[] subjects) {
            Integer[] scores = new Integer[subjects.length];
            System.out.println("Enter Subject Marks (Out of 100) ---");
            for (int i = 0; i < subjects.length; i++) {
                while (true) {
                    System.out.print(subjects[i] + ": ");
                    try {
                        int mark = Integer.parseInt(scanner.nextLine().trim());
                        if (mark >= 0 && mark <= 100) {
                            scores[i] = mark;
                            break;
                        }
                        System.out.println("Invalid mark! Must be 0 to 100");
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid integer");
                    }
                }
            }
            return scores;
        }
        @Override
        public String scanSearchTerm() {
            while (true) {
                System.out.print("Enter student name or ID: ");
                String value = scanner.nextLine().trim();

                if (!value.isEmpty()) {
                    return value;
                }

                System.out.println("Input cannot be empty.");
            }
        }

        @Override
        public int scanChoice(String prompt, int min, int max) {
            while (true) {
                System.out.print(prompt + ": ");

                // if (!scanner.hasNextLine()) {
                //     System.out.println("\nNo console input available. Exiting.");
                //     System.exit(0);
                // }

                try {
                    int choice = Integer.parseInt(
                            scanner.nextLine().trim()
                    );

                    if (choice >= min && choice <= max) {
                        return choice;
                    }

                    System.out.printf(
                            "Enter a number between %d and %d.%n",
                            min, max
                    );

                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid integer.");
                }
            }
        }

        @Override
        public boolean scanConfirmation(String prompt) {
            while (true) {
                System.out.print(prompt);
                String answer = scanner.nextLine()
                        .trim()
                        .toLowerCase();//

                if (answer.equals("y") || answer.equals("yes")) {
                    return true;
                }

                if (answer.equals("n") || answer.equals("no")) {
                    return false;
                }

                System.out.println("Please enter y or n.");
            }
        }
    }

    private static final StudentInputScanner inputScanner = new ConsoleStudentInputScanner(scan);
    private static final String[] SUBJECTS = {"English","Math","Biology","Chemistry","Physics"};
    private static final String FILE_PATH = "studentRecords.csv";

    static List<Student> students = new ArrayList<> ();

    static public void InitializeStudentsData() {
        // read from file to buffer
        // static method which reads from file and init arraylist with student info.
        try {
            students = loadFromCsvFile(FILE_PATH);
            if (!(students instanceof ArrayList)) {
                students = new ArrayList < > (students);
            }
        } catch (Exception e) {
            System.out.println("Starting with a blank list.");
            students = new ArrayList < > ();
        }
    }

    public static void main(String[] args) {

        // Build a console-based application to manage student records with features like
        // add, update, delete, and view.
        // Focuses on core Java, OOP, collections, and file handling

        // create a arraylist of student type and assigning from file buffer somehow
        InitializeStudentsData();

        int userChoice;
        do {
            System.out.println(
                    "Manage Student Records: \n" +
                            "1. Add New Student\n" +
                            "2. Update Student Details\n" +
                            "3. Delete Student\n" +
                            "4. View Student Details\n" +
                            "5. Exit\n\n"
            );
            userChoice = inputScanner.scanChoice(
                    "Choose an option", 1, 5
            );
            checkUserChoice(userChoice);
            /*
            System.out.print("Choose an option:_");
            try {
                userChoice = scan.nextInt();
                checkUserChoice(userChoice);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine(); // Consume the invalid line
                userChoice = 0;
            }
            */
        } while (userChoice != 5);

    }
    public static void saveToFile(List < Student > students) {
        saveToCsvFile(FILE_PATH, students);
        // later incase a different file per grade or subject required.
    }
    public static void checkUserChoice(int userChoice) {
        switch (userChoice) {
            case 1:
                addStudent();
                break;
            case 2:
                updateStudent();
                break;
            case 3:
                deleteStudent();
                break;
            case 4:
                viewStudent();
                break;
            case 5:
                System.out.println("Exiting program");
                return;
            default:
                System.out.println("Incorrect input. Please try again.\n");
        }
    }
    public static List < Student > loadFromCsvFile(String filePath) {
        List < Student > studentsFromCSV = new ArrayList<> ();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("No existing records. Starting fresh.\n");
            return studentsFromCSV;
        }
        int lineNumber = 0;
        int loadedCount = 0;
        int skippedCount = 0;

        try (BufferedReader bufReader = new BufferedReader(new FileReader(file))) {
            String currentLine;

            while ((currentLine = bufReader.readLine()) != null) {
                lineNumber++;
                currentLine = currentLine.trim();
                if (currentLine.isEmpty()) {
                    continue;
                }

                try {
                    String[] fields = currentLine.split(",", -1); // csv

                    // Expect 6 fields: id, name, dob, grade, section, scores
                    if (fields.length != 6) {
                        System.out.println("Skipping invalid CSV record."+ lineNumber);
                        skippedCount++;
                        continue;
                    }

                    String id = fields[0].trim();
                    String name = fields[1].trim();
                    LocalDate dob = LocalDate.parse(fields[2].trim());
                    String grade = fields[3].trim();
                    String section = fields[4].trim();

                    // Extract  "85;90;78;92;88"
                    String[] scoreTokens = fields[5].split(";", -1);
                    // Handle invlid csv
                    if (id.isEmpty() || name.isEmpty() || grade.isEmpty() || section.isEmpty()
                            || scoreTokens.length != SUBJECTS.length
                            || dob.isAfter(LocalDate.now())) {
                        System.out.println("Skipping invalid student record: " + id);
                        skippedCount++;
                        continue;
                    }

                    Integer[] scores = new Integer[scoreTokens.length];

                    for (int i = 0; i < scoreTokens.length; i++) {
                        scores[i] = Integer.parseInt(scoreTokens[i].trim());

                        if (scores[i] < 0 || scores[i] > 100) {
                            throw new IllegalArgumentException("Invalid mark");
                        }
                    }
                    studentsFromCSV.add(new Student(id, name, dob, grade, section, scores));
                    loadedCount++;

                } catch (RuntimeException  e) {
//                    System.err.println("Skipping invalid csv record: " + e.getMessage());
                    skippedCount++;
                    System.err.println(
                            "Skipping invalid CSV record at line " + lineNumber
                                    + ": " + e.getMessage()
                    );
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading csv file: " + e.getMessage());
            return studentsFromCSV;
        }
//        System.out.println("\nCSV Loading Summary");
//        System.out.println("Successfully loaded: " + loadedCount);
//        System.out.println("Skipped invalid records: " + skippedCount + "\n\n");
        System.out.printf("CSV Student records loaded: %d, skipped: %d%n%n",
                loadedCount, skippedCount);

        return studentsFromCSV;
    }
    public static void saveToCsvFile(String filePath, List < Student > students) {

        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student: students) {

                Integer[] scores = student.getScores();
                String scoreStr = Arrays.stream(scores)
                        .map(String::valueOf)
                        .collect(Collectors.joining(";"));

                String csvLine = String.join(",",
                        student.getId().toString(),
                        student.getName(),
                        student.getDob().toString(), // LocalDate yyyy-MM-dd
                        student.getGrade(),
                        student.getSection(),
                        scoreStr
                );
                bufWriter.write(csvLine);
                bufWriter.newLine(); // Move to the next line
            }
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    public static void addStudent() {
        // prompt student name, dob, class, section, marks(optional)
        /*
        Scanner scan = new Scanner(System.in);
        System.out.println("1 Add Student");


        System.out.print("\nName: ");
        String name  = scan.nextLine();
        System.out.print("\nD.O.B: ");
        LocalDate dob  = LocalDate.parse(scan.nextLine());
        System.out.print("\nGrade: ");
        String grade  = scan.nextLine();
        System.out.print("\nSection: ");
        String section  = scan.nextLine();
        System.out.print("\scores: ");


        Integer[] scores  = Integer.valueOf(scan.nextLine());// need multiple
        String id = String.valueOf(UUID.randomUUID());
        Student newStudent = new Student(id, name, dob, grade, section, score);


        students.add(newStudent);
        //update file
        */

        System.out.println("1. Add Student ========");
        String name = inputScanner.scanName();
        LocalDate dob = inputScanner.scanDob();
        String grade = inputScanner.scanGrade();
        String section = inputScanner.scanSection();
        Integer[] scores = inputScanner.scanSubjectMarks(SUBJECTS);

        String id = String.valueOf(UUID.randomUUID());
        Student newStudent = new Student(id, name, dob, grade, section, scores);

        students.add(newStudent);
        System.out.println("Student added successfully with ID: " + id + "\n --------- \n\n");
        saveToFile(students);
    }
    private static Student selectStudent() {
        String search = inputScanner.scanSearchTerm();

        List<Student> matches = students.stream()
                .filter(s ->
                        s.getName().equalsIgnoreCase(search) ||
                                s.getId().equalsIgnoreCase(search))
                .toList();

        if (matches.isEmpty()) {
            System.out.println("No student found.");
            return null;
        }

        if (matches.size() == 1) {
            return matches.get(0);
        }

        System.out.println("Multiple students found:");

        for (int i = 0; i < matches.size(); i++) {
            Student s = matches.get(i);

            System.out.printf(
                    "%d. %s | Grade: %s | Section: %s | ID: %s%n",
                    i + 1,
                    s.getName(),
                    s.getGrade(),
                    s.getSection(),
                    s.getId()
            );
        }

        int choice = inputScanner.scanChoice(
                "Choose a student",
                1,
                matches.size()
        );

        return matches.get(choice - 1);
    }

    public static void updateStudent() {
        // prompt search student with id name,then which property to update
        System.out.println("2. Update Student ========");

        Student student = selectStudent();

        if (student == null) {
            return;
        }

        System.out.println(
                "\nUpdating: " + student.getName() +
                        " | Grade: " + student.getGrade() +
                        " | Section: " + student.getSection()
        );

        System.out.println(
                "1. Name\n" +
                        "2. Date of Birth\n" +
                        "3. Grade\n" +
                        "4. Section\n" +
                        "5. Subject Marks\n" +
                        "6. Cancel"
        );

        int choice = inputScanner.scanChoice("Choose a property",1,6);

        switch (choice) {
            case 1:
                student.setName(inputScanner.scanName());
                break;

            case 2:
                student.setDob(inputScanner.scanDob());
                break;

            case 3:
                student.setGrade(inputScanner.scanGrade());
                break;

            case 4:
                student.setSection(inputScanner.scanSection());
                break;

            case 5:
                student.setScores(
                        inputScanner.scanSubjectMarks(SUBJECTS)
                );
                break;

            case 6:
                System.out.println("Update cancelled." + "\n --------- \n\n");
                return;
        }

        saveToFile(students);

        System.out.println("Student updated successfully." + "\n --------- \n\n");
    }
    public static void deleteStudent() {
        // prompt student id
        System.out.println("3. Delete Student ========");

        Student student = selectStudent();

        if (student == null) {
            return;
        }

        System.out.println(
                "Delete " + student.getName() +
                        " (ID: " + student.getId() + ")?"
        );

        if (inputScanner.scanConfirmation(
                "Confirm deletion (y/n): ")) {

            students.remove(student);

            saveToFile(students);

            System.out.println("Student deleted successfully." + "\n --------- \n\n");
        } else {
            System.out.println("Deletion cancelled." + "\n --------- \n\n");
        }
    }
    public static void viewStudent() {
        // prompt student id, name => show.
        // in future may be show all - first 10 and load more or cancel or search - complicated.
        System.out.println("4. View Student ========");

        Student student = selectStudent();

        if (student == null) {
            return;
        }

        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("D.O.B: " + student.getDob());
        System.out.println("Age: " + student.getAge());
        System.out.println("Grade: " + student.getGrade());
        System.out.println("Section: " + student.getSection());

        Integer[] marks = student.getScores();

        for (int i = 0; i < SUBJECTS.length; i++) {
            System.out.println(
                    SUBJECTS[i] + ": " + marks[i]
            );
        }
        System.out.println("\n --------- \n\n");

    }

}

// studentID, name, age, grade, section,

// Marks
// student ID, Eng Mark, Math, Bio, Chem, Phy

class Student {
    // props ID, name, class, age, section, marks
    // but marks can be subject wise for a class or a section with student ID
    // subject would have an ID then subId + studentID becomes index

    private String id;
    private String name;
    private LocalDate dob;
    private String grade;
    private String section;
    private Integer[] scores;

    Student(String id, String name, LocalDate dob, String grade, String section, Integer[] scores) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.grade = grade;
        this.section = section;
        this.scores = scores;
    }

    int getAge() {
        // calculate from  dob and return;
        LocalDate today = LocalDate.now();
        Period age = Period.between(dob, today);
        return age.getYears();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public String getGrade() {
        return this.grade;
    }

    public String getSection() {
        return this.section;
    }

    public Integer[] getScores() {
        return this.scores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setScores(Integer[] scores) {
        this.scores = scores;
    }
}

class Marks {
    private String subjectID;
    private String subjectName;
    private String marks;
    // or should it be mark1, mark2
    // or hashmap of subject id , mark
}
// another list of
// subject id => subject name, max mark

