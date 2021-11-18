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
