package Java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {
    private final Scanner reader = new Scanner(System.in);

    public void printChoice(){
        System.out.println("Word Java.Counter ");
        System.out.println("===============");
        System.out.println("1) Number of Characters");
        System.out.println("2) Number of Words");
        System.out.println("3) Number of Lines");
        System.out.println("Please select an option (or input -1 to exit programme): ");
    }

    public int getChoice(){
        int choice = 0;
        while(choice == 0 || choice >= 4){
            try{
                choice = reader.nextInt();
                if (choice == 0 || choice >= 4) throw new InputMismatchException();
                reader.nextLine();
            }catch(InputMismatchException e){
                System.out.println("Invalid input");
                reader.nextLine();
            }
        }
        return choice;
    }

    public File validateFile(File file){
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            if(line == null){
                throw new IOException();
            }
        }catch (IOException e){
            System.out.println("Invalid file");
            return null;
        }
        System.out.println("Valid File");
        return file;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Manager manager = new Manager();
        int choice;
        String name;
        File file = null;
        int count = 0;
        String s = "";

//      Accept file
        while( file == null) {
            System.out.println("Please input file path to be read: ");
            name = reader.nextLine();
            //        Validate File
            file = manager.validateFile(new File(name));
        }

        manager.printChoice();
        choice = manager.getChoice();
        switch (choice) {
            case 1 -> {
                count = new CharacterCounter().getCount(file);
                s = "characters";
            }
            case 2 -> {
                count = new WordCounter().getCount(file);
                s = "words";
            }
            case 3 -> {
                count = new LineCounter().getCount(file);
                s = "lines";
            }
            default -> {
                System.out.println("Goodbye");
                System.exit(2);
            }
        }
        System.out.println("The number of " + s + " are " + count);
    }
}
