class Linked_List
{
    int val;
    Linked_List prev;
    Linked_List next;
    Linked_List(int val)
    {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
    Linked_List(int val, Linked_List next)
    {
        this.val = val;
        this.next = next;
        this.prev = null;
    }
    Linked_List(int val, Linked_List prev, Linked_List next)
    {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyCircularDeque {

    Linked_List head, tail;
    int size , count;
    public MyCircularDeque(int k) {

        this.head = null;
        this.tail = null;
        this.size = k;
        this.count = 0;
    }
    
    public boolean insertFront(int value) {

        if(this.count < size)
        {
            if( this.count == 0)
            {
                this.head = new Linked_List(value, null, null);
                this.tail = this.head;
                this.count++;
                return true;
            }
            this.head.prev = new Linked_List(value, null, this.head);
            this.head = this.head.prev;
            this.count++;
            return true;
        }
        return false;
    }
    
    public boolean insertLast(int value) {

        if(this.count < size)
        {
            if( this.count == 0)
            {
                this.tail = new Linked_List(value, null, null);
                this.head = this.tail;
                this.count++;
                return true;
            }
            this.tail.next = new Linked_List(value, this.tail, null);
            this.tail = this.tail.next;
            this.count++;
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        
        if(count == 1)
        {
            this.tail = null;
            this.head = null;
            count--;
            return true;
        }
        if(count > 1)
        {
            this.head = this.head.next;
            this.head.prev = null;
            count--;
            return true;
        }
        return false;
    }
    
    public boolean deleteLast() {
        
        if(count == 1)
        {
            this.tail = null;
            this.head = null;
            count--;
            return true;
        }
        if(count > 1)
        {
            this.tail = this.tail.prev;
            this.tail.next = null;
            count--;
            return true;
        }
        return false;
    }
    
    public int getFront() {
        
        if(count > 0)
        {
            return this.head.val;
        }
        return -1;
    }
    
    public int getRear() {
        
        if( count > 0)
        {
            return this.tail.val;
        }
        return -1;
    }
    
    public boolean isEmpty() {
        
        if(count == 0)
        {
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        
        if(count == size)
        {
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */