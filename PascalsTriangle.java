package LeetcodeAugChallenge;

import java.util.*;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
    
        for(int i = 1; i <= numRows; i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);

            if (i > 2) {
                List<Integer> prev = ans.get(i - 2);
                for (int j = 1; j < i - 1; j++) {
                    int sum = prev.get(j - 1) + prev.get(j);
                    row.add(sum);
                }
            }

            if(i > 1)
                row.add(1);
            ans.add(row);
        }
        return ans;
    }
}