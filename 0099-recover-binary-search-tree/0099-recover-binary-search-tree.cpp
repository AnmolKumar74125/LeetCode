/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void recoverTree(TreeNode* root) {
      
        vector<int> arr;
        TreeNode* height = new TreeNode();
        getValues(root,arr);
        //dispVec(arr);
        sort(arr.begin(),arr.end());
        //dispVec(arr);
        int x = 0;
        rearrangeTree(root, arr,  x);
    }
    void rearrangeTree(TreeNode* root, vector<int>& arr, int& x)
    {
        if(root == NULL)
        {
            return;
        }
        
        rearrangeTree(root->left, arr, x);
       // cout<<"root->val = "<<root->val <<"  arr[x + height->val] ="<<arr[x + height->val]<<endl;
        root->val = arr[x];
        x = x + 1;
        rearrangeTree(root->right, arr, x);
        
    }
    void getValues(TreeNode* root, vector<int>& arr)
    {
        if(root == NULL)
        {
            return;
        }
        arr.push_back(root->val);

        getValues(root->left, arr);
        getValues(root->right, arr);
    }
    void dispVec(vector<int>& vec)
    {
        for(int i = 0; i< vec.size(); i++)
        {
            cout<<vec[i]<<" ";
        }
        cout<<endl;
    }
};

//[3,1,11,4,null,null,5,14,13,42,14,12]
//[1,3,null,null,4,13,12,null,null,null,15,17,8,9,23,22,53,62]