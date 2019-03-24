package serializable;


import org.junit.Test;



/**
 * @author He.H
 * @date 2019/3/22 11:02
 **/


public class testSerializable {
    @Test
    public  void testWrite(){
        Person person=new Person();
        person.setId(1);
        person.setName("张丹");
        SerializationUtils.write(person);
    }

    @Test
    public  void testRead(){
        Person p = (Person) SerializationUtils.read();
        System.out.println(p.getName());
    }
}