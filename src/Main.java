import model.MapModel;
import view.game.GameFrame;
<<<<<<< Updated upstream
import view.login.LoginChoiceFrame;
=======
import view.login.LoginFrame;
import view.welcome.WelcomeFrame;
>>>>>>> Stashed changes

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
<<<<<<< Updated upstream
            // 创建游戏主界面
=======
            // Create login frame (initially hidden)
            LoginFrame loginFrame = new LoginFrame(280, 280);
            loginFrame.setVisible(false);

            // Create welcome frame
            WelcomeFrame welcomeFrame = new WelcomeFrame(400, 400, loginFrame);
            welcomeFrame.setVisible(true);

            // Create game frame (initially hidden)
>>>>>>> Stashed changes
            MapModel mapModel = new MapModel(new int[][]{
                    {1, 2, 2, 1},
                    {1, 3, 2, 2},
                    {1, 3, 4, 4},
                    {0, 0, 4, 4}
            });
            GameFrame gameFrame = new GameFrame(600, 450, mapModel);
            gameFrame.setVisible(false);

            // 创建登录选择界面
            LoginChoiceFrame loginChoiceFrame = new LoginChoiceFrame(280, 280);
            loginChoiceFrame.setGameFrame(gameFrame);
            loginChoiceFrame.setVisible(true);
        });
    }

}
