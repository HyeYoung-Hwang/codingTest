import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        //int max = Arrays.stream(priorities).max().getAsInt(); 
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){ 
            q.offer(i);
        }
        
        // q=[0,1,2,3]
        while(!q.isEmpty()){
            int current = q.poll();
            
            if(priorities[current] == Arrays.stream(priorities).max().getAsInt()){
                answer++;
                priorities[current] = 0;
                
                if(current == location)
                    break;
            }else{
                q.offer(current);
            }
        }
        
        /*for(int i=0; i<priorities.length; i++){
            if(priorities[i] == max){
                System.out.println(i);
                System.out.println(priorities[i]);
                answer += 1; 
                if(i == location){
                    break;
                }
                q.poll();
                priorities[i] = 0;
                if(max != 1){
                    max = Arrays.stream(priorities).max().getAsInt(); 
                }
                if(i == priorities.length-1){
                    i = -1;
                }
                System.out.println("test"+answer);
            }else{
                q.poll();
                q.offer(i);
            }
        }*/
        
        return answer;
    }
}