class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        
        while(i < a.length && j < b.length){
            if(a[i] == b[j]){
                res.add(a[i]);
                i++;
                j++;
            } else if(a[i] > b[j]){
                j++;
            } else {
                i++;
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : res){
            if(!set.contains(num)){
                set.add(num);
                list.add(num);
            }
        }
        return res;
    }
}
