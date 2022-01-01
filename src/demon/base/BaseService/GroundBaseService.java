package demon.base.BaseService;

import demon.sprite.GravityMotionSprite;
import demon.sprite.Ground;
import demon.sprite.Player;
import demon.sprite.Sprite;
import demon.util.Constant;

import java.awt.*;

/*
 * GenMo demon.base.BaseService
 * @Author:Demon
 * @Date:2021/12/27 15:18
 * @Description:
 */
public class GroundBaseService extends GBaseService<GravityMotionSprite>
{
    private Ground ground;
    private Graphics g;

    public GroundBaseService()
    {
    }

    public Ground getGround()
    {
        return ground;
    }

    public void setGround(Ground ground)
    {
        this.ground = ground;
    }

    public void groundJudge(Ground ground)
    {
        Player p;
        for (GravityMotionSprite sprite : this.getElementList())
        {
            if (ground.aboveIntersects(sprite))
            {
                sprite.setGroundFLag(true);
                if (sprite instanceof Player)
                {
                    p = (Player) sprite;
                    p.state.setFly(false);
                    p.state.setIdle(true);
                }
                sprite.setY(Constant.GROUND_LEVEL-sprite.getHeight()+10);
            }
        }
    }

    @Override
    public void drawImage(Graphics g)
    {
        this.g = g;
        ground.setX(0);
        ground.setY(Constant.GROUND_LEVEL);
        ground.drawImage(g);
    }

    public Graphics getG()
    {
        return this.g;
    }
}
