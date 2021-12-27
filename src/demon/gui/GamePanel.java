package demon.gui;

import demon.util.CommonUtils;
import demon.util.GDraw;

import java.awt.*;
import javax.swing.*;


/*
 * GenMo demon.gui
 * @Author:Demon
 * @Date:2021/12/26 17:46
 * @Description:game's panel
 */
public class GamePanel extends JPanel
{
    private GDraw[] draws;
    private Image image;
    private Image backgroundImage;

    public GamePanel(GDraw... draws)
    {
        this.draws = draws;
        backgroundImage = CommonUtils.getImage("background.png");
    }
    //缓冲画图
    public void drawBufferedImage()
    {
        image = createImage(this.getWidth(),this.getHeight());
        Graphics g = image.getGraphics();
        g.drawImage(backgroundImage,0,0,this.getWidth(),this.getHeight(),this);
        for (GDraw draw:draws)
        {
            draw.drawImage(g);
        }
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        drawBufferedImage();
        g.drawImage(image,0,0,this);
    }
}
