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
    public TreeNode replaceValueInTree(TreeNode root) {
        
        Queue<TreeNode> que = new LinkedList();
        List<TreeNode> list = new ArrayList<>();
        List<Integer> sumArr = new ArrayList<>();
        que.add(root);
        int sum = 0;
        while(!que.isEmpty())
        {
            TreeNode front = que.poll();
            if(front.left != null)
            {
                list.add(front.left);
            }
            if(front.right != null)
            {
                list.add(front.right);
            }
            sum = sum + front.val;
            if(que.isEmpty())
            {
                que.addAll(list);
                list = new ArrayList<>();
                sumArr.add(sum);
                sum = 0;
            }
        }
        int i = 1;
        System.out.println(sumArr);
        que.add(root);
        root.val = 0;
        while(!que.isEmpty() && i < sumArr.size())
        {
            TreeNode front = que.poll();
            int value = sumArr.get(i);
            if(front.left != null)
            {
                list.add(front.left);
                value = value - front.left.val;
            }
            if(front.right != null)
            {
                list.add(front.right);
                value = value - front.right.val;
                front.right.val = value;
            }
            if(front.left != null)
            {
                front.left.val = value;
            }
            
            if(que.isEmpty())
            {
                que.addAll(list);
                list = new ArrayList<>();     
                i++;      
            }
        }
        return root;
    }
}