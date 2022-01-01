package demon.util;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

/*
 * GenMo demon.util
 * @Author:Demon
 * @Date:2021/12/26 23:12
 * @Description:
 */
public enum Keys
{
    LEFT(KeyEvent.VK_A),
    RIGHT(KeyEvent.VK_D),
    JUMP(KeyEvent.VK_K),
    ATTACK(KeyEvent.VK_J),
    SKILL1(KeyEvent.VK_L);

    private final static Set<Integer> keySet = new HashSet<>();
    private int keyValue;

    Keys(int keyValue)
    {
        this.keyValue = keyValue;
    }
    public boolean use()
    {
        return keySet.contains(keyValue);
    }
    public static void add(int keyCode)
    {
        keySet.add(keyCode);
    }
    public static void remove(int keyCode)
    {
        keySet.remove(keyCode);
    }
}
