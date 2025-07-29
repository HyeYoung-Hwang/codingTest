import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(line);

        int M = Integer.parseInt(br.readLine());
        int[] checkLine = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int i=0; i<M; i++){
            if(Arrays.binarySearch(line,checkLine[i]) >=0) {
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }
}
