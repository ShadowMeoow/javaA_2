package view.welcome;

import view.FrameUtil;
import view.login.LoginFrame;

import javax.swing.*;
import java.awt.*;

public class WelcomeFrame extends JFrame {
    private JButton startBtn;
    private JButton loadBtn;
    private JButton exitBtn;
    private LoginFrame loginFrame;

    public WelcomeFrame(int width, int height, LoginFrame loginFrame) {
        this.setTitle("Welcome");
        this.setLayout(null);
        this.setSize(width, height);
        this.loginFrame = loginFrame;

        // Create welcome label
        JLabel welcomeLabel = FrameUtil.createJLabel(this, "Welcome to the Game", 
            new Font("Arial", Font.BOLD, 24), new Point(width/2 - 150, 50), 300, 40);

        // Create three buttons
        startBtn = FrameUtil.createButton(this, "Create a new account", new Point(width/2 - 100, 150), 200, 50);
        loadBtn = FrameUtil.createButton(this, "Load game", new Point(width/2 - 100, 220), 200, 50);
        exitBtn = FrameUtil.createButton(this, "Play as a guest", new Point(width/2 - 100, 290), 200, 50);

        // Add action listeners
        startBtn.addActionListener(e -> {
            if (loginFrame != null) {
                loginFrame.setVisible(true);
                this.setVisible(false);
                this.loginFrame.setStatus(0);
            }
        });

        loadBtn.addActionListener(e -> {
            //test
            this.loginFrame.setStatus(1);
//            System.out.println(loginFrame.getStatus());
            if (loginFrame != null) {
                loginFrame.setVisible(true);
                this.setVisible(false);
            }
        });

        exitBtn.addActionListener(e -> {
            System.exit(0);
        });

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

} 