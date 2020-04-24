package com.yc.brushquestions.brushquestions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @Author liuxin@worken.cn
 * @Date 2020-04-23 20:14:37
 **/

@SpringBootTest
class Easy_Array_Tests {

    //删除排序数组中的重复项
    @Test
    void removeDuplicates() {
//        int nums[] = new int[]{1,1,2};
        int nums[] = new int[]{0,0,1,1,1,2,2,3,3,4};
        Arrays.sort(nums);
        int m = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[m]!=nums[i]) {
                m++;
                nums[m] = nums[i];
                i--;
            }
        }
        System.out.println(++m);
    }

}
