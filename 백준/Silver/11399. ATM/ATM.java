import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Pi 값들 입력 받기
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //배열을 오름차순으로 정렬
        Arrays.sort(arr);
        
        int[] answer = new int[n];
        answer[0] = arr[0];
        for(int i=1; i<n; i++){
            answer[i] = answer[i-1]+arr[i];
        }

        int sum=0;
        for(int x :answer){
            sum+= x;
        }

        System.out.print(sum);
    }
}