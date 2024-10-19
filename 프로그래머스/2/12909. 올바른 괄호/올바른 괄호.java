import java.util.Stack;

class Solution {
    boolean solution(String s) {
        try{
            boolean answer = false;
        
        Stack st = new Stack();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(0) == ')'){
                break;
            }
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                st.pop();
            }
        answer = st.empty();
        }
        return answer;
        }
        catch(Exception e){
            return false;
        }
        
    }
}