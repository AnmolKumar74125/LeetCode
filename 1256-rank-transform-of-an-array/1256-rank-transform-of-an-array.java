class Solution {
    public int[] arrayRankTransform(int[] arr) {

        Map<Integer, Integer> hm = new HashMap<Integer,Integer>();     
        int sortedArr[] = Arrays.stream(arr).distinct().sorted().toArray();
        for(int i = 0; i < sortedArr.length; i++)
        {
            hm.put(sortedArr[i], i + 1);
        }
        for(int i = 0; i <  arr.length; i++)
        {
            arr[i] = hm.get(arr[i]);
        }
        return arr;
    }
}