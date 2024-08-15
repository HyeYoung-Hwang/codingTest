class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        if(n<1 || n>7){
            throw new IllegalArgumentException("1 ≤ board의 길이 ≤ 7");
        }
        
        if(h < 0 || h >= n || w < 0 || w >= n){
            throw new IllegalArgumentException("0 ≤ h,w < board의 길이");
        }
        
        if(board[h][w].length() < 1 || board[h][w].length() > 10){
            throw new IllegalArgumentException("1 ≤ board[h][w]의 길이 ≤ 10");
        }
        
        char[] charArray = board[h][w].toCharArray();
        for(int index = 0; index < charArray.length; index++){
            if(!Character.isLowerCase(charArray[index])){
                throw new IllegalArgumentException("영어 소문자로만 이루어져야 합니다.");
            }
        }

            
        int count = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        for(int i = 0; i <= 3; i++){
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if(h_check >= 0 && h_check < n && w_check >= 0 && w_check < n){
                if(board[h][w].equals(board[h_check][w_check])){
                    count += 1;
                }
            }
        }
        return count;
    }
}