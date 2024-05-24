package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(args[0]));

        List<Integer> nums = new ArrayList<>();
        while (scanner.hasNextInt()) {
            nums.add(scanner.nextInt());
        }

        Collections.sort(nums);
        System.out.println(sumDelta(nums, nums.get(nums.size() / 2)));
    }


    public static int sumDelta(List<Integer> nums, int num) {
        int sum = 0;
        for (int curNum : nums) {
            if (curNum > num) {
                sum += curNum - num;
            } else {
                sum += num - curNum;
            }
        }
        return sum;
    }
}