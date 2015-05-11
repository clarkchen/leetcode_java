package SymmetricTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenxi on 15/5/11.
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if( root ==null ) return true;
        if (root.left==null && root.right==null) return true;
        Queue<TreeNode> queue_left = new LinkedList<TreeNode>();
        Queue<TreeNode> queue_right = new LinkedList<TreeNode>();
        if(root.left!=null && root.right!=null){
            queue_left.offer(root.left);
            queue_right.offer(root.right);
        }
        else
        {
            return false;
        }

        while(queue_left.size()>0 && queue_right.size()>0)
        {
           TreeNode cur_left = queue_left.poll();
           TreeNode cur_right = queue_right.poll();
           if (cur_left.val != cur_right.val) return false;

           if (cur_left.left==null && cur_right.right==null){}
           else if  (cur_left.left!=null && cur_right.right!=null)
           {
               queue_left.offer(cur_left.left);
               queue_right.offer(cur_right.right);
            }
           else return false;

          if (cur_left.right==null && cur_right.left==null){}
          else if (cur_left.right!=null && cur_right.left!=null)
          {
              queue_left.offer(cur_left.right);
              queue_right.offer(cur_right.left);
          }
          else{
              return false;
          }
        }
        if(queue_left.size()+queue_right.size()>0) return false;

        return true;
    }

}
