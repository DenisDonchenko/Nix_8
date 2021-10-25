package ua.com.alevel;

import ua.com.alevel.controller.UserController;
import ua.com.alevel.entity.User;
import ua.com.alevel.util.valide.ValideUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ProgramRun {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final UserController controller = new UserController();

    public static void run() {
        System.out.println("Select your option.");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }
    private static void runNavigation() {
        System.out.println();
        System.out.println("if you want create user, please enter 1");
        System.out.println("if you want update user, please enter 2");
        System.out.println("if you want delete user, please enter 3");
        System.out.println("if you want findById user, please enter 4");
        System.out.println("if you want findAll user, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }
    private static void crud(String position) {
        switch (position) {
            case "1":
                createUser();
                break;
            case "2":
                updateUser();
                break;
            case "3":
                deleteUser();
                break;
            case "4":
                findById();
                break;
            case "5":
                controller.findAll();
                break;
            case "0":
                System.exit(0);
        }
        runNavigation();
    }

    private static String readName() throws IOException {
        System.out.println("Please, enter your name");
        String name = reader.readLine();
        if (!ValideUser.valideName(name)){
            readName();
        }
        return name;
    }
    private static String readPhoneNumber() throws IOException {
        System.out.println("Please, enter your phone number(09********)");
        String phoneNumber = reader.readLine();
        if (!ValideUser.validePhoneNumber(phoneNumber)){
            readPhoneNumber();
        }
        return phoneNumber;
    }
    private static String readEmail() throws IOException {
        System.out.println("Please, enter your email");
        String email = reader.readLine();
        if (!ValideUser.valideEmail(email)){
            readEmail();
        }
        return email;
    }
    private static LocalDate readBirthday() throws IOException {
        System.out.println("Please, enter your date birthday.");
        LocalDate birthday = null;
        try {
           birthday = addDate(reader.readLine());

      } catch (DateTimeParseException exceptionDate){
              System.out.println("Date input error, date must be entered in the format dd.MM.yyyy.");
              readBirthday();
          }
        return birthday;
    }
    private static void createUser() {
        System.out.println("Create user profile");
        User newUser = new User();
        try {

            String name = readName();
            newUser.setName(name);

            String phoneNumber = readPhoneNumber();
            newUser.setPhoneNumber(phoneNumber);

            String email = readEmail();
            newUser.setEmail(email);

            LocalDate birthday = readBirthday();
            newUser.setBirthday(birthday);

        } catch (IOException e) {
            System.out.println("Input error.");
            createUser();
        }
       controller.create(newUser);
    }
    private static void updateUser() {
        System.out.println("Update user profile");
        User newUser = new User();
        Long id = null;
        try {
            System.out.println("Please, enter id");
            id = Long.valueOf(reader.readLine());
            /*newUser.setId(id);*/

            String name = readName();
            newUser.setName(name);

            String phoneNumber = readPhoneNumber();
            newUser.setPhoneNumber(phoneNumber);

            String email = readEmail();
            newUser.setEmail(email);

            LocalDate birthday = readBirthday();
            newUser.setBirthday(birthday);

        } catch (IOException e) {
            System.out.println("Input error.");
            updateUser();
        }
        controller.update(newUser,id);
    }
    private static void deleteUser(){
        System.out.println("Delete user profile");
        System.out.println("Please, enter id");
        try {
            Long id = Long.valueOf(reader.readLine());
            controller.delete(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void findById() {
        System.out.println("Find user by ID.");
        try {
            System.out.println("Please, enter id");
            Long id = Long.valueOf(reader.readLine());
            controller.findById(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static LocalDate addDate(String date) {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, formatter1);
    }



}
