package demon.sprite;

import demon.util.Constant;

import java.awt.*;

/*
 * GenMo demon.base
 * @Author:Demon
 * @Date:2021/12/27 8:57
 * @Description:
 */
public class MotionlessSprite extends Sprite
{
    MotionlessSprite(){}
    MotionlessSprite(int x,int y)
    {
        super(x,y);
    }

    public <E extends Sprite> boolean aboveIntersects(E element) {
        Rectangle myself = this.getRectangle();
        Rectangle be = element.getRectangle();
        return be.getY() >= (Constant.GROUND_LEVEL - myself.height);
    }
}
