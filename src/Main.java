import model.MapModel;
import view.game.GameFrame;
import view.login.LoginChoiceFrame;

import javax.swing.*;

//666

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 创建游戏主界面
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

    public static void no() {
        
    }
}
