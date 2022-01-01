package demon.sprite;

import demon.base.function.Direction;
import demon.base.function.Element;
import demon.base.function.Gravity;
import demon.util.CommonUtils;
import demon.util.Constant;

/*
 * GenMo demon.base
 * @Author:Demon
 * @Date:2021/12/27 8:58
 * @Description:
 */
@Element(width = Constant.FRAME_WIDTH,height = 129,direction = Direction.RIGHT)
public class Ground extends MotionlessSprite
{
    public Ground(String name)
    {
        super(0,Constant.GROUND_LEVEL);
        this.Image = CommonUtils.getImage(name);
    }

    @Override
    public <E extends Sprite> boolean aboveIntersects(E element)
    {
        if(super.aboveIntersects(element))
        {
            return checkGravity(element);
        }
        return false;
    }

    private <E extends Gravity> boolean fallDownGround(E sprite)
    {
        sprite.onTheGround();
        return true;
    }

    private boolean checkGravity(Sprite sprite)
     {
         if (sprite instanceof Gravity)return true;
         else return false;
     }
}
