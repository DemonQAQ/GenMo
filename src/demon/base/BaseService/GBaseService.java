package demon.base.BaseService;

import demon.base.function.BaseService;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * GenMo demon.base
 * @Author:Demon
 * @Date:2021/12/27 14:26
 * @Description:
 */
public abstract class GBaseService<T> implements BaseService<T>
{
    private CopyOnWriteArrayList<T> elementList = new CopyOnWriteArrayList<>();

    @Override
    public void init()
    {
        elementList.clear();
    }

    @Override
    public void add(T element)
    {
        this.elementList.add(element);
    }

    @Override
    public void remove(T element)
    {
        this.elementList.remove(element);
    }

    @Override
    public CopyOnWriteArrayList<T> getElementList()
    {
        return elementList;
    }

    @Override
    public void drawImage(Graphics g)
    {

    }
}
