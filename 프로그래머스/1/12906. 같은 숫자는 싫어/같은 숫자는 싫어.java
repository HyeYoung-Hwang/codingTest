import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        //ArrayList사용
//         ArrayList<Integer> list = new ArrayList<>();
        
//         for(int i=0; i<arr.length; i++){
//             if(i>0 && (arr[i-1] == arr[i])){
//                 continue;
//             }
//             list.add(arr[i]);
//         }
        
//         int[] answer = new int[list.size()];
//         for(int i=0; i<list.size(); i++){
//             answer[i] = list.get(i);
//         }
        
//         return answer;
        
        //stack 사용
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(i==0){
                st.push(arr[i]);
            }
            else if(st.peek() != arr[i]){
                st.push(arr[i]);
            }
        }
        
        int[] answer = new int[st.size()];
        for(int i=st.size()-1; i>=0; i--){
            answer[i] = st.pop();
        }
        
        return answer;
    }
}