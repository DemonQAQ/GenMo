package demon.base.BaseService;

import demon.sprite.GravityMotionSprite;
import demon.sprite.Ground;
import demon.sprite.Player;
import demon.sprite.Sprite;
import demon.util.Constant;

/*
 * GenMo demon.base.BaseService
 * @Author:Demon
 * @Date:2021/12/27 15:18
 * @Description:
 */
public class GroundBaseService extends GBaseService<GravityMotionSprite>
{
    private Ground ground;
    public GroundBaseService()
    {
    }
    public void groundJudge(Ground ground)
    {
        this.ground = ground;
        Player p;
        for (GravityMotionSprite sprite:this.getElementList())
        {
            if (ground.aboveIntersects(sprite))
            {
                sprite.setGroundFLag(true);
                if (sprite instanceof Player)
                {
                    p = (Player)sprite;
                    p.state.setFly(false);
                    p.state.setIdle(true);
                }
                sprite.setY(Constant.GROUND_LEVEL - ground.getHeight() + 8);
            }
        }
    }
}
