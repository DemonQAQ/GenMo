package demon.base.function;

/*
 * GenMo demon.base
 * @Author:Demon
 * @Date:2021/12/27 8:58
 * @Description:
 */
public interface Gravity
{
    boolean onTheGround();
    float getQuality();
    float getYSPeed();
    void setYSPeed(float f);
    int getY();
    void setY(int y);
}
