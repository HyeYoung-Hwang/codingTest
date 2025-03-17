import java.util.HashMap;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0; i<participant.length; i++){
            map.put(participant[i],map.getOrDefault(participant[i],0)+1);
        }
        
        for(int i=0; i<completion.length; i++){
            if(map.get(completion[i])>1){
                map.put(completion[i],map.get(completion[i])-1);
            }else{
                map.remove(completion[i]);
            }
        }
        String result = String.join(", ", map.keySet().stream()
                                .map(String::valueOf)
                                .collect(Collectors.toList()));
        
        return result;
    }
}