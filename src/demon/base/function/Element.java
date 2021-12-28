package demon.base.function;

import demon.util.Constant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * GenMo demon.base.function
 * @Author:Demon
 * @Date:2021/12/27 9:30
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Element
{
    String NOTHING = "NOTHING";

    String value() default NOTHING;//图片

    String Image() default NOTHING;//左边图片

    int width() default Constant.ELEMENT_SIZE;//宽度

    int height() default Constant.ELEMENT_SIZE;//高度

    int crashWidth() default Constant.ELEMENT_SIZE;

    int crashHeight() default Constant.ELEMENT_SIZE;

    float xAcceleration() default 1.0f;

    float yAcceleration() default 24.0f;

    Direction direction() default Direction.LEFT;//方向

    //以下属性只在敌机的子类读取
    int hp() default 50;//血量

    int defense() default 30;//防御力

    float xSpeed() default 3;//水平速度

    float ySpeed() default 0;//垂直速度

    int rewardScore() default 200;//奖励分数
}
