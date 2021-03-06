package com.company;

import com.company.controllers.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final UserController controller;
    private final Scanner scanner;

    public MyApplication(UserController controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start(){
        while(true){
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option: (1-4)");
            System.out.println("1. Get all users");
            System.out.println("2. Get user by id");
            System.out.println("3. Create user");
            System.out.println("4. Get user by name");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter the option: (1-4)");
                int option = scanner.nextInt();
                if(option==1){
                    getAllUsersMenu();
                }
                else if(option ==2){
                    getUserByIdMenu();
                }
                else if(option == 3){
                    createUserMenu();
                }
                else if(option == 4){
                    getUserByNameMenu();
                }
                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("*******************************");
        }
    }
    public void getAllUsersMenu(){
        String response = controller.getAllUsers();
        System.out.println(response);
    }

    public void getUserByIdMenu(){
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getUser(id);
        System.out.println(response);
    }

    public void getUserByNameMenu(){
        System.out.println("Please enter name");
        String name = scanner.next();
        String response = controller.getUserByName(name);
        System.out.println(response);
    }

    public void createUserMenu(){
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter gender (Male/Female)");
        String gender = scanner.next();
        String response = controller.createUser(name, surname, gender);
        System.out.println(response);
    }

}
