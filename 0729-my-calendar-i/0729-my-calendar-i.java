class MyCalendar {

    List<List<Integer>> list;
    public MyCalendar() {
        this.list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        
        int n = this.list.size();
        //System.out.println(n);
        for(int i = 0;i < n; i++)
        {
            //System.out.println( start +" "+end+".  "+this.list.get(i).get(0)+" "+this.list.get(i).get(1));
            if(((start >= this.list.get(i).get(0) && (start < this.list.get(i).get(1))) || ((end > this.list.get(i).get(0)) && end < this.list.get(i).get(1))) || ((start < this.list.get(i).get(0)) && end > this.list.get(i).get(0)))
            {
                return false;
            }
        }
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(start);
        temp.add(end);
        this.list.add(temp);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */