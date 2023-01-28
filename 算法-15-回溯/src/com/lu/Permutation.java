package com.lu;

import java.util.*;

/**
 * @author 小卢
 * @version 1.0
 * @date 2023/1/26 23:38
 **/
public class Permutation {


    public static void main(String[] args) {
       new Permutation().permutation(new int[]{1, 2, 3});
    }

    Set<Integer> selected = new HashSet<>();

    /**
     * 输入一组不重复的数字,返回他们的全排列
     */
    void permutation(int[] nums) {

        // 路径
        List<Integer> track = new LinkedList<>();
        backtrack(track, nums);

    }

    private void backtrack(List<Integer> track, int[] nums) {
        int length = nums.length;

        if (track.size() == length) {
            track.forEach(System.out::print);
            System.out.println("找到一种排列");
        }

        for (int i = 0; i < length; i++) {
            // 作出选择
            int num = nums[i];
            // 将该选择从选择列表中移除
            if (selected.contains(num)) {
                continue;
            }
            // 路径.add(选择)
            selected.add(num);
            track.add(num);
            backtrack(track, nums);
            // 撤销选择
            selected.remove(num);
            // 将该选择恢复到选择列表
            track.remove((Integer) num);

        }
    }
}
