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
    ListNode* oddEvenList(ListNode* head) {
        
        ListNode* oddHead = NULL,*oddTemp = NULL, *evenHead = NULL, *evenTemp = NULL;
        ListNode* temp = head;
        int x = 1;
        while(temp != NULL)
        {
            if(x % 2 != 0)
            {
                if(oddHead == NULL)
                {
                    oddHead = temp;
                    oddTemp = temp;
                }
                else
                {
                    oddTemp->next = temp;
                    oddTemp = oddTemp->next;
                }
            }
            else
            {
                if(evenHead == NULL)
                {
                    evenHead = temp;
                    evenTemp = temp;
                }
                else
                {
                    evenTemp->next = temp;
                    evenTemp = oddTemp->next;
                }
            }
            x++;
            temp = temp->next;
        }
        if(oddTemp)
        {
            oddTemp -> next = evenHead;
        }
        else
        {
            return evenTemp;
        }
        if(evenTemp)
        {
            evenTemp->next = NULL;
        }
        return oddHead;
    }
};