package demon.base.function;

/*
 * GenMo demon.base.function
 * @Author:Demon
 * @Date:2021/12/27 9:03
 * @Description:
 */
public enum Direction
{
    LEFT{
        @Override
        public boolean left(){return true;}
    },
    RIGHT{
        @Override
        public boolean right(){return true;}
    },
    UP{},
    DOWN{};

    public boolean left(){return false;}
    public boolean right(){return false;}
}
