package demon.util;

import demon.base.BaseService.*;
import demon.base.function.BaseService;
import demon.sprite.DamageRectangleSprite;

/*
 * GenMo demon.util
 * @Author:Demon
 * @Date:2021/12/27 14:50
 * @Description:
 */
public enum GetService
{
    GRAVITY(new GravityBaseService()),//重力
    GROUND(new GroundBaseService()),
    CREATURE(new CreatureBaseService()),
    DAMAGE(new DamageBaseService()),
    PLAYER(new PlayerBaseService()),
    EFFECT(new EffectBaseService());

    private GetService(BaseService service)
    {
        this.service = service;
    }

    private BaseService service;


    public BaseService getService()
    {
        return service;
    }

    public static void init()
    {
        Constant.TIMER_STOP_FLAG = false;//初始化timer 开关
        for (GetService bean : GetService.values())
        {
            bean.getService().init();
        }
    }

    public static GroundBaseService getGround()
    {
        return (GroundBaseService) GetService.GROUND.getService();
    }

    public static GravityBaseService getGravity()
    {
        return (GravityBaseService) GetService.GRAVITY.getService();
    }


    public static CreatureBaseService getCreature()
    {
        return (CreatureBaseService) GetService.CREATURE.getService();
    }

    public static DamageBaseService getDamage()
    {
        return (DamageBaseService) GetService.DAMAGE.getService();
    }

    public static PlayerBaseService getPlayer()
    {
        return (PlayerBaseService) GetService.PLAYER.getService();
    }

    public static EffectBaseService getEffect()
    {
        return (EffectBaseService) GetService.EFFECT.getService();
    }
}
