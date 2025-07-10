import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 1. lost의 숫자 혹은 +- 한 숫자 reserve에 있는지 확인
        // 2. 존재한다면 reserve 에서 제외시킴 => 크기 조절이 가능한 ArrayList로 변경!
        // 3. 존재하지 않는다면 n-- 함
        // 여벌 체육복있는 학생이 도난당하면 체육복 빌려줄수 없다는 걸 고려 안함
        // 4. lost와 reserve에서 같은 숫자 제외하기 (제일 처음에)
//         List<Integer> lostList = Arrays.stream(lost) // IntStream
//                            .boxed() // int → Integer
//                            .collect(Collectors.toList());
        
//         List<Integer> reserveList = Arrays.stream(reserve) // IntStream
//                            .boxed() // int → Integer
//                            .collect(Collectors.toList());
        
        List<Integer> lostList = Arrays.stream(lost).boxed().sorted().collect(Collectors.toList());
List<Integer> reserveList = Arrays.stream(reserve).boxed().sorted().collect(Collectors.toList());

        
        for(int student : lost){
            if(reserveList.contains(student)){
                lostList.remove(Integer.valueOf(student));
                reserveList.remove(Integer.valueOf(student));
            }
        }
        
        for(int student : lostList){
            if(reserveList.contains(student)){
                reserveList.remove(Integer.valueOf(student));
            }else if(reserveList.contains(student-1)){
                reserveList.remove(Integer.valueOf(student-1));
            }else if(reserveList.contains(student+1)){
                reserveList.remove(Integer.valueOf(student+1));
            }else{
                n--;
            }
        }
        
        answer = n;
        return answer;
    }
}