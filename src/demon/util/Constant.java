package demon.util;

import demon.sprite.Player;

/*
 * GenMo demon.util
 * @Author:Demon
 * @Date:2021/12/26 22:34
 * @Description:
 */
public abstract class Constant
{
    //TIME_STOP_FLAG为true终止任务
    public static boolean TIMER_STOP_FLAG = false;
    public final static String RESOURCES_PATH = "src/demon/resources/image/";
    public final static int FRAME_WIDTH = 1620;
    public final static int FRAME_HEIGHT = 631 + 20;
    public final static int GROUND_LEVEL = FRAME_HEIGHT - 129 - 30;
    public final static int ELEMENT_SIZE = 16;
    public final static int LEFT_EDGE = -50;
    public final static int RIGHT_EDGE = 1480;
}
