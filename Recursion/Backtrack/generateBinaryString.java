class Solution {
  public static List<String> generateBinaryStrings(int n) {
    // code here
    List<String> list = new ArrayList<>();
    backtrack("", list, n);
    return list;
  }
  public static void backtrack(String curr, List<String> list, int n){
      if(curr.length() == n){
          list.add(curr);
          return;
      }
      
      
      backtrack(curr + '0', list, n);
      if(curr.isEmpty() || curr.charAt(curr.length() -1) != '1'){
          backtrack(curr + '1', list, n);
      }
  }
}
