package view.login;

import java.io.*;
import java.util.ArrayList;

//rows are destroyed row //beginning message.
//comment


public class FileController {
    public static void writer(String toBeWritten) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.text", true))) {
            writer.write(toBeWritten);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    //having being tested in 2 different lines
    public static ArrayList<String> readerAll(String filePath) {
        ArrayList<String> allData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                allData.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return allData;
    }

    // check whether the account exist in profile
    public static boolean checkAccount(String account, String filePath) {
        ArrayList<String> document = FileController.readerAll(filePath);
        for (String line : document) {
            if (line.equals(account)) {
                return true;
            }
        }
        return false;
    }

    /*
    return true when correct
    // password should be at the second line of account
    // after checking account, otherwise, return false(when account doesn't exist)
     */
    public static boolean checkPassword(String password, String account, String filePath) {
        ArrayList<String> document = FileController.readerAll(filePath);
        for (int i = 0; i < document.size(); i++) {
            if (document.get(i).equals(account)) {
                try {
                    return document.get(i + 1).equals(password);
                } catch (Exception e) {
                    //todo, give a message window
                    //message destroy
                    //password can't be empty
                }
            }
        }
        return false;
    }

    /*
    no auto save or save btn
    should return step
     */
    public static void panelDataSaver(ArrayList<int[][]> arrayList) {
        String s = matrixComputation.historyToString(arrayList);
        FileController.writer(s);
        FileController.writer(FileController.stepDataSaver() + "");//pseudo
    }

    //need write
    public static ArrayList<String> revisedGameData(String account) {
        ArrayList<String> allData = FileController.readerAll("data.text");
        return null;
    }

    //pseudo
    public static int stepDataSaver() {
        return 0;
    }
}
