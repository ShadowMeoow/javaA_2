package view.login;

import view.FrameUtil;
import view.game.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoginFrame extends JFrame {
    private JTextField username;
    private JTextField password;
    private JButton submitBtn;
    private JButton resetBtn;
    private GameFrame gameFrame;
    private static final String USER_DATA_FILE = "userdata.txt";
    private static Map<String, String> userDatabase = new HashMap<>();

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
            }
        });

        resetBtn.addActionListener(e -> {
            username.setText("");
            password.setText("");
        });

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

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

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
}
