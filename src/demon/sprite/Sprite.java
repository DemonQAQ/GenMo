package demon.sprite;

import demon.base.function.Direction;
import demon.base.function.Element;
import demon.util.CommonUtils;
import demon.util.Constant;
import demon.util.GDraw;

import java.awt.*;

/*
 * GenMo demon.sprite
 * @Author:Demon
 * @Date:2021/12/27 8:56
 * @Description:
 */
public class Sprite implements GDraw
{
    protected int x, y;
    protected int width, height;
    Image Image;
    Direction direction;

    Sprite()
    {
        width = Constant.ELEMENT_SIZE;
        height = Constant.ELEMENT_SIZE;
        direction = Direction.RIGHT;
    }

    Sprite(int x, int y)
    {
        Element ann = this.getClass().getAnnotation(Element.class);
        this.x = x;
        this.y = y;
        this.direction = ann.direction();
        this.width = ann.width();
        this.height = ann.height();
        String imageName = ann.value().equals(Element.NOTHING) ? ann.leftImage() : ann.value();
        this.Image = CommonUtils.getImage(imageName);
    }

    //获取自身矩形
    public Rectangle getRectangle()
    {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }
    //判断是否相交
    public <E extends Sprite> boolean intersects(E element)
    {
        return this.getRectangle().intersects(element.getRectangle());
    }
    protected Image getImage()
    {
        return Image;
    }

    public void drawImage(Graphics g)
    {
        g.drawImage(this.getImage(), this.x, this.y, this.width, this.height, null);
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}
