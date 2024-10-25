class Solution {
    public List<String> removeSubfolders(String[] folder) {

        Arrays.sort(folder);  
        Set<String> hs =  new HashSet<>();
        for(int i = 0; i < folder.length; i++)
        {
            int f = 0;
            String w = "";
            folder[i]+="/";
            for(int j = 0; j<folder[i].length()-1; j++)
            {
                //System.out.println(folder[i]);
                if(folder[i].charAt(j) == '/')
                {
                    //System.out.println(j+". "+folder[i].indexOf('/',j+1));
                    w = w + folder[i].substring(j,folder[i].indexOf('/',j+1));
                    if( hs.contains(w))
                    {
                        f = 1;
                        break;
                    }
                } 
            }
            if(f == 1)
            {
                continue;
            }
            hs.add(w);
        }
        //System.out.println(hs);
        return new ArrayList<>(hs);
    }
}