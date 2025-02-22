class Solution {
    public TreeNode recoverFromPreorder(String t) {
        Stack<TreeNode> s = new Stack<>();
        int i = 0;
        while(i < t.length()){
            int depth = 0;
            while(i < t.length() && t.charAt(i) == '-'){
                depth++;
                i++;
            }
            int value = 0;
            while(i < t.length() && Character.isDigit(t.charAt(i))){
                value = value*10 + (t.charAt(i) - '0');
                i++;
            }
            TreeNode node = new TreeNode(value);
            while(s.size() > depth){
                s.pop();
            }
            if(!s.isEmpty()){
                if(s.peek().left == null){
                    s.peek().left = node;
                } else {
                    s.peek().right = node;
                }
            }
            s.push(node);
        } 
        while(s.size() > 1){
            s.pop();
        }
        return s.pop();
    }
}
