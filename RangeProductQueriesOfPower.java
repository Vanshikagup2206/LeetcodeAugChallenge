package LeetcodeAugChallenge;

import java.util.ArrayList;
import java.util.List;

public class RangeProductQueriesOfPower {
    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Build list of powers of two 
        int currentPower = 1;
        List<Integer> powers = new ArrayList<>();
        while (n > 0) {
            if ((n & 1) == 1) {
                powers.add(currentPower);
            }
            currentPower *= 2;
            n >>= 1; // right shift n
        }

        int[] ans = new int[queries.length];
        final int MOD = 1_000_000_007;
        for(int i = 0; i < queries.length; i++){
            long cur = 1;
            int start = queries[i][0];
            int end = queries[i][1];
            for(int j = start; j <= end; j++){
                cur = (cur * powers.get(j)) % MOD;
            }
            ans[i] = (int)cur;
        }
        return ans;
    }
}
