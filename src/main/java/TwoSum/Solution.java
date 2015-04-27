package TwoSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenxi on 15/4/30.
 */
public class Solution {
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
    public int[] sort(int []nums, int target)
    {
        int [] reverse = new int[nums.length];
        int i=0, j=0;
        for (i =0 ;i< nums.length; i++)
        {
            reverse[i] = target -  nums[i];
        }

        Arrays.sort(reverse);
        for (i=0;i<nums.length;i++)
        {
            
        }

        return  new int[]{};

    }
    public int[] twoSum(int[] nums, int target) {
       return bruteFroce(nums, target);
    }


}
