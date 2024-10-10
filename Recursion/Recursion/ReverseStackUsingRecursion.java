class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        if(s.isEmpty()){
            return;
        }
        
        int top = s.pop();
        reverse(s);
        insert(s, top);
    }
    static void insert(Stack<Integer> s, int top){
        if(s.isEmpty()){
            s.push(top);
            return;
        }
        
        int peek = s.pop();
        insert(s, top);
        s.push(peek);
    }
