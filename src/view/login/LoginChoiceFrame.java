package view.login;

import view.FrameUtil;
import view.game.GameFrame;
import model.MapModel;

import javax.swing.*;
import java.awt.*;

public class LoginChoiceFrame extends JFrame {
    private JButton guestBtn;
    private JButton newAccountBtn;
    private JButton loginBtn;
    private GameFrame gameFrame;
    private MapModel mapModel;

    public LoginChoiceFrame(int width, int height) {
        this.setTitle("Login Choice");
        this.setLayout(null);
        this.setSize(width, height);

        // 创建三个按钮
        guestBtn = FrameUtil.createButton(this, "访客登录", new Point(40, 40), 200, 40);
        newAccountBtn = FrameUtil.createButton(this, "创建新账号", new Point(40, 100), 200, 40);
        loginBtn = FrameUtil.createButton(this, "账号登录", new Point(40, 160), 200, 40);

        // 访客登录按钮事件
        guestBtn.addActionListener(e -> {
            if (this.gameFrame != null) {
                this.gameFrame.setVisible(true);
                this.setVisible(false);
            }
        });

        // 创建新账号按钮事件
        newAccountBtn.addActionListener(e -> {
            LoginFrame loginFrame = new LoginFrame(280, 280);
            loginFrame.setGameFrame(this.gameFrame);
            loginFrame.setVisible(true);
            this.setVisible(false);
        });

        // 账号登录按钮事件
        loginBtn.addActionListener(e -> {
            LoginFrame loginFrame = new LoginFrame(280, 280);
            loginFrame.setGameFrame(this.gameFrame);
            loginFrame.setVisible(true);
            this.setVisible(false);
        });

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
} 