package demon.base;

import demon.base.BaseService.CreatureBaseService;
import demon.base.BaseService.DamageBaseService;
import demon.sprite.General;
import demon.sprite.Ground;
import demon.sprite.Player;
import demon.util.CommonUtils;
import demon.util.GDraw;
import demon.util.GetService;

import java.awt.*;

/*
 * GenMo demon.base
 * @Author:Demon
 * @Date:2021/12/27 11:07
 * @Description:
 */
public class GameContent implements GDraw
{
    private General test = new General(500,0);

    public GameContent(Player player, Ground ground)
    {
        GetService.getGravity().add(player);
        GetService.getGravity().add(test);
        GetService.getGround().setGround(ground);
        GetService.getGround().add(player);
        GetService.getGround().add(test);
        GetService.getCreature().add(test);
        player.setGroundFLag(false);
        CommonUtils.task(25, () -> {
            player.action();//玩家动作
            this.wholeAction(player);//游戏整体动作
            GetService.getGravity().universalGravitation();//万有引力
        });
        CommonUtils.task(1, () -> GetService.getGround().groundJudge(ground));
    }

    private void wholeAction(Player player)
    {
        CreatureBaseService creature = GetService.getCreature();
        DamageBaseService damage = GetService.getDamage();
        damage.action(creature);
        creature.action(player);
    }
    @Override
    public void drawImage(Graphics g)
    {
        GetService.getGround().drawImage(g);
        test.drawImage(g);
    }
}
