package ua.com.alevel;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class StartOopMain {
    /*   public static void main(String[] args) {
     *//*

        String dateStr = "03.11.2000";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println(LocalDate.parse(dateStr,formatter1).format(formatter1));

*//*



    }*/


    public static void main(String args[]) throws IOException {
        ProgramRun programRun = new ProgramRun();
        programRun.run();
    }
}
