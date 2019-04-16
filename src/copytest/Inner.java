package copytest;

import java.io.Serializable;

/**
 * @author He.H
 * @date 2019/3/25 21:05
 **/


public class Inner implements Serializable {
    private static final long serialVersionUID = 872390113109L; //最好是显式声明ID
    public String name;

    public Inner(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Inner的name值为：" + name;
    }
}