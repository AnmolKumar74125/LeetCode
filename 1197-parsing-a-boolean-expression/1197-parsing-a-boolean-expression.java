class Solution {
    public boolean parseBoolExpr(String expression) {

        Stack<Character> st2 = new Stack<>();
        Stack<List<Boolean>> st3 = new Stack<>();
        st3.push(new ArrayList<Boolean>());
        if(expression.length() == 1)
        {
            return expression.charAt(0) == 't'?true:false;
        }
        char ch[] = expression.toCharArray();
        boolean ans = false;
        for(int i = 0; i < ch.length; i++)
        {
            if(ch[i] == '&' || ch[i] == '|' || ch[i] == '!')
            {
                st2.push(ch[i]);
                st3.push(new ArrayList<Boolean>());
            }
            else if(ch[i] == ')')
            {
                char exp = st2.pop();
                List<Boolean> temp = st3.pop();
                if(exp == '&')
                {
                    boolean val = true;
                    for(int j = 0; j < temp.size(); j++)
                    {
                        val = val & temp.get(j);
                    }
                    if(st3.isEmpty())
                    {
                        List<Boolean> list = new ArrayList<Boolean>();
                        list.add(val);
                        st3.push(list);
                    }
                    else
                    {
                        st3.peek().add(val);
                    }
                }
                if(exp == '|')
                {
                    boolean val = false;
                    for(int j = 0; j < temp.size(); j++)
                    {
                        val = val | temp.get(j);
                    }
                    if(st3.isEmpty())
                    {
                        List<Boolean> list = new ArrayList<Boolean>();
                        list.add(val);
                        st3.push(list);
                    }
                    else
                    {
                        st3.peek().add(val);
                    }
                }
                if(exp == '!')
                {
                    boolean val = false;
                    for(int j = 0; j < temp.size(); j++)
                    {
                        val = !temp.get(j);
                    }
                    if(st3.isEmpty())
                    {
                        List<Boolean> list = new ArrayList<Boolean>();
                        list.add(val);
                        st3.push(list);
                    }
                    else
                    {
                        st3.peek().add(val);
                    }
                }
            }
            else if(ch[i] == 'f' || ch[i] == 't' || ch[i] == ',')
            {
                List<Boolean> temp = new ArrayList<>();
                temp = st3.peek();
                int j = i;
                while(j < ch.length && (ch[j] == 't' || ch[j] == 'f' || ch[j] == ','))
                {
                    
                    if(ch[j] == 't')
                    {
                        temp.add(true);
                    }
                    if(ch[j] == 'f')
                    {
                        temp.add(false);
                    }
                    i = j;
                    j++;
                }
            }
        }
        return st3.peek().get(0);   
    }
}