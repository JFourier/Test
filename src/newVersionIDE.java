import org.junit.Test;

import java.io.Serializable;
import java.util.HashMap;

public class newVersionIDE implements Serializable {

    public static void main(String[] args) {
        HashMap<String,Integer> tmp = new HashMap<>();
        System.out.println(tmp.size());
    }


    @Test
    public void prin(){
        int a = 1<<30;
        System.out.println(a);
    }

}
