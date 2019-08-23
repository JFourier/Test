package MyFunction;

/**
 * @author He.H
 * @date 2019/8/19 13:34
 **/


public class SingleInstance {
    private volatile static SingleInstance instance = null;

    private SingleInstance() { }

    public static SingleInstance getInstance() {
        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (SingleInstance.class) {
                //第二重判断
                if (instance == null) {
                    instance = new SingleInstance(); //创建单例实例
                }
            }
        }
        return instance;
    }
}
