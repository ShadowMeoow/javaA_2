package view.login;

import view.FrameUtil;
import view.game.GameFrame;

import javax.swing.*;
import java.awt.*;
<<<<<<< Updated upstream
import java.io.*;
import java.util.HashMap;
import java.util.Map;
=======

//encapsulate account checking process
//What's new?   -"Username" can't be a name or password
//one "to do
// [ affect?
//load: you haven't login!
//to recover file, if registered, but not play, need a uniformed pattern
>>>>>>> Stashed changes

public class LoginFrame extends JFrame {
    private JTextField username;
    private JTextField password;
    private JButton submitBtn;
    private JButton resetBtn;
    private GameFrame gameFrame;
<<<<<<< Updated upstream
    private static final String USER_DATA_FILE = "userdata.txt";
    private static Map<String, String> userDatabase = new HashMap<>();
=======

    // 0 for create account, 1 for loading game, 2 for guest mode
    private int status;
    public final String[] invalidWords = {"Username", "Password", " "};
>>>>>>> Stashed changes

    public LoginFrame(int width, int height) {
        this.setTitle("Login Frame");
        this.setLayout(null);
        this.setSize(width, height);
        
        // 加载用户数据
        loadUserData();

        JLabel userLabel = FrameUtil.createJLabel(this, new Point(50, 20), 70, 40, "username:");
        JLabel passLabel = FrameUtil.createJLabel(this, new Point(50, 80), 70, 40, "password:");

        username = FrameUtil.createJTextField(this, new Point(120, 20), 120, 40);
        password = FrameUtil.createJTextField(this, new Point(120, 80), 120, 40);

        submitBtn = FrameUtil.createButton(this, "Confirm", new Point(40, 140), 100, 40);
        resetBtn = FrameUtil.createButton(this, "Reset", new Point(160, 140), 100, 40);

        submitBtn.addActionListener(e -> {
<<<<<<< Updated upstream
            String inputUsername = username.getText();
            String inputPassword = password.getText();

            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "用户名和密码不能为空！");
                return;
            }

            if (userDatabase.containsKey(inputUsername)) {
                if (userDatabase.get(inputUsername).equals(inputPassword)) {
                    if (this.gameFrame != null) {
                        this.gameFrame.setVisible(true);
                        this.setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "密码错误！");
                }
            } else {
                // 创建新账号
                userDatabase.put(inputUsername, inputPassword);
                saveUserData();
                if (this.gameFrame != null) {
                    this.gameFrame.setVisible(true);
                    this.setVisible(false);
                }
=======
            for (String s : invalidWords) {
                if (username.getText().contains(s)) {
                    JOptionPane.showMessageDialog(this,
                            "Username cannot contain invalid words!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (username.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Username cannot be empty!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (password.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Password cannot be empty!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (status == 0) {
                // Create account logic
                if (FileController.checkAccount(username.getText(), "data.text")) {
                    JOptionPane.showMessageDialog(this,
                            "Username already exists!\n" +
                            "Please login or change username ~",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                System.out.println("Username = " + username.getText());
                System.out.println("Password = " + password.getText());
                FileController.writer("Username = " + username.getText() + ";");
                FileController.writer("Password = " + password.getText() + ";");
            } else if (status == 1) {
                // Load game logic
                if (!FileController.checkAccount(username.getText(), "data.text")) {
                    JOptionPane.showMessageDialog(this,
                            "Username doesn't exist!" +
                            "please back and create a new account, " +
                            "or input the correct account",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!FileController.isPasswordMatch(password.getText(), username.getText(), "data.text")) {
                    JOptionPane.showMessageDialog(this,
                            "Password incorrect!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                this.gameFrame.setUsernameString(username.getText());
            } else if (status == 2) {
                // Guest mode logic
            }

            // Set username and show game frame for all valid states
            if (this.gameFrame != null) {
                this.gameFrame.setVisible(true);
                this.setVisible(false);
>>>>>>> Stashed changes
            }
        });

        resetBtn.addActionListener(e -> {
            username.setText("");
            password.setText("");
        });

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

<<<<<<< Updated upstream
    private void loadUserData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    userDatabase.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            // 如果文件不存在，创建一个新文件
            try {
                new File(USER_DATA_FILE).createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveUserData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DATA_FILE))) {
            for (Map.Entry<String, String> entry : userDatabase.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

=======
    public void setStatus(int status) {
        this.status = status;
    }
>>>>>>> Stashed changes
    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
    public int getStatus() {
        return status;
    }
}
