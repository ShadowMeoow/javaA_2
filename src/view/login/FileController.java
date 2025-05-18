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
            boolean flag = false; // pseudo, repair document
            if (line.contains("Username = ") || flag) {
                if (line.contains("= " + account + ";")) {
                    return true;
                }
            }
        }
        return false;
    }
    //copy from checkAccount directly
    private static boolean checkPassword(String password, String nextLine) {
        ArrayList<String> document = new ArrayList<>();
        document.add(nextLine);
        for (String line : document) {
            boolean flag = false; // pseudo, repair document
            if (line.contains("Password = ") || flag) {
                if (line.contains("= " + password + ";")) {
                    return true;
                }
            }
        }
        return false;
    }
    /*
    return true when correct
    // password should be at the second line of account
    // after checking account, otherwise, return false(when account doesn't exist)
     */
<<<<<<< Updated upstream
    public static boolean checkPassword(String password, String account, String filePath) {
=======
    public static boolean isPasswordMatch(String password, String account, String filePath) {
>>>>>>> Stashed changes
        ArrayList<String> document = FileController.readerAll(filePath);
        for (int i = 0; i < document.size(); i++) {
            if (FileController.checkAccount(account, "data.text")) {
                try {
                    return FileController.checkPassword(password, document.get(i + 1));
                } catch (Exception e) {
                    //todo, give a message window
                    //message destroy
                    //password can't be empty
                }
            }
        }
        return false;
    }

<<<<<<< Updated upstream
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
=======

    public static void panelDataSaver(ArrayList<int[][]> arrayList) {
        String s = matrixComputation.historyToString(arrayList);
        FileController.writer(s);
        FileController.writer("Step = " + stepDataSaver());
    }
    //todo
    public static int stepDataSaver() {
        return 0;
    }

    public static ArrayList<String> checkHistory(String filePath, String account) {
        ArrayList<String> document = FileController.readerAll(filePath);
        for (int i = 0; i < document.size(); i++) {
            if (FileController.checkAccount(account, "data.text")) {
                try {
                    if (document.get(i + 2).startsWith("[")) {
                        ArrayList<String> historyLoad = new ArrayList<>();
                        for (int j = i + 2; j < document.size(); j++) {
                            if (!document.get(j).equals("MatrixEnd")) {
                                historyLoad.add(document.get(j));
                            } else {
                                break;
                            }
                        }
                        return historyLoad;
                    }
                    //todo else?
                } catch (Exception e) {
                    //todo, give a message window
                    //message destroy
                    //password can't be empty
                }
            }
        }
        return null;
    }
    //recover document todo
    public static ArrayList<int[][]> LoadingHistory(ArrayList<String> document) {
        ArrayList<int[][]> returnAl = new ArrayList<>();
        if (document.size() % 4 != 0) {
            return null;
        }
        for (int i = 0; i < document.size() / 4; i++) {
            int[][] temp = new int[4][];
            for (int j = 0; j < 4; j++) {
                int k = i * 4 + j;
                int[] a = MatrixReader(document.get(k));
                temp[j] = a;
            }
            returnAl.add(temp);
        }
        System.out.println(matrixComputation.historyToString(returnAl));
        return returnAl;
    }

    public static int[] MatrixReader(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Integer> returnArray = new ArrayList<>();
        int[] array;
        for (char c : chars) {
            if ((int) c <= 57 && (int) c >= 48) {
                returnArray.add((int) c - 48);
            }
        }
        array = new int[returnArray.size()];
        for (int i = 0; i < returnArray.size(); i++) {
            array[i] = returnArray.get(i);
        }
        return array;
>>>>>>> Stashed changes
    }
}
