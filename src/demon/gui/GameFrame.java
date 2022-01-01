package demon.gui;

import demon.base.GameContent;
import demon.sprite.Ground;
import demon.sprite.Player;
import demon.util.CommonUtils;
import demon.util.Constant;
import demon.util.Keys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * GenMo demon.gui
 * @Author:Demon
 * @Date:2021/12/26 23:04
 * @Description:
 */
public class GameFrame extends JFrame
{
    public GameFrame()
    {
        this.setTitle("GenDemon");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension size = new Dimension(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);
        int width = toolkit.getScreenSize().width;
        int height = toolkit.getScreenSize().height;
        this.setBounds((int) (width - size.getWidth()) / 2,
                (int) (height - size.getHeight()) / 3, (int) size.getWidth(), (int) size.getHeight());

        //初始化游戏内容
        this.init();
    }
    private void init()
    {
        Ground ground = new Ground("ground.png");
        GameContent content = new GameContent(ground);
        GamePanel panel = new GamePanel(content);
        panel.setVisible(true);
        this.add(panel);
        CommonUtils.task(5,()->
        {
            panel.repaint();
            //
        });
        this.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                Keys.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                Keys.remove(e.getKeyCode());
            }
        });
    }
}
