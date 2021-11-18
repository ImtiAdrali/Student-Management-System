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
