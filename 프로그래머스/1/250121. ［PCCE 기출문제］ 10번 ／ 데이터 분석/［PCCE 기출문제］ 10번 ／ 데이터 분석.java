import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {
            public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
                
                Map<String, Integer> extMap = new HashMap<>();
                
                extMap.put("code", 0);
                extMap.put("date", 1);
                extMap.put("maximum", 2);
                extMap.put("remain", 3);
                
                int num_ext = extMap.get(ext);
                int sort = extMap.get(sort_by);
                
                int count = 0;
                for (int[] row : data) {
                    if (row[num_ext] < val_ext) {
                        count++;
                    }
                }
                
                int[][] result = new int[count][];
                
                int n = 0;
                for (int[] row : data) {
                    if (row[num_ext] < val_ext) {
                        result[n] = row;
                        n += 1;
                    }
                }
                
                Arrays.sort(result, (o1,o2) -> {
                        return o1[sort]-o2[sort];
                    });
                

                return result;

            }
        }