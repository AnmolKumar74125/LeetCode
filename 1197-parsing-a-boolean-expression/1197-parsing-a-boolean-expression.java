class Solution {
    public boolean parseBoolExpr(String expression) {

        Stack<Character> st1 = new Stack<>();
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
            else if(ch[i] == '(')
            {
                st1.push(ch[i]);
            }
            else if(ch[i] == ')')
            {
                char exp = st2.pop();
                System.out.println("exp = "+exp);
                List<Boolean> temp = st3.pop();
                if(exp == '&')
                {
                    System.out.println("&");
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
                    System.out.println("|");
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
                    System.out.println("!");
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
                    System.out.println("i: "+i+" increamented j: "+(j+1)+" len: "+ch.length+"  ch[i]: "+ch[i]);
                    j++;
                }
                //st3.push(temp);
            }
            System.out.println("st3 = "+st3);
        }
        System.out.println("st1 = "+st1);
        System.out.println("st2 = "+st2);
        System.out.println("st3 = "+st3);
        /*
        while(!st3.isEmpty())
        {
            System.out.println("st3 = "+st3.pop());
        }
        */
        return st3.peek().get(0);   
    }
}