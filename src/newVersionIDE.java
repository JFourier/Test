
public class newVersionIDE {
    public static void main(String[] args) {
//        int a = 1, b = 1, c = 1;
//        int d = 1, e = 1, f = 1;
//        System.out.println((a++ == 2) && (b++ == 3) || (c++ == 2));
//        System.out.println((d++ == 1) || (e++ == 1) && (f++ == 3));
//        System.out.printf("%d%d%d%d%d%d%n", a, b, c, d, e, f);
        boolean[] used = {false, false, false, false};
        int[] nums = {1, 1, 22};
        System.out.println(used[0] || 0 > 0 && !used[0 - 1] && nums[0] == nums[0 - 1]);
    }
}
