package demon.base.function;

import demon.util.GDraw;

import java.util.concurrent.CopyOnWriteArrayList;

/*
 * GenMo demon.util
 * @Author:Demon
 * @Date:2021/12/27 14:13
 * @Description:
 */
public interface BaseService<T> extends GDraw
{
    void init();
    void add(T element);
    void remove(T element);
    CopyOnWriteArrayList<T> getElementList();
}
