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


    

    //加一(判断数字9和其它思路)  通过
    @Test
    void plusOne1_2() {
        int digits[] = new int[]{9, 9, 9};
//        int digits[] = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//        int digits[] = new int[]{9};
        int length = digits.length;
        //判断是否
        Boolean flag = true;
        int count = 0;
        for (int i = 1; i <= length; i++) {
            int digit = digits[length - i];
            if (flag) {
                if (digit != 9) {
                    count = length - i;
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            int[] aArray = new int[digits.length + 1];
            aArray[0] = digits[0] + 1;
            for (int i = 1; i < aArray.length; i++) {
                aArray[i] = 0;
            }
            System.out.println(aArray.toString());
        } else {
            int[] aArray = new int[digits.length];
            for (int i = 0; i < aArray.length; i++) {
                if (i == count) {
                    aArray[i] = digits[i] + 1;
                } else if (i > count) {
                    aArray[i] = 0;
                } else {
                    aArray[i] = digits[i];
                }
            }
            System.out.println(aArray.toString());
        }
    }

    //加一(转字符串思路,不可行 因为int大小限制)
    @Test
    void plusOne1() {
//        int digits[] = new int[]{9,9,9};
        int digits[] = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int length = digits.length;
        Integer sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Integer.parseInt(digits[i] * Math.pow(10, length - i - 1) + "");
        }
        sum += 1;
        String ssum = sum + "";
        int[] aArray = new int[ssum.length()];
        for (int i = 0; i < ssum.length(); i++) {
            aArray[i] = Integer.parseInt(ssum.charAt(i) + "");
        }
        System.out.println(aArray.toString());
    }


    // 存在重复元素
    @Test
    void containsDuplicate() {
        int nums[] = new int[]{1, 2, 3, 1};

    }


    //旋转数组(未完成)
    @Test
    void rotate() {
        int nums[] = new int[]{1, 2, 3, 4, 5, 6};
        int k = 4;
//        int nums[] = new int[]{1,2};
//        int k = 3;
        int m = 0;  //记录索引
        int n = nums[m];  //记录值
        int n2 = 0;
        boolean flag = true;
        if (k != 0) {
            if (nums.length % k == 0 || k % 2 == 0) {
                for (int q = 0; q < k; q++) {
                    while (flag) {
                        m = (m + k) % nums.length;
                        n2 = nums[m];
                        nums[m] = n;
                        n = n2;
                        if (m < k) flag = false;
                    }
                    m++;
                    n = nums[m % nums.length];
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


    //买卖股票的最佳时机 II   通过
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
