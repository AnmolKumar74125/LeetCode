class AllOne {

    int max,min;
    Map <String, Integer> hm;
    public AllOne() {
        this.max = Integer.MIN_VALUE;
        this.min = Integer.MAX_VALUE;
        hm = new HashMap<String, Integer>();
    }
    
    public void inc(String key) {
        this.hm.put(key, this.hm.getOrDefault(key , 0)+1);
        this.max = Math.max(hm.get(key) , this.max);
        if(hm.get(key)-1 == min || min == Integer.MAX_VALUE)
        {
            //this.min = 
            getNewMin();
        }
        this.min = Math.min(hm.get(key) , this.min);
        //System.out.println(this.hm);
    }
    
    public void dec(String key) {
        this.hm.put(key, this.hm.getOrDefault(key , 0)-1);
        this.min = Math.min(hm.get(key) , this.min);
        if(hm.get(key) == 0)
        {
            hm.remove(key);
            getNewMax();
            getNewMin();
           // System.out.println(this.hm);
            return ;
        }
        if(hm.containsKey(key) && (hm.get(key)+1 == max || max == Integer.MIN_VALUE))
        {
            //this.max = 
            getNewMax();
        }
        this.max = Math.max(hm.get(key) , this.max);
        //System.out.println(this.hm);
    }
    public void getNewMax()
    {
        this.max = Integer.MIN_VALUE;
        for(Map.Entry<String,Integer> entry : this.hm.entrySet())
        {
            this.max = Math.max(entry.getValue(), this.max);
        }
    }
    public void getNewMin()
    {
        this.min = Integer.MAX_VALUE;
        for(Map.Entry<String,Integer> entry : this.hm.entrySet())
        {
            this.min = Math.min(entry.getValue(), this.min);
        }
    }
    public String getMaxKey() {

        //System.out.println("max = "+this.max);
        for(Map.Entry<String,Integer> entry : this.hm.entrySet())
        {
            if(entry.getValue() == this.max)
            {
                return entry.getKey();
            }
        }
        return "";
    }
    
    public String getMinKey() {
        //System.out.println("min = "+this.min);
        for(Map.Entry<String,Integer> entry : this.hm.entrySet())
        {
            if(entry.getValue() == this.min)
            {
                return entry.getKey();
            }
        }
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */