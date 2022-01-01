package demon.util;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/*
 * GenMo demon.util
 * @Author:Demon
 * @Date:2021/12/26 17:55
 * @Description:
 */
public abstract class CommonUtils
{
    private static final Random RANDOM = new Random();
    //传入随机数区间
    public static int nextInt(int start, int end)
    {
        return start == end ?start:start+RANDOM.nextInt(end-start);
    }

    public static Image getImage(String name)
    {
        return new ImageIcon(Constant.RESOURCES_PATH+name).getImage();
    }
    public static void task(long period, GTimer t)
    {
        Timer timer = new Timer();
        //直到TIME_STOP_FLAG为true终止任务
        TimerTask timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                if (Constant.TIMER_STOP_FLAG)
                {
                    timer.cancel();
                }
                t.run();
            }
        };
        //加入任务列表
        timer.schedule(timerTask,0,period);
    }
}
