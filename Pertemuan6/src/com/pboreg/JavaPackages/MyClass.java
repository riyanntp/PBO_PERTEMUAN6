package com.pboreg.JavaPackages;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter username ");

        String userName = myObj.nextLine();
        System.out.print("Username is: " + userName);
    }
}
