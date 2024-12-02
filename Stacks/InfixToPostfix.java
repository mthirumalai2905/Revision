class Solution {
    public static int getPriority(char ch){
        if(ch =='^'){
            return 3;
        } else if(ch == '*' || ch == '/'){
            return 2;
        } else if(ch == '+' || ch == '-'){
            return 1;
        } 
        return -1;
    }
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        Stack<Character> stack = new Stack<>();
        String ans = "";
        
        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                ans += ch;
            } else if(ch == '('){
                stack.push(ch);
            } else if(ch == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    ans += stack.pop();
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(ch)){
                    ans += stack.pop();
                }
                stack.push(ch);
            }
        }
        
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        
        return ans;
    }
}


// To convert infix to prefix we need to reverse the string
// We need to also toggle the paranthesis
