class CustomStack {

    Stack<Integer> st;
    int max,top;
    int arr[];
    public CustomStack(int maxSize) {
        this.max = maxSize;
        this.top = 0;
        this.st = new Stack<Integer>();
        this.arr = new int[maxSize];
    }
    
    public void push(int x) {
        if(this.st.size() < this.max)
        {
            st.push(x);
            top++;
        }
    }
    
    public int pop() {
        if(st.isEmpty())
        {
            return -1;
        }
        int x = st.pop() + arr[top-1];
        arr[top-1] = 0;
        top--;
        return x;
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(k,top); i++)
        {
            this.arr[i] = this.arr[i] + val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */