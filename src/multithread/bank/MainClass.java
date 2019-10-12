package multithread.bank;

/**
 * @author He.H
 * @date 2019/10/10 15:07
 **/


/**
 * 两个人AB通过一个账户A在柜台取钱和B在ATM机取钱
 * */
public class MainClass {
    public static void main(String[] args) {
        Bank bank = new Bank();
        // 实例化两个人，传入同一个银行的对象
        PersonA a = new PersonA(bank, "Counter");
        PersonB b = new PersonB(bank, "ATM");
        a.start();
        b.start();
    }
}
