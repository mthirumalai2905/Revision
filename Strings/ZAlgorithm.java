class Solution{
  public static int[] calculate(String s){
    int n = s.length();
    int[] Z = new int[n];

    for(int i = 1; i < n; i++){
      while(i + Z[i] < n && s.charAt(Z[i]) == s.charAt(i + Z[i]){
        Z[i]++;
      }
    }
    return Z;
  }
}
    
