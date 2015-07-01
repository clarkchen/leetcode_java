package SummaryRanges;
import java.util.*;
/**
 * Created by chenxi on 15/6/30.
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> rtList = new ArrayList<String>();
        if (nums.length==0)
            return rtList;

        for(int i =0;i<nums.length;i++)
        {
            if (i== nums.length-1)
            {
                rtList.add(String.valueOf(nums[i]));
                break;
            }
            int next = nums[i+1];
            int cur = nums[i];
            int start = cur;
            while(next==cur+1 && i<nums.length-1)
            {

                i++;
                cur = nums[i];
                if(i==nums.length-1)
                    break;
                next = nums[i+1];

            }
            if (start == cur)
            {
                rtList.add(String.valueOf(nums[i]));
            }
            else
            {
                rtList.add(String.format("%s->%s", start, cur));
            }
        }
        return rtList;
    }
}
