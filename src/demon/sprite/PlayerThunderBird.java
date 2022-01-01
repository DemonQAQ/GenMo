package demon.sprite;

import demon.base.BaseService.DamageBaseService;
import demon.base.BaseService.EffectBaseService;
import demon.base.function.Direction;
import demon.util.CommonUtils;
import demon.util.FlipImage;
import demon.util.GetService;

import java.awt.*;
import java.io.FileInputStream;
import java.util.Timer;
import java.util.TimerTask;

/*
 * GenMo demon.sprite
 * @Author:Demon
 * @Date:2021/12/29 23:38
 * @Description:
 */
public class PlayerThunderBird extends Skill
{
    private String name;

    PlayerThunderBird(Player player,float f,long tick,String name)
    {
        this.player = player;
        this.damageRectangleSprite = new DamageRectangleSprite();
        this.damageRectangleSprite.setDamage(f);
        this.damageRectangleSprite.setPlayer(true);
        this.damageRectangleSprite.setTick(tick);
        this.damageRectangleSprite.xSpeedMax = 100;
        this.name = name;

    }

    @Override
    public void action()
    {
        this.ySpeed = 0;
        if (player.direction == Direction.RIGHT)
        {
            this.damageRectangleSprite.setRectangle(new Rectangle(player.x + player.crashBoxWidth
                    , player.y+20,
                    150, 150));
            this.damageRectangleSprite.xSpeed= 10;
            this.Image = CommonUtils.getImage(name+"Right.gif");
        }
        else
        {
            this.damageRectangleSprite.setRectangle(new Rectangle(player.x - player.crashBoxWidth
                    , player.y+20,
                    160, 160));
            this.damageRectangleSprite.xSpeed = -10;
            this.Image = CommonUtils.getImage(name+"Left.gif");
        }
        damageRectangleSprite.x = damageRectangleSprite.getRectangle().x;
        damageRectangleSprite.y = damageRectangleSprite.getRectangle().y;
        damageRectangleSprite.width = damageRectangleSprite.getRectangle().width;
        damageRectangleSprite.height = damageRectangleSprite.getRectangle().height;
        this.setEffect(new Effect(damageRectangleSprite,25,this.Image,160,160));
        damageRectangleSprite.setTick(30);
        player.state.setSkillThunderBird(true);
        EffectBaseService service = GetService.getEffect();
        service.add(this.getEffect());
        Effect e = this.getEffect();
        new Timer().schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                service.remove(e);
                player.state.setSkillThunderBird(false);
                cancel();
            }
        }, 1500);
    }

}
