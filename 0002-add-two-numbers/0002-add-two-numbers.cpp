/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
           ListNode* temp1=l1,*temp2=l2,*l3=nullptr,*temp3=new ListNode(),*head=temp3;
        if(temp1==NULL)
        {
            return temp2;
        }
        if(temp2==NULL)
        {
            return temp1;
        }
        int c=0;
        while(temp1!=NULL && temp2!=NULL)
        {
            temp3->next=new ListNode();
            temp3=temp3->next;
            temp3->val=(temp1->val+temp2->val+c)%10;
            c=(temp1->val+temp2->val+c)/10;
            temp1=temp1->next;
            temp2=temp2->next;
        }
        while(temp1!=NULL)
        {
            temp3->next=new ListNode();
            temp3=temp3->next;
            temp3->val=(temp1->val+c)%10;
            c=(temp1->val+c)/10;
            
            temp1=temp1->next;
        }
        while(temp2!=NULL)
        {
            temp3->next=new ListNode();
            temp3=temp3->next;
            temp3->val=(temp2->val+c)%10;
            c=(temp2->val+c)/10;
            temp2=temp2->next;
        }
        if(c==1)
        {
            temp3->next=new ListNode();
            temp3=temp3->next;
            temp3->val=c;
        }
        return head->next;
    }
};