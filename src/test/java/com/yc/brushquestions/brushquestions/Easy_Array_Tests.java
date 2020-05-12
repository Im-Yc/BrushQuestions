package com.yc.brushquestions.brushquestions;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.yc.brushquestions.brushquestions.model.DataBackForm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @Author liuxin@worken.cn
 * @Date 2020-04-23 20:14:37
 **/

@SpringBootTest
class Easy_Array_Tests {

    //旋转数组
    @Test
    void rotate() {
        int nums[] = new int[]{1,2,3,4,5,6};
        int k = 4;
//        int nums[] = new int[]{1,2};
//        int k = 3;
        int m = 0;  //记录索引
        int n = nums[m];  //记录值
        int n2 = 0;
        boolean flag = true;
        if(k!=0){
            if (nums.length % k == 0||k%2==0) {
                for (int q = 0; q < k; q++) {
                    while (flag) {
                        m = (m  + k) % nums.length;
                        n2 = nums[m];
                        nums[m] = n;
                        n = n2;
                        if (m < k) flag = false;
                    }
                    m++;
                    n = nums[m%nums.length];
                    flag = true;
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    m = (m + k) % nums.length;
                    n2 = nums[m];
                    nums[m] = n;
                    n = n2;
                }
            }
        }

        System.out.println(nums.toString());
    }

    //删除排序数组中的重复项
    @Test
    void removeDuplicates() {
//        int nums[] = new int[]{1,1,2};
        int nums[] = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Arrays.sort(nums);
        int m = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[m] != nums[i]) {
                m++;
                nums[m] = nums[i];
                i--;
            }
        }
        System.out.println(++m);
    }


    //买卖股票的最佳时机 II
    @Test
    void maxProfit() {
//        int nums[] = new int[]{1,2,3,4,5};
        int nums[] = new int[]{7, 1, 5, 3, 6, 4};
        boolean mf = false;
        int m = 0;
        //出售的天
        int lr = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //判断可以获得利润的第一天
            if (nums[i] < nums[i + 1] && !mf) {
                m = nums[i];
                mf = true;
            }
            if (mf) {
                //明天的价格比今天的便宜
                if (nums[i] > nums[i + 1]) {
                    mf = false;
                    lr = lr + (nums[i] - m);
                } else if (i == nums.length - 2) {
                    lr = lr + (nums[i + 1] - m);
                }
            }
        }
        System.out.println(lr);
    }


}
