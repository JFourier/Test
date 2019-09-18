/**
 * @author He.H
 * @date 2019/9/4 13:21
 **/


public class Single extends Object{
    private volatile static Single instance = null;

    private Single(){
    }

    public static Single getInstance(){
        if(instance == null){
            synchronized(Single.class){
                if(instance == null){
                    instance = new Single();
                }
            }
        }
        return instance;

    }
}
