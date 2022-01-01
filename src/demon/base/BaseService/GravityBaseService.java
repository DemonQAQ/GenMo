package demon.base.BaseService;

import demon.base.function.Gravity;

/*
 * GenMo demon.base
 * @Author:Demon
 * @Date:2021/12/27 14:35
 * @Description:
 */
public class GravityBaseService extends GBaseService<Gravity>
{
    private final static float g = 0.15f;

    public GravityBaseService(){}

    public void universalGravitation()
    {
        this.getElementList().forEach(gravity ->
        {
            if (!gravity.onTheGround())
            {
                float G = g * gravity.getQuality();
                gravity.setY((int) (gravity.getY() + G - gravity.getYSPeed()));
            }
        });
    }
}
