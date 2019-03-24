package serializable;

/**
 * @author He.H
 * @date 2019/3/22 11:00
 **/


import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private String name;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}