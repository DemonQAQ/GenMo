package demon.base.BaseService;

import demon.sprite.Player;

/*
 * GenMo demon.base.BaseService
 * @Author:Demon
 * @Date:2021/12/29 0:17
 * @Description:
 */
public class PlayerBaseService extends GBaseService<Player>
{
    public int getPlayerLocation()
    {
        Player player = null;
        player = this.getElementList().get(0);
        if (player!=null)return player.getX();
        else return 0;
    }
}
