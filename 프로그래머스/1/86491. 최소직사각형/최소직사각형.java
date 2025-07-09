class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int cards = sizes.length;
        int w =0;
        int h =0;
        for(int i=0; i<cards; i++){
            
            if(sizes[i][0]<sizes[i][1]){
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
            if(w<sizes[i][0]){
                w = sizes[i][0];
            }
            if(h<sizes[i][1]){
                h = sizes[i][1];
            }
        }
        answer = w * h;
        return answer;
    }
}