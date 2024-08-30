import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            double day = (double)(100 - progresses[i])/speeds[i];
            int days = (int)Math.ceil(day);
            queue.add(days);
        }
        
        while(!queue.isEmpty()){
            int count = 1;
            int firstNum = queue.poll();
            while(!queue.isEmpty() && firstNum >= queue.peek()){
                count++;
                queue.remove();
            }
            list.add(count);
        }
        
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}