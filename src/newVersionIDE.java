
public class newVersionIDE {
    public static void main(String[] args) {
//        int a = 1, b = 1, c = 1;
//        int d = 1, e = 1, f = 1;
//        System.out.println((a++ == 2) && (b++ == 3) || (c++ == 2));
//        System.out.println((d++ == 1) || (e++ == 1) && (f++ == 3));
//        System.out.printf("%d%d%d%d%d%d%n", a, b, c, d, e, f);

//        int[] nums = new int[]{};
//        nums[0] = 1;
//        System.out.println(nums.length);
        System.out.println("第over");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == 3)
                    return;
                System.out.println("第"+i+""+"in"+j);
            }
            System.out.println("第"+i+"");
        }
        System.out.println("第over");
    }
}
