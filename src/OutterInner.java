/**
 * @author He.H
 * @date 2019/9/18 15:14
 **/


public class OutterInner {

    /*
    //outter get inner
    class Inner{
        private int number=5;
    }
    public int getNumber(){
        return new Inner().number;
    }
    public static void main(String[] args) {
        System.out.println(new OutterInner().getNumber());
    }*/


    //inner get outter
    private static String language = "en";
    private String region = "US";
    private String li;

    private void kk() {
        System.out.println("kk");
    }
    class InnerClass {
        public void printOuterClassPrivateFields() {
            String fields = "language=" + language +region;
            System.out.println(fields);
            kk();
        }
    }
    public static void main(String[] args) {
        OutterInner outer = new OutterInner();
        OutterInner.InnerClass inner = outer.new InnerClass();
        inner.printOuterClassPrivateFields();
    }
}
