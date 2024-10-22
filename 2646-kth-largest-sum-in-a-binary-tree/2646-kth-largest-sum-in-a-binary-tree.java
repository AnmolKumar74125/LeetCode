/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        List<Long> ans = new ArrayList<Long>(); 
        long sum = 0;
        Queue<TreeNode> que = new LinkedList();
        List<TreeNode> list = new ArrayList<>();
        que.add(root);
        while(!que.isEmpty())
        {
            TreeNode front = que.poll();
            sum = sum + front.val;
            if(front.left != null)
            {
                list.add(front.left);
            }
            if(front.right != null)
            {
                list.add(front.right);
            }
            if(que.isEmpty())
            {
                que = new LinkedList();
                que.addAll(list);
                list = new ArrayList<>();
                ans.add(sum);
                sum = 0;
            }
        }
        Collections.sort(ans, Collections.reverseOrder());
        if(ans.size() < k)
        {
            return -1;
        }
        return ans.get(k-1);
    }
}