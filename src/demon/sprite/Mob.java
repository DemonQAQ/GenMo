package demon.sprite;

import demon.base.function.CreatureState;
import demon.base.function.Element;
import demon.base.function.MobAI;

/*
 * GenMo demon.base
 * @Author:Demon
 * @Date:2021/12/27 9:01
 * @Description:
 */
public class Mob extends Creature implements MobAI
{

    Mob(){}
    Mob(int x,int y)
    {
        super(x, y);
    }


    @Override
    public void autoXMove()
    {

    }

    @Override
    public void autoYMove()
    {

    }
}
