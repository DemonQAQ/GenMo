package demon.base.BaseService;

import demon.sprite.Creature;
import demon.sprite.Player;

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
            if (creature.isDeath())this.remove(creature);
            if(creature.intersects(player))creature.crash(player);
        });
    }
}
