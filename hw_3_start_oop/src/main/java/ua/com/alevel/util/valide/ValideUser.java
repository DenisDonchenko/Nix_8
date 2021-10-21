package ua.com.alevel.util.valide;


import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;

public final class ValideUser {

    private ValideUser() {
    }

    private static final String REGEX_NAME = "^[А-Яа-яa-zA-Z-' ]{2,32}$";
    private static final String REGEX_PHONE_NUMBER = "^\\+?[0-9\\-\\s]{10}$";

    private static ResourceBundle settings = ResourceBundle.getBundle("message", Locale.ENGLISH);

    public static boolean valideName(String name) {
        boolean isValide = true;
        if (name.isEmpty()) {
            isValide = false;
            System.out.println(settings.getString("user.name.empty"));
        }
        if (!Pattern.matches(REGEX_NAME, name)) {
            isValide = false;
            System.out.println(settings.getString("user.name.format"));
        }
        if (name.length()<2 || name.length()>32 ){
            isValide = false;
            System.out.println(settings.getString("user.name.length.format"));
        }
        return isValide;
    }

    public static boolean validePhoneNumber(String phoneNumber) {
        boolean isValide = true;
        if (phoneNumber.isEmpty()) {
            isValide = false;
            System.out.println(settings.getString("user.phoneNumber.empty"));
        }
        if (!Pattern.matches(REGEX_PHONE_NUMBER, phoneNumber)) {
            isValide = false;
            System.out.println(settings.getString("user.phoneNumber.format"));
        }

        return isValide;
    }

    public static boolean valideEmail(String email) {
        boolean isValide = true;
        if (email.isEmpty()) {
            isValide = false;
            System.out.println(settings.getString("user.email.empty"));
        }
        if (!EmailValidator.getInstance().isValid(email)) {
            isValide = false;
            System.out.println(settings.getString("user.email.format"));
        }
        return isValide;
    }
    public static boolean valideBirthday(LocalDate birthday) {
        boolean isValide = true;

        if (birthday.isAfter(LocalDate.now())) {
            isValide = false;
            System.out.println(settings.getString("user.email.format"));
        }
        return isValide;
    }
}
