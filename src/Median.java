/**
 * @author He.H
 * @date 2019/3/5 15:04
 **/


import java.util.TreeSet;

public class Median {

    TreeSet<Integer> max = new TreeSet<Integer>();  //大顶堆，用于存放前面一半的元素
    TreeSet<Integer> min = new TreeSet<Integer>();  //小顶堆，用于存放后面一般的元素

    /**
     * 用两个推保存数据，保持两个堆的数据保持平衡（元素个数相差不超过1）
     * 大顶堆存放的数据要比小顶堆的数据小
     * 当两个推中元素为偶数个，将新加入元素加入到大顶堆，如果要加入的数据，比小顶堆的最小元素大，
     * 先将该元素插入小顶堆，然后将小顶堆的最小元素插入到大顶堆。
     * 当两个推中元素为奇数个，将新加入元素加入到小顶堆，如果要加入的数据，比大顶堆的最大元素小，
     * 先将该元素插入大顶堆，然后将大顶堆的最大元素插入到小顶堆。
     * @param num
     */
    public void Insert(Integer num) {
        if (((max.size()+min.size()) & 1) == 0) { //偶数个
            if (min.size() > 0 && num > min.first()) {
                min.add(num);
                num = min.first();
                min.remove(num);
            }
            max.add(num);
        }else {
            if (max.size() > 0 && num < max.last()) {
                max.add(num);
                num = max.last();
                max.remove(num);
            }
            min.add(num);
        }
    }

    /**
     * 当元素个数是奇数个时，大顶堆元素比小顶堆多一个，中位数即为大顶堆的堆顶元素
     * 若为偶数，则中位数是大小顶堆的堆顶元素之和除2
     * @return
     */
    public Double GetMedian() {
        int size = max.size() + min.size();
        if (size == 0) {
            return 0.0;
        }
        if ((size & 1) == 0) {
            return (max.last() + min.first()) / 2.0;
        }else {
            return (double)max.last();
        }
    }
}
