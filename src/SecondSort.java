import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author He.H
 * @date 2019/7/14 20:27
 **/


public class SecondSort {
    public static void main(String[] args) {
        List<DoubleSort> list = new ArrayList<>();
        list.add(new DoubleSort(0,"z"));
        list.add(new DoubleSort(0,"f"));
        list.add(new DoubleSort(0,"q"));
        list.add(new DoubleSort(0,"c"));
        list.add(new DoubleSort(0,"a"));
        list.add(new DoubleSort(33,"a"));
        list.add(new DoubleSort(33,"b"));
        list.add(new DoubleSort(1,"e"));
        list.add(new DoubleSort(1,"a"));
        list.add(new DoubleSort(1,"v"));

        //一次排序
        //list.sort(Comparator.comparing(DoubleSort::getId));

        //二次
        list.sort(Comparator.comparing(DoubleSort::getId).thenComparing(DoubleSort::getId));

        //处理null
        //list.add(new DoubleSort(2,null));
        //list.sort(Comparator.comparing(DoubleSort::getName, Comparator.nullsFirst((Comparator.naturalOrder()))));

        //输出
        list.forEach(e -> System.out.println(e.getId()+" - "+e.getName()));
    }

}

class DoubleSort {
    private int id;
    private String name;

    public DoubleSort(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}