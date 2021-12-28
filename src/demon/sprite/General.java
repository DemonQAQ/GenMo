package demon.sprite;

import demon.base.function.CreatureState;
import demon.base.function.Direction;
import demon.base.function.Element;
import demon.util.CommonUtils;

import java.awt.*;

/*
 * GenMo demon.sprite
 * @Author:Demon
 * @Date:2021/12/28 15:02
 * @Description:
 */
@Element(width = 200,height = 200,crashWidth = 150,crashHeight = 200,Image = "mobIdle.gif")
public class General extends Mob
{
    private Image idle;
    private Image hurt = CommonUtils.getImage("mobBehurt.gif");

    General()
    {
        state = new CreatureState();
        this.idle= this.getImage();
    }
    public General(int x, int y)
    {
        super(x, y);
        this.idle= this.getImage();
        this.state = new CreatureState();
        this.direction= Direction.LEFT;
        this.setHp(10000);
    }

    @Override
    void checkState()
    {
        if (state.isHurt())
        {
            this.Image = hurt;
            return;
        }
        if (state.isIdle())Image=idle;
    }

    @Override
    public void action()
    {
        checkState();
        super.action();
    }
}
