package demon.base;

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
    public GameContent(Player player, Ground ground)
    {
        GetService.getGravity().add(player);
        GetService.getGround().add(player);
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

    }
    @Override
    public void drawImage(Graphics g)
    {

    }
}
