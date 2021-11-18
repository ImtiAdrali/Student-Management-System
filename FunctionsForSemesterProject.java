/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions.pkgfor.semester.project;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class FunctionsForSemesterProject {

    //public static int addrecord;
    public static int numberofquizesmarks;//totalnumber quizes marks taken by the student like it contains the number of quizes a student takes.
    public static int numberofcourcesofquiz;//total number of courses a specific student takes
    public static int numberofassignments;
    public static int numberofcourcesofassignments;
    public static ArrayList<Object> courselist = new ArrayList<>();//the values here are stored in the form --list[rollnumer,numberofcouces,rollnumber,numberofcourses]
    public static ArrayList<Object> courselist2 = new ArrayList<>();//the values here are stored in the form --list[rollnumber,courename,coursename,coursename]
    public static ArrayList<Object> Quizlist = new ArrayList<>();//using it to extract only the range for which the loop will run.....the values here are stored in the form ---list[rollnumber,coursename,totalnmberofquizes,coursename,totalnumberofquizes].
    public static ArrayList<Object> Quizlist2 = new ArrayList<>();//stores values in the list like--list[rollnumber,numerofcources,numberofquizes] and using it to get the sum of numberofcourses and quizes so that we can get the limit of the specific rollnumebr courses and quizes.
    public static ArrayList<Object> assignlist = new ArrayList<>();
    public static ArrayList<Object> assignlist2 = new ArrayList<>();

    public static void main(String[] args) {

        String[] userpass = new String[2];
        userpass[0] = "student";
        userpass[1] = "teacher";
        String username = "";
        Scanner input = new Scanner(System.in);
        Boolean b = true;
        while (b) {
            int option = Validation.intvalidation("     PRESS 1 TO ENTER INTO STUDENT SECTION  " + "\n"
                    + "     PRESS 2 TO ENTER INTO FACULTY SECTION  " + "\n"
                    + "     PRESS 3 TO EXIT ");
            while ((option > 3) || (option < 1)) {
                option = Validation.intvalidation("Incorrect option,Pls try again ! ");
            }
            if (option == 1) {
                System.out.println("Pls write your rollnumber in the form (AAA)! ");
                username = input.next();
                username = Validation.rollno(username);
                System.out.println("Enter the password ! ");
                String password = input.next();
                while (!userpass[0].equals(password)) {
                    System.out.println("Incorrect password! ");
                    password = input.next();
                }

                ///////Student menu: 
                int choice = Validation.intvalidation("     PRESS 1 TO VIEW THE COURSES YOU HAVE CHOOSEN " + "\n"
                        + "     PRESS 2 TO VIEW YOUR MARKS SUMMARY " + "\n"
                        + "     PRESS 3 TO VIEW YOUR PERSONAL DETAILS " + "\n"
                        + "     PRESS 4 TO CHANGE YOUR PERSONAL DETAILS " + "\n"
                        + "     PRESS 5 TO EXIT");
                String name = checknameinfile(username);
                while ((choice < 1) && (choice > 6)) {
                    choice = Validation.intvalidation("Incorrect option. Pls try again! ");
                }
                if (choice == 1) {
                    viewcourses(username);
                } else if (choice == 3) {
                    viewdetails(username);
                } else if (choice == 2) {
                    int opt = Validation.intvalidation("     Press 1 to view Assignment Marks! " + "\n"
                            + "     Press 2 to view Quiz Marks! " + "\n"
                            + "     Press 3 to view Exit  ");
                    while ((opt < 1) || (opt > 3)) {
                        opt = Validation.intvalidation("Incorrect option, Pls tryagain!");
                    }
                    if (opt == 1) {
                        viewAssign(username);
                    } else if (opt == 2) {
                        viewquizes(username);
                    } else if (opt == 3) {
                        break;
                    }

                } else if (choice == 4) {
                    editstudentdetails();
                } else if (choice == 5) {

                }
            } else if (option == 2) {
                System.out.println("Pls enteryour rollnumber in the form (AAA)! ");
                username = input.next();
                username = Validation.rollno(username);
                System.out.println("Enter the password ! ");
                String password = input.next();
                while (!userpass[1].equals(password)) {
                    System.out.println("Incorrect password! ");
                    password = input.next();
                }
                int choose = Validation.intvalidation("     PRESS 1 TO ENTER STUDENT DETAILS " + "\n"
                        + "     PRESS 2 TO EDIT STUDENT DETAILS " + "\n"
                        + "     PRESS 3 TO VIEW STUDENT DETAILS " + "\n"
                        + "     PRESS 4 TO EXIT ");
                while ((choose < 1) || (choose > 4)) {
                    choose = Validation.intvalidation("Incorrect option selected! Pls try again ");
                }
                if (choose == 1) {
                    int marks = Validation.intvalidation("     Press 1 to add Student details " + "\n"
                            + "     Press 2 to add Cources   " + "\n"
                            + "     Press 3 to add Quiz marks  " + "\n"
                            + "     Press 4 to add Assignment marks"
                            + "\n" + "     Press 5 to Exit ");
                    while ((marks < 1) || (marks > 4)) {
                        marks = Validation.intvalidation("Incorrect option selected! Pls try again ");
                    }

                    if (marks == 1) {
                        addstudentdetails();
                    } else if (marks == 2) {
                        addcourses();
                    } else if (marks == 3) {
                        addquiz();
                    } else if (marks == 4) {
                        addassignment();
                    } else if (marks == 5) {
                        break;
                    }
                } else if (choose == 2) {
                    int marks = Validation.intvalidation("     Press 1 to edit Student details " + "\n"
                            + "     Press 2 to edit Quiz marks  " + "\n"
                            + "     Press 3 to edit Assignment marks"
                            + "\n" + "     Press 4 to Exit ");
                    while ((marks < 1) || (marks > 4)) {
                        marks = Validation.intvalidation("Incorrect option selected! Pls try again ");
                    }
                    if (marks == 1) {
                        editstudentdetails();
                    } else if (marks == 2) {
                        editquizmarks();
                    } else if (marks == 3) {
                        editassignmarks();
                    } else if (marks == 4) {
                        break;
                    }
                } else if (choose == 3) {
                    int marks = Validation.intvalidation("     Press 1 to View Student details " + "\n"
                            + "     Press 2 to View Quiz marks  " + "\n"
                            + "     Press 3 to View Courses marks  " + "\n"
                            + "     Press 3 to View Assignment marks"
                            + "\n" + "     Press 4 to Exit ");
                    while ((marks < 1) || (marks > 4)) {
                        marks = Validation.intvalidation("Incorrect option selected! Pls try again ");
                    }
                    if (marks == 1) {
                        viewdetails(username);
                    } else if (marks == 2) {
                        viewquizes(username);
                    } else if (marks == 3) {
                        viewAssign(username);
                    } else if (marks == 4) {
                        break;
                    }
                } else if (choose == 4) {
                    break;
                }

            } else if (option == 3) {
                break;
            }
        }

    }

    public static void addstudentdetails() {//use while loop instead of for int loop
        Scanner input = new Scanner(System.in);
        File f = new File("rollfile.dat");
        try {
            DataOutputStream rollfile = new DataOutputStream(new FileOutputStream(f));
            DataInputStream output = new DataInputStream(new FileInputStream("rollfile.dat"));
            DataOutputStream namefile = new DataOutputStream(new FileOutputStream("details.dat"));
            int repeat = 0;
            while (repeat == 0) {
                System.out.println("Enter the Roll number of the Student in the form (AAA) ");
                String Rollno = input.next();
                Rollno = Validation.rollno(Rollno);
                Rollno = repeatofrollnum(Rollno, f);
                namefile.writeUTF(Rollno);
                rollfile.writeUTF(Rollno);
                System.out.println("Enter the name of the Student: ");
                String name = input.next();
                name = Validation.Nameex(name);
                namefile.writeUTF(name);
                System.out.println("Enter the Date of Birth of " + name);
                String DOB = input.next();
                namefile.writeUTF(DOB);
                System.out.println("Enter " + name + " contact number: ");
                String contact = input.next();
                contact = Validation.contact(contact);
                namefile.writeUTF(contact);
                System.out.println("Student Data Entered!");
                System.out.println("Do you want to add another student's data? (Y/N) ");
                String option = input.next();
                while (!option.equalsIgnoreCase("N") && (!option.equalsIgnoreCase("Y"))) {
                    System.out.println("Incorrect option selected, Pls try again! ");
                    option = input.next();
                }
                if (option.equalsIgnoreCase("Y")) {
                    repeat = 0;
                } else {
                    repeat = 1;
                }
            }
            output.close();

        } catch (IOException ex) {

        }

    }

    public static void addcourses() {
        Scanner input = new Scanner(System.in);
        File f = new File("Course.dat");
        File file = new File("details.dat");
        int range = checkfilecontentquizassign(file);
        if (range == 0) {
            System.out.println("");
            System.out.println("");
            System.out.println("Enter the Student Details First");
            System.out.println("");
            System.out.println("");
            return;
        }
        try {
            try (DataOutputStream course = new DataOutputStream(new FileOutputStream(f))) {
                int repeat = 0;
                while (repeat == 0) {
                    System.out.println("Write the Roll-number of the student whom do you want to add the Course in the form (AAA): ");
                    String roll_number = input.next();
                    roll_number = Validation.rollno(roll_number);
                    roll_number = checkrollfile(roll_number);
                    roll_number = repeatofrollnum(roll_number, f);
                    course.writeUTF(roll_number);
                    courselist.add(roll_number);
                    courselist2.add(roll_number);
                    String name = checknameinfile(roll_number);
                    int noofcourse = Validation.intvalidation("For " + name + " how much courses do you want to add? ");
                    courselist.add(noofcourse);
                    for (int i = 0; i < noofcourse; i++) {
                        System.out.println("Enter name of course " + (i + 1));
                        String coursename = input.next();
                        coursename = Validation.Nameex(coursename);
                        coursename = repeatofcourses(roll_number, coursename);
                        courselist2.add(coursename);
                        course.writeUTF(coursename);
                        System.out.println("Course Added! ");
                    }
                    System.out.println("Do you want to add course for another student? (Y/N)");
                    String option = input.next();
                    while (!option.equalsIgnoreCase("N") && (!option.equalsIgnoreCase("Y"))) {
                        System.out.println("Incorrect option selected, Pls try again! ");
                        option = input.next();
                    }
                    if (option.equalsIgnoreCase("Y")) {
                        repeat = 0;
                    } else {
                        repeat = 1;
                    }
                }

            }
        } catch (IOException ex) {
        }
    }

    public static void addquiz() {//Changing the format of the addquiz:

        Scanner input = new Scanner(System.in);
        File f = new File("Course.dat");
        int range = checkfilecontentquizassign(f);
        if (range == 0) {
            System.out.println("");
            System.out.println("");
            System.out.println("First Enter the Course Data First!!!!");
            System.out.println("");
            System.out.println("");
            return;//breaking the Function
        }
        try {
            int repeat = 0;
            DataOutputStream Quizfile = new DataOutputStream(new FileOutputStream("Quizfile.dat"));

            while (repeat == 0) {
                System.out.println("Write the Roll-number of the student whom do you want to add the quiz marks in the form (AAA): ");
                String roll_number = input.next();
                roll_number = Validation.rollno(roll_number);
                roll_number = checkrollfile(roll_number);//checking wether rolenumber is available in the file or not
                boolean find = false;
                while (find == false) {
                    for (int i = 0; i < courselist2.size(); i++) {
                        if (roll_number.equals(courselist2.get(i))) {
                            find = true;
                        }
                    }
                    if (find == false) {
                        System.out.println("The Rollnumber you have choosen doesot takes any course.Pls try again with the correct one! ");
                        roll_number = input.next();
                    }
                }
                Quizfile.writeUTF(roll_number);
                Quizlist.add(roll_number);
                Quizlist2.add(roll_number);
                int courserep = 0;
                while (courserep == 0) {
                    int numberofquiz = 0;
                    numberofcourcesofquiz++;
                    viewcourses(roll_number);
                    System.out.println("Enter the Course name for which you want to add Quiz marks? ");
                    String coursename = input.next();
                    coursename = Validation.Nameex(coursename);
                    coursename = checkcourseinfile(coursename, roll_number);
                    Quizlist.add(coursename);
                    Quizfile.writeUTF(coursename);
                    String name = checknameinfile(roll_number);
                    int noofquiz = 0;
                    while (noofquiz == 0) {
                        numberofquiz++;
                        numberofquizesmarks++;
                        System.out.println("Enter the Quiz Marks for " + name + " of the course " + coursename);
                        String marks = input.next();//Validation
                        marks = Validation.marksvalidation(marks);
                        Quizfile.writeUTF(marks);
                        System.out.println("Quiz Marks Added! ");
                        System.out.println("Do you want to add another Quiz marks for " + name + " fo the course  " + coursename + " ? (Y/N) ");
                        String option = input.next();
                        while (!option.equalsIgnoreCase("N") && (!option.equalsIgnoreCase("Y"))) {
                            System.out.println("Incorrect option selected, Pls try again! ");
                            option = input.next();
                        }
                        if (option.equalsIgnoreCase("Y")) {
                            noofquiz = 0;
                        } else {
                            noofquiz = 1;
                        }
                    }
                    Quizlist.add(numberofquiz);
                    System.out.println("Do you want to add another Course Quiz marks for " + name + " ? (Y/N) ");
                    String option = input.next();
                    while (!option.equalsIgnoreCase("N") && (!option.equalsIgnoreCase("Y"))) {
                        System.out.println("Incorrect option selected, Pls try again! ");
                        option = input.next();
                    }
                    if (option.equalsIgnoreCase("Y")) {
                        courserep = 0;
                    } else {
                        courserep = 1;
                    }
                }
                Quizlist2.add(numberofcourcesofquiz);
                Quizlist2.add(numberofquizesmarks);
                System.out.println("Do you want to add Quiz data for another Student? (Y/N) ");
                String option = input.next();
                while (!option.equalsIgnoreCase("N") && (!option.equalsIgnoreCase("Y"))) {
                    System.out.println("Incorrect option selected, Pls try again! ");
                    option = input.next();
                }
                if (option.equalsIgnoreCase("Y")) {
                    repeat = 0;
                } else {
                    repeat = 1;

                }
            }
        } catch (IOException ex) {
            System.out.println("EOF exception in adding the quiz file !");
        } catch (Exception ex) {
            System.out.println("Array Index out of bounds ");
        }

    }

    public static void addassignment() {
        Scanner input = new Scanner(System.in);
        File f = new File("Course.dat");
        int range = checkfilecontentquizassign(f);
        if (range == 0) {
            System.out.println("");
            System.out.println("");
            System.out.println("First Enter the Course Data First!!!");
            System.out.println("");
            System.out.println("");
            return;//breaking the Function
        }
        try {
            try (DataOutputStream Assign = new DataOutputStream(new FileOutputStream("Assign.dat"))) {
                int repeat = 0;
                while (repeat == 0) {
                    System.out.println("Write the Roll-number of the student whom do you want to add the Assignment marks in the form (AAA): ");
                    String roll_number = input.next();
                    roll_number = Validation.rollno(roll_number);
                    roll_number = checkrollfile(roll_number);//checking wether rolenumber is available in the file or not
                    Assign.writeUTF(roll_number);
                    assignlist.add(roll_number);
                    assignlist2.add(roll_number);
                    int courserep = 0;
                    while (courserep == 0) {
                        int numberofquiz = 0;
                        numberofcourcesofassignments++;
                        viewcourses(roll_number);
                        System.out.println("Enter the Course name for which you want to add Assignment marks? ");
                        String coursename = input.next();
                        coursename = Validation.Nameex(coursename);
                        coursename = checkcourseinfile(coursename, roll_number);
                        assignlist.add(coursename);
                        Assign.writeUTF(coursename);
                        String name = checknameinfile(roll_number);
                        int noofquiz = 0;
                        while (noofquiz == 0) {
                            numberofquiz++;
                            numberofassignments++;
                            System.out.println("Enter the Assignment Marks for " + name + " of the course " + coursename);
                            String marks = input.next();//Validation
                            marks = Validation.marksvalidation(marks);
                            Assign.writeUTF(marks);
                            System.out.println("Assignment Marks Added! ");
                            System.out.println("Do you want to add another Assignment marks for " + name + " fo the course  " + coursename + " ? (Y/N) ");
                            String option = input.next();
                            while (!option.equalsIgnoreCase("N") && (!option.equalsIgnoreCase("Y"))) {
                                System.out.println("Incorrect option selected, Pls try again! ");
                                option = input.next();
                            }
                            if (option.equalsIgnoreCase("Y")) {
                                noofquiz = 0;
                            } else {
                                noofquiz = 1;
                            }
                        }
                        assignlist.add(numberofquiz);
                        System.out.println("Do you want to add another Course Assignment marks for " + name + " ? (Y/N) ");
                        String option = input.next();
                        while (!option.equalsIgnoreCase("N") && (!option.equalsIgnoreCase("Y"))) {
                            System.out.println("Incorrect option selected, Pls try again! ");
                            option = input.next();
                        }
                        if (option.equalsIgnoreCase("Y")) {
                            courserep = 0;
                        } else {
                            courserep = 1;
                        }
                    }
                    assignlist2.add(numberofcourcesofassignments);
                    assignlist2.add(numberofassignments);
                    System.out.println("Do you want to add Assignment data for another Student? (Y/N) ");
                    String option = input.next();
                    while (!option.equalsIgnoreCase("N") && (!option.equalsIgnoreCase("Y"))) {
                        System.out.println("Incorrect option selected, Pls try again! ");
                        option = input.next();
                    }
                    if (option.equalsIgnoreCase("Y")) {
                        repeat = 0;
                    } else {
                        repeat = 1;
                    }
                }
            }
        } catch (IOException ex) {
        }
    }

    public static void editstudentdetails() {

        Scanner input = new Scanner(System.in);
        File f = new File("details.dat");
        int range = checkfilecontentquizassign(f);
        if (range == 0) {
            System.out.println("");
            System.out.println("");
            System.out.println("NO Data to Show");
            System.out.println("");
            System.out.println("");
            return;
        }
        try {

            int repeat = 0;
            int content = checkfilecontentname(f);
            while (repeat == 0) {
                DataInputStream output = new DataInputStream(new FileInputStream(f));
                String[][] mylist = new String[content][4];
                for (int i = 0; i < content; i++) {
                    for (int j = 0; j < 4; j++) {
                        mylist[i][j] = output.readUTF();
                    }
                }
                int i = 0;
                int index = 0;
                String name = "";
                System.out.println("Enter the Roll-Number of the student whom do you want to Edit the record in the form (AAA)? ");
                String rollno = input.next();
                rollno = Validation.rollno(rollno);
                checkrollfile(rollno);
                viewdetails(rollno);
                for (i = 0; i < mylist.length; i++) {
                    if (rollno.equals(mylist[i][0])) {
                        name = mylist[i][1];
                        index = i;
                    }
                }
                name = checknameinfile(rollno);
                output.close();
                output = new DataInputStream(new FileInputStream(f));
                DataOutputStream enter = new DataOutputStream(new FileOutputStream(f));
                System.out.println("For " + name + " Which Record do you want to edit? ");
                System.out.println("--------------------EDIT-MENU----------------------");
                System.out.println("PRESS N TO EDIT THE NAME ");
                System.out.println("PRESS D TO EDIT THE DATE OF BIRTH ");
                System.out.println("PRESS C TO EDIT CONTACT NUMBER");
                System.out.println("--------------------EDIT-MENU----------------------");
                String Option = input.next();
                while ((!"N".equalsIgnoreCase(Option)) && (!"D".equalsIgnoreCase(Option)) && (!"C".equalsIgnoreCase(Option))) {
                    System.out.println("Incorrect Option choosen, Pls try again! ");
                    Option = input.next();
                }
                if (Option.equalsIgnoreCase("N")) {
                    System.out.println("Enter NEW Name pls below: ");
                    String newname = input.next();
                    mylist[index][1] = newname;
                } else if (Option.equalsIgnoreCase("D")) {
                    System.out.println("Enter NEW Date-Of-Birth pls below: ");
                    String newdob = input.next();
                    mylist[index][2] = newdob;
                } else if (Option.equalsIgnoreCase("C")) {
                    System.out.println("Enter NEW Contact-Number pls below: ");
                    String newcontact = input.next();
                    newcontact = Validation.contact(newcontact);
                    mylist[index][3] = newcontact;
                }
                for (int a = 0; a < content; a++) {
                    for (int b = 0; b < 4; b++) {
                        enter.writeUTF(mylist[a][b]);
                    }
                }
                output.close();
                System.out.println("Do you want to edit another student's data?(Y/N) ");
                String option = input.next();
                if (option.equalsIgnoreCase("N")) {
                    repeat = 1;
                    System.out.println("The eddited details are below: ");
                    viewdetails(rollno);
                } else if (option.equalsIgnoreCase("N")) {
                    repeat = 0;
                }
            }

        } catch (EOFException ex) {
            System.out.println("EOF exception: ");
        } catch (IOException ex) {
            System.out.println("Error: ");
        }

    }

    public static void editquizmarks() {
        Scanner input = new Scanner(System.in);
        File f = new File("Quizfile.dat");
        int range = checkfilecontentquizassign(f);
        if (range == 0) {
            System.out.println("");
            System.out.println("");
            System.out.println("NO Data to Show");
            System.out.println("");
            System.out.println("");
            return;
        }
        String[] quizlist = new String[range];//declare quiz list
        try {
            DataInputStream output = new DataInputStream(new FileInputStream(f));//opening the file
            int repeat = 0;
            while (repeat == 0) {
                int count = 0;
                String value = " ";
                while (output.available() > 0) {
                    value = output.readUTF();
                    quizlist[count] = value;//writing the whole file into an array
                    count++;
                }
                output.close();
                System.out.println("Enter the Roll-Number of the student whom do you want to Edit the record? ");
                String rollno = input.next();
                rollno = Validation.rollno(rollno);
                rollno = checkrollfile(rollno);//checks wether the roll number written is entered inititally or not!

                //finding the index of the rollnumber in the array!
                int index = 0;
                for (int in = 0; in < quizlist.length; in++) {
                    if (rollno.equals(quizlist[in])) {
                        index = in;//getting the index of the specific rollnumber in the list! 
                    }
                }
                int Quizlist2index = 0;
                for (int i = 0; i < Quizlist2.size(); i++) {
                    if (rollno.equals(Quizlist2.get(i))) {
                        Quizlist2index = i;
                    }
                }
                int Quizlistindex = 0;
                for (int i = 0; i < Quizlist.size(); i++) {
                    if (rollno.equals(Quizlist.get(i))) {
                        Quizlistindex = i;
                    }
                }

                int counter = 0;
                while (counter == 0) {
                    viewcourses(rollno);//views the courses taken by the specific roll number
                    System.out.println("Out of the above Courses, Which course do you want to edit? Write its name:  ");
                    String coursename = input.next();
                    coursename = checkcourseinfile(coursename, rollno);//checks wether the sepcific roll number takes the specified course name or not!
                    //here we will add a loop which would check and prompt a message to re write the course name if its quiz marks are zero!
                    int val1 = Integer.parseInt((Quizlist2.get(Quizlist2index + 1)).toString());
                    int val2 = Integer.parseInt((Quizlist2.get(Quizlist2index + 2)).toString());
                    Boolean find = false;
                    while (find == false) {
                        for (int i = Quizlistindex; i < (val1 + val2); i++) {
                            if (coursename.equals(Quizlist.get(i))) {
                                find = true;
                                break;
                            }
                        }
                        if (find == false) {
                            System.out.println("The Written course's marks re not yet added, Pls write the course that's marks are added! ");
                            System.out.println("");
                            System.out.println("-------------");
                            viewcourses(rollno);
                            System.out.println("-------------");
                            viewquizes(rollno);
                            coursename = input.next();
                        }
                    }
                    viewquizes(rollno);
                    int countofquiz = countofmaksfromquizarraylist(coursename, rollno);//outputs the number of quizes a specific roll number has taken!
                    int option = Validation.intvalidation("Out of above Quizes, Which quiz do you want to edit? ");
                    while ((option > countofquiz)) {
                        option = Validation.intvalidation("Incorrect Option Selected! Pls try again: ");
                    }
                    System.out.println("Write NEW-MARKS for the Quiz: ");
                    String newmarks = input.next();
                    newmarks = Validation.marksvalidation(newmarks);
                    quizlist[(index + countofquiz) + (option - 1)] = newmarks;
                    System.out.println("The Quiz marks are updated!");
                    System.out.println("Do you want to Edit another quiz marks? (Y/N) ");
                    String opt = input.next();
                    while (!opt.equalsIgnoreCase("Y") && (!opt.equalsIgnoreCase("N"))) {
                        System.out.println("Incorrect Option Selected! Pls try again: ");
                        opt = input.next();
                    }
                    if (opt.equalsIgnoreCase("N")) {
                        counter = 1;
                    }
                }
                System.out.println("Do you want to Edit the marks for another Student? (Y/N)");
                String repopt = input.next();
                while (!repopt.equalsIgnoreCase("Y") && (!repopt.equalsIgnoreCase("N"))) {
                    System.out.println("Incorrect Option Selected! Pls try again: ");
                    repopt = input.next();
                }
                if (repopt.equalsIgnoreCase("N")) {
                    repeat = 1;
                    //at this stage the dataoutputstream is closed(no need to open the file)
                } else if (repopt.equalsIgnoreCase("Y")) {
                    repeat = 0;
                    output = new DataInputStream(new FileInputStream(f));//we have opened the file so that EOF Exception doesn't occurs!
                }
            }
            DataOutputStream enter = new DataOutputStream(new FileOutputStream(f));
            output = new DataInputStream(new FileInputStream(f));
            for (int a = 0; a < quizlist.length; a++) {
                enter.writeUTF(quizlist[a]);
            }
            //displaying the values of the file:
            output.close();
        } catch (EOFException ex) {
            System.out.println("EOF Exception");
        } catch (IOException ex) {
            System.out.println("Error: ");
        }
    }

    public static void editassignmarks() {
        Scanner input = new Scanner(System.in);
        File f = new File("Assign.dat");
        int range = checkfilecontentquizassign(f);
        if (range == 0) {
            System.out.println("");
            System.out.println("");
            System.out.println("NO Data to Show");
            System.out.println("");
            System.out.println("");
            return;
        }
        String[] Assignlist = new String[range];//declare quiz list
        try {
            DataInputStream output = new DataInputStream(new FileInputStream(f));//opening the file
            output.close();
            output = new DataInputStream(new FileInputStream(f));
            int repeat = 0;
            while (repeat == 0) {
                int count = 0;
                String value = " ";
                while (output.available() > 0) {
                    value = output.readUTF();
                    Assignlist[count] = value;//writing the whole file into an array
                    count++;
                }
                output.close();
                System.out.println("Enter the Roll-Number of the student whom do you want to Edit the record in the form (AAA)? ");
                String rollno = input.next();
                rollno = Validation.rollno(rollno);
                rollno = checkrollfile(rollno);//checks wether the roll number written is entered inititally or not!

                //finding the index of the rollnumber in the array!
                int index = 0;
                for (int in = 0; in < Assignlist.length; in++) {
                    if (rollno.equals(Assignlist[in])) {
                        index = in;//getting the index of the specific rollnumber in the list! 
                    }
                }
                int Quizlist2index = 0;
                for (int i = 0; i < assignlist2.size(); i++) {
                    if (rollno.equals(assignlist2.get(i))) {
                        Quizlist2index = i;
                    }
                }
                int counter = 0;
                while (counter == 0) {
                    viewcourses(rollno);//views the courses taken by the specific roll number
                    System.out.println("Out of the above Courses, Which course do you want to edit? Write its name:  ");
                    String coursename = input.next();
                    coursename = checkcourseinfile(coursename, rollno);//checks wether the sepcific roll number takes the specified course name or not!
                    //here we will add a loop which would check and prompt a message to re write the course name if its quiz marks are zero!
                    int val1 = Integer.parseInt((assignlist2.get(Quizlist2index + 1)).toString());
                    int val2 = Integer.parseInt((assignlist2.get(Quizlist2index + 2)).toString());
                    Boolean find = false;
                    while (find == false) {
                        for (int i = Quizlist2index; i < (val1 + val2); i++) {
                            if (coursename.equals(assignlist.get(i))) {
                                find = true;
                            }
                        }
                        if (find == false) {
                            System.out.println("The Written course's marks re not yet added, Pls write the course that's marks are added! ");
                            viewcourses(rollno);
                            coursename = input.next();
                        }
                    }
                    viewAssign(rollno);
                    int countofquiz = countofmaksfromassignarraylist(coursename, rollno);//outputs the number of quizes a specific roll number has taken!
                    int option = Validation.intvalidation("Out of above Quizes, Which quiz do you want to edit? ");
                    while ((option > countofquiz)) {
                        option = Validation.intvalidation("Incorrect Option Selected! Pls try again: ");
                    }
                    System.out.println("Write NEW-MARKS for the Assignment: ");
                    String newmarks = input.next();
                    newmarks = Validation.marksvalidation(newmarks);
                    Assignlist[(index + countofquiz) + (option - 1)] = newmarks;
                    System.out.println("The Assignment marks are updated!");
                    System.out.println("Do you want to Edit another quiz marks? (Y/N) ");
                    String opt = input.next();
                    while (!opt.equalsIgnoreCase("Y") && (!opt.equalsIgnoreCase("N"))) {
                        System.out.println("Incorrect Option Selected! Pls try again: ");
                        opt = input.next();
                    }
                    if (opt.equalsIgnoreCase("N")) {
                        counter = 1;
                    }
                }
                System.out.println("Do you want to Edit the marks for another Student? (Y/N)");
                String repopt = input.next();
                while (!repopt.equalsIgnoreCase("Y") && (!repopt.equalsIgnoreCase("N"))) {
                    System.out.println("Incorrect Option Selected! Pls try again: ");
                    repopt = input.next();
                }
                if (repopt.equalsIgnoreCase("N")) {
                    repeat = 1;
                    //at this stage the dataoutputstream is closed(no need to open the file)
                } else if (repopt.equalsIgnoreCase("Y")) {
                    repeat = 0;
                    output = new DataInputStream(new FileInputStream(f));//we have opened the file so that EOF Exception doesn't occurs!
                }
            }
            DataOutputStream enter = new DataOutputStream(new FileOutputStream(f));
            output = new DataInputStream(new FileInputStream(f));
            for (int a = 0; a < Assignlist.length; a++) {
                enter.writeUTF(Assignlist[a]);
            }
            output.close();
        } catch (EOFException ex) {
            System.out.println("EOF Exception");
        } catch (IOException ex) {
            System.out.println("Error: ");
        } catch (Exception ex) {
            System.out.println("Array index out of bounds ");
        }
    }

    public static int checkfilecontentname(File filename) {
        int count = 0;

        try (DataInputStream file = new DataInputStream(new FileInputStream(filename))) {
            while (file.available() > 0) {
                file.readUTF();
                count++;
            }
        } catch (IOException ex) {
        } finally {
            return (count / 4);//AS we have 4 attributes as name,rollnum,contatc,dob and we have to make the loop run for each  rollnumber, we divide the total count by the number of attributes so that we dont reach EOF
        }

    }

    public static int checkfilecontentquizassign(File filename) {
        int count = 0;
        String val = "";

        try (DataInputStream file = new DataInputStream(new FileInputStream(filename))) {
            while (file.available() > 0) {
                val = file.readUTF();
                count++;
            }
        } catch (IOException ex) {
            System.out.println("EOF exception in check file content ");
        } finally {
            return count;
        }

    }

    public static String checknameinfile(String rollnumber) {
        try {
            try (DataInputStream file = new DataInputStream(new FileInputStream("details.dat"))) {
                String name = "";
                while (file.available() > 0) {
                    String roll = file.readUTF();
                    if (rollnumber.equals(roll)) {
                        name = file.readUTF();
                        return name;
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("EOF exception!");
        }
        return "error in checknameinfile function";
    }

    public static String checkrollfile(String rollnumber) {
        Scanner input = new Scanner(System.in);
        try {
            int repeat = 0;
            while (repeat == 0) {
                rollnumber = rollnumber;
                DataInputStream output = new DataInputStream(new FileInputStream("rollfile.dat"));
                String rollvalue = " ";
                while (output.available() > 0) {
                    rollvalue = output.readUTF();
                    if (rollnumber.equals(rollvalue)) {
                        return rollnumber;
                    }
                }
                System.out.println("The written Rollnumber is not entered: Pls try with the correct Roll number in the form (AAA) :");
                rollnumber = input.next();
                rollnumber = Validation.rollno(rollnumber);
                output.close();
            }

        } catch (IOException ex) {

        }
        return "ERROR in check name file";
    }

    public static String repeatofrollnum(String rollnumber, File filename) {
        Scanner input = new Scanner(System.in);
        try {
            int repeat = 0;
            while (repeat == 0) {
                DataInputStream output = new DataInputStream(new FileInputStream(filename));
                rollnumber = rollnumber;
                int count = 0;
                String rollvalue = " ";
                while (output.available() > 0) {
                    rollvalue = output.readUTF();
                    if (rollvalue.equals(rollnumber)) {
                        count++;
                    }
                }
                output.close();
                if (count > 0) {
                    System.out.println("The Roll-Number you have entered is already entered! pls try again with a unique Roll-number in the form (AAA)! ");
                    rollnumber = input.next();
                    rollnumber = Validation.rollno(rollnumber);

                } else {
                    return rollnumber;
                }

            }
        } catch (IOException ex) {

        }
        return "Error in repeating Function ";
    }

    public static String repeatofcourses(String Rollnumber, String Coursename) {
        Scanner input = new Scanner(System.in);
        int repeat = 0;
        int rolindex = 0;
        for (int i = 0; i < courselist2.size(); i++) {
            if (Rollnumber.equals(courselist2.get(i))) {
                rolindex = i;
            }
        }

        while (repeat == 0) {
            int index = 0;
            Coursename = Coursename;
            for (int i = rolindex; i < courselist2.size(); i++) {
                if (Coursename.equals(courselist2.get(i))) {
                    index++;
                }
            }
            if (index > 0) {
                System.out.println("The course you entered is already there! Pls try with another one ");
                Coursename = input.next();
            } else {
                return Coursename;
            }
        }

        return "Problem in Repeat Coursename";
    }//checks the course and ensures that for a specif rollnumber, there are unique courses entered only and not repeating! 

    public static String checkcourseinfile(String Course, String rollnumber) {
        Scanner input = new Scanner(System.in);
        int index = 0;
        for (int i = 0; i < courselist.size(); i++) {
            if (rollnumber.equals(courselist.get(i))) {
                index = (int) courselist.get(i + 1);
            }
        }
        try {

            int rep = 0;
            String val = " ";
            String val1 = " ";
            while (rep == 0) {
                Course = Course;
                DataInputStream output = new DataInputStream(new FileInputStream("Course.dat"));
                while (output.available() > 0) {
                    val = output.readUTF();
                    if (rollnumber.equals(val)) {
                        for (int i = 0; i < index; i++) {
                            val1 = output.readUTF();
                            if (Course.equals(val1)) {
                                output.close();
                                return Course;
                            }
                        }
                    }
                }
                output.close();
                System.out.println("The Entered Course is not taken by the rollnumber " + rollnumber + " Pls Try again with correct one! ");
                Course = input.next();

            }
        } catch (IOException ex) {
            System.out.println("EOF EXCEPTION");
        }
        return "Problem in check course function";
    }//checks the course wether the specific rollnumber/student takes the course entered by the customer or not!

    public static void viewcourses(String rollnumber) {
        File f = new File("Course.dat");
        int range = checkfilecontentquizassign(f);
        if (range == 0) {
            System.out.println("");
            System.out.println("");
            System.out.println("First Enter the Course Data");
            System.out.println("");
            System.out.println("");
            return;//breaking the Function
        }
        try {

            int index = 0;
            for (int i = 0; i < courselist.size(); i++) {
                if (rollnumber.equals(courselist.get(i))) {
                    index = (int) courselist.get(i + 1);

                }
            }
            DataInputStream output = new DataInputStream(new FileInputStream("Course.dat"));
            String value = " ";
            while (output.available() > 0) {
                value = output.readUTF();
                if (value.equals(rollnumber)) {
                    System.out.println("Roll-Number " + value + " takes the following courses: ");
                    for (int i = 0; i < index; i++) {
                        System.out.println("Course " + (i + 1) + " = " + output.readUTF());
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("EOF exception");
        }
    }

    public static void viewquizes(String rollnumber) {
        File f = new File("Quizfile.dat");
        int range = checkfilecontentquizassign(f);
        if (range == 0) {
            System.out.println("");
            System.out.println("");
            System.out.println("First Enter the Quiz Data");
            System.out.println("");
            System.out.println("");
            return;//breaking the Function
        }

        int course_index = 0;
        for (int i = 0; i < Quizlist.size(); i++) {
            if (rollnumber.equals(Quizlist.get(i))) {
                course_index = i;
            }
        }
        int quiz_index = 0;
        for (int i = 0; i < courselist.size(); i++) {
            if (rollnumber.equals(courselist.get(i))) {
                quiz_index = i + 1;
            }
        }
        int totalquizes = Integer.parseInt((Quizlist.get(course_index + 2).toString()));
        int totalcources = Integer.parseInt((courselist.get(quiz_index)).toString());
        try {
            try (DataInputStream output = new DataInputStream(new FileInputStream("Quizfile.dat"))) {
                String val;
                String cname;
                while (output.available() > 0) {
                    val = output.readUTF();
                    if (val.equals(rollnumber)) {
                        for (int j = 0; j < totalcources; j++) {
                            cname = output.readUTF();
                            System.out.println("The " + rollnumber + " has the below quiz marks for the Course: " + cname);
                            for (int i = 0; i < totalquizes; i++) {
                                System.out.println("Quiz " + (i + 1) + " = " + output.readUTF());
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
        }
    }

    public static void viewAssign(String rollnumber) {
        File f = new File("Assign.dat");
        int range = checkfilecontentquizassign(f);
        if (range == 0) {
            System.out.println("");
            System.out.println("");
            System.out.println("First Enter the Assignment Data");
            System.out.println("");
            System.out.println("");
            return;//breaking the Function
        }

        int course_index = 0;
        for (int i = 0; i < assignlist.size(); i++) {
            if (rollnumber.equals(assignlist.get(i))) {
                course_index = i;
            }
        }
        int quiz_index = 0;
        for (int i = 0; i < courselist.size(); i++) {
            if (rollnumber.equals(courselist.get(i))) {
                quiz_index = i + 1;
            }
        }
        int totalquizes = Integer.parseInt((assignlist.get(course_index + 2).toString()));
        int totalcources = Integer.parseInt((courselist.get(quiz_index)).toString());
        try {
            try (DataInputStream output = new DataInputStream(new FileInputStream("Assign.dat"))) {
                String val;
                String cname;
                while (output.available() > 0) {
                    val = output.readUTF();
                    if (val.equals(rollnumber)) {
                        for (int j = 0; j < totalcources; j++) {
                            cname = output.readUTF();
                            System.out.println("The " + rollnumber + " has the below Assignment marks for the Course: " + cname);
                            for (int i = 0; i < totalquizes; i++) {
                                System.out.println("Assignment " + (i + 1) + " = " + output.readUTF());
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
        }
    }

    public static void viewdetails(String rollnumber) {
        File f = new File("details.dat");
        int range = checkfilecontentquizassign(f);
        if (range == 0) {
            System.out.println("");
            System.out.println("");
            System.out.println("First Enter the Student Data First ");
            System.out.println("");
            System.out.println("");
            return;//breaking the Function
        }
        try {
            DataInputStream output = new DataInputStream(new FileInputStream("details.dat"));
            while (output.available() > 0) {
                if (rollnumber.equals(output.readUTF())) {
                    output.readUTF();
                    System.out.println("The Roll number of " + checknameinfile(rollnumber) + " is " + rollnumber);
                    System.out.println("The Date of Birth of " + checknameinfile(rollnumber) + " is " + output.readUTF());
                    System.out.println("The Contact number of " + checknameinfile(rollnumber) + " is " + output.readUTF());
                }
            }

        } catch (IOException ex) {
            System.out.println("EOF Exception");
        }
    }

    public static int countofmaksfromquizarraylist(String coursename, String rollnumber) {//index is representing the location of the specific rollnumber in the list
        String cors;
        String[] mylist = new String[Quizlist.size()];
        for (int i = 0; i < mylist.length; i++) {
            mylist[i] = (Quizlist.get(i)).toString();
        }
        int index = 0;
        for (int i = 0; i < Quizlist.size(); i++) {
            if (rollnumber.equals(Quizlist.get(i))) {
                index = i;
            }
        }
        int ind = 0;
        for (int i = index; i < mylist.length; i++) {
            cors = mylist[i];
            if (cors.equals(coursename)) {
                ind = i + 1;
                break;
            }
        }
        int a = Integer.parseInt(mylist[ind]);
        return a;//getting the count of the number of marks.

    }//outputs the number of the marks of quizes

    public static int countofmaksfromassignarraylist(String coursename, String rollnumber) {//index is representing the location of the specific rollnumber in the list
        String cors;
        String[] mylist = new String[assignlist.size()];
        for (int i = 0; i < mylist.length; i++) {
            mylist[i] = (assignlist.get(i)).toString();
        }
        int index = 0;
        for (int i = 0; i < assignlist.size(); i++) {
            if (rollnumber.equals(assignlist.get(i))) {
                index = i;
            }
        }
        int ind = 0;
        for (int i = index; i < mylist.length; i++) {
            cors = mylist[i];
            if (cors.equals(coursename)) {
                ind = i + 1;
                break;
            }
        }
        int a = Integer.parseInt(mylist[ind]);
        return a;//getting the count of the number of marks.

    }

}

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions.pkgfor.semester.project;

/**
 *
 * @author Hp
 */
public class Global {

    public static int count;//This variable is used for the fuction filepointer
    public static int numberofcourse_quizmarks;//Thi is the number of courses taken
    public static int numberofquizes;//This is the number of quizes for the corse taken
    public static int numberofcourse_assignmarks;
    public static int numberofassignments;
    
}


package functions.pkgfor.semester.project;

import java.util.*;
import java.util.InputMismatchException;

public class SEMESTERPROJECT {

    public static void main(String[] args) {
        displaymenu();

    }

    public static void displaymenu() {
        System.out.println("     -----------MAIN SEARCH MENU----------- ");
        System.out.println("     PRESS 1 TO ENTER INTO STUDENT SECTION  " + "\n"
                + "     PRESS 2 TO ENTER INTO FACULTY SECTION  " + "\n"
                + "     PRESS 3 TO ENTER INTO PARENTS SECTION  ");
        System.out.println("     -----------MAIN SEARCH MENU----------- ");
    }

    public static void studentmenu() {
        System.out.println("     -------------STUDENT SEARCH MENU------------ ");
        System.out.println("     PRESS 1 TO VIEW THE COURSES YOU HAVE CHOOSEN " + "\n"
                + "     PRESS 2 TO VIEW YOUR MARKS SUMMARY " + "\n"
                + "     PRESS 3 TO VIEW YOUR PERSONAL DETAILS " + "\n"
                + "     PRESS 4 TO CHANGE YOUR PERSONAL DETAILS " + "\n"
                + "     PRESS 5 TO EXIT ");
        System.out.println("     -------------STUDENT SEARCH MENU------------ ");
    }

    public static void adminmenu() {
        System.out.println("     -----------------FACULTY SEARCH MENU----------------- ");
        System.out.println("     PRESS 1 TO ENTER STUDENT DETAILS " + "\n"
                + "     PRESS 2 TO EDIT STUDENT DETAILS " + "\n"
                + "     PRESS 3 TO VIEW STUDENT DETAILS " + "\n"
                + "     PRESS 4 TO EXIT ");
        System.out.println("     -----------------FACULTY SEARCH MENU----------------- ");
    }

}



+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions.pkgfor.semester.project;

import java.util.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

    public static void main(String[] args) {

    }

    public static int intvalidation(String sentence) {
        Scanner input = new Scanner(System.in);
        boolean c = true;
        int num = 0;
        while (c) {
            try {
                System.out.println(sentence);
                num = nullvalue(input.nextInt());

                return num;
            } catch (InputMismatchException ex) {
                System.out.println("Input Mismatch! Pls enter a correct value! ");
                input.next();
            }
        }
        return num;

    }

    public static String Nameex(String name) {
        Scanner input = new Scanner(System.in);
        while (!Pattern.matches("[a-zA-Z]+", name)) {
            System.out.println("Incorrect Format of name entered! Pls try again ");
            name = input.next();
        }
        return name;

    }

    public static int nullvalue(int value) {
        Scanner input = new Scanner(System.in);

        while (value <= 0) {
            System.out.println("You Have entered incorrect input, Pls enter a number above 0 ");
            value = input.nextInt();
        }
        return value;

    }

    public static String rollno(String a) {
        Scanner input = new Scanner(System.in);
        while (a.length() > 3) {
            System.out.println("Incorrect  Format Pls try again ");
            a = input.next();
        }
        int rep = 0;
        while (rep == 0) {
            a = a;
            boolean tr = true;
            String cha;
            String[] mylist = new String[3];
            for (int i = 0; i < 3; i++) {
                cha = String.valueOf(a.charAt(i));//converting chracter to string
                mylist[i] = cha;
            }
            for (int j = 0; j < 3; j++) {
                if (!Pattern.matches("[a-zA-Z]+", mylist[j])) {
                    System.out.println("Incorrect Format pls try again! ");
                    a = input.next();
                    tr = false;
                    break;
                }
            }
            if (tr == true) {
                rep = 1;
            }
        }
        return a;

    }

    public static String contact(String contact) {
        Scanner input = new Scanner(System.in);
        while (contact.length() > 12) {
            System.out.println("Incorrect format, Pls try again ");
            contact = input.next();
        }
        return contact;
    }

    public static String marksvalidation(String marks) {
        Scanner input = new Scanner(System.in);
        int val = 0;
        int rep = 0;
        while (rep == 0) {
            marks = marks;
            try {
                val = Integer.parseInt(marks);
                rep = 1;

            } catch (NumberFormatException ex) {
                System.out.println("Incorrect Format, pls write Integers only! ");
                marks = input.next();

            }
        }
        return marks;
    }
}


