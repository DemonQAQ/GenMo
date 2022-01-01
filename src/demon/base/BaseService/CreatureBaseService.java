package demon.base.BaseService;

import demon.base.function.MobAI;
import demon.sprite.Creature;
import demon.sprite.Player;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * GenMo demon.base.BaseService
 * @Author:Demon
 * @Date:2021/12/28 11:31
 * @Description:
 */
public class CreatureBaseService extends GBaseService<Creature>
{
    public void action(Player player)
    {
        this.getElementList().forEach(creature ->
        {
            creature.action();
            if (creature.intersects(player) && !creature.isDeath() && creature instanceof MobAI)
            {
                creature.crash(player);
                player.beHurt(5);
                if (!player.state.isHurt())
                {
                    player.state.setHurt(true);
                    player.state.setUnbeatable(true);
                    new Timer().schedule(new TimerTask()
                    {
                        @Override
                        public void run()
                        {
                            player.state.setHurt(false);
                            cancel();
                        }
                    }, 500);
                    new Timer().schedule(new TimerTask()
                    {
                        @Override
                        public void run()
                        {
                            player.state.setUnbeatable(false);
                            cancel();
                        }
                    }, 750);
                }
            }
        });
    }

    @Override
    public void drawImage(Graphics g)
    {
        this.getElementList().forEach(creature ->
        {
            creature.drawImage(g);
        });
    }
}
