package demon.base.BaseService;

import demon.sprite.DamageRectangleSprite;
import demon.sprite.Effect;
import demon.util.CommonUtils;

import java.awt.*;

/*
 * GenMo demon.base.BaseService
 * @Author:Demon
 * @Date:2021/12/30 0:20
 * @Description:
 */
public class EffectBaseService extends GBaseService<Effect>
{
    @Override
    public void action()
    {
        this.getElementList().forEach(Effect::action);
    }

    @Override
    public void drawImage(Graphics g)
    {
        this.getElementList().forEach(effect ->
        {
            effect.drawImage(g);
//            DamageRectangleSprite d = effect.getDamageRectangleSprite();
//            d.setImage(CommonUtils.getImage("test.png"));
//            d.drawImage(g);
        });
    }
}
