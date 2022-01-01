package demon.base.BaseService;

import demon.sprite.DamageRectangleSprite;

/*
 * GenMo demon.base.BaseService
 * @Author:Demon
 * @Date:2021/12/28 14:10
 * @Description:
 */
public class DamageBaseService extends GBaseService<DamageRectangleSprite>
{
    public void action(CreatureBaseService service)
    {
        this.getElementList().forEach(sprite ->
        {
            sprite.action(service,sprite.getTick());
        });
    }
}
