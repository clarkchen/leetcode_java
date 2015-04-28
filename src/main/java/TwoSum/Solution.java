package TwoSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenxi on 15/4/30.
 */
public class Solution {
    //暴力搜搜
    public int[] bruteFroce(int []nums, int target)
    {
        int i=0,j=0;
        for (i=0 ;i<nums.length;i++)
        {
            int temp = target - nums[i];
            for(j=0;j<nums.length;j++)
            {
                if(i==j) continue;
                if(nums[j]==temp)
                {
                    return new int[]{i+1, j+1} ;
                }
            }
        }
        return  new int[]{};
    }
    //排序+二分查找的方法
    public int[] sortType(int []nums, int target)
    {
        int [] reverse = new int[nums.length];
        int i=0, j=0;
        for (i =0 ;i< nums.length; i++)
        {
            reverse[i] = target -  nums[i];
        }

        Arrays.sort(reverse);
        int one=Integer.MIN_VALUE , theOther=Integer.MIN_VALUE;
        for (i=0;i<nums.length;i++)
        {
            int find = Arrays.binarySearch(reverse, nums[i]);
            if (find <0) continue;
            one = reverse[find];
            if (target%2==0 && one ==  target/2)
            {
               if(find+1 < nums.length && reverse[find+1]==one){}
               else if(find-1>=0 && reverse[find-1] ==one){}
               else continue;
            }
            theOther = target - one;
            break;
        }

        if( theOther==Integer.MIN_VALUE) return  new int[]{};

        for(i=0;i<nums.length;i++)
        {
            if(nums[i]==one) {one=i+1;break;}
        }
        nums[i] = Integer.MIN_VALUE;

        for(i=0;i<nums.length;i++)
        {
            if(nums[i]==theOther) {theOther=i+1;break;}
        }
        i = one>theOther? theOther:one;
        j = one>theOther? one: theOther;
        return  new int[]{i,j};

    }
    public int[] twoSum(int[] nums, int target) {

        return sortType(nums, target);
    }


}
