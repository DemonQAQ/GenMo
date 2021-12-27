package demon.util;

import demon.base.BaseService.GravityBaseService;
import demon.base.BaseService.GroundBaseService;
import demon.base.function.BaseService;

/*
 * GenMo demon.util
 * @Author:Demon
 * @Date:2021/12/27 14:50
 * @Description:
 */
public enum GetService
{
    Gravity(new GravityBaseService()),//重力
    GROUND(new GroundBaseService());

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
        return (GravityBaseService) GetService.Gravity.getService();
    }
}
