package LeetcodeAugChallenge;

import java.util.*;

public class RearrangingFruits {

//     public long minCost(int[] basket1, int[] basket2) {
//         Map<Integer, Integer> hm1 = new HashMap<>();
//         Map<Integer, Integer> hm2 = new HashMap<>();
//         int globalMin = Integer.MAX_VALUE;

//         // Count frequencies & track global min
//         for (int v : basket1) {
//             hm1.put(v, hm1.getOrDefault(v, 0) + 1);
//             globalMin = Math.min(globalMin, v);
//         }
//         for (int v : basket2) {
//             hm2.put(v, hm2.getOrDefault(v, 0) + 1);
//             globalMin = Math.min(globalMin, v);
//         }

//         // Feasibility check
//         Set<Integer> all = new HashSet<>();
//         all.addAll(hm1.keySet());
//         all.addAll(hm2.keySet());
//         for (int val : all) {
//             int total = hm1.getOrDefault(val, 0) + hm2.getOrDefault(val, 0);
//             if (total % 2 != 0) return -1;
//         }

//         // Collect all surplus values into one list
//         List<Integer> surplus = new ArrayList<>();
//         for (int val : all) {
//             int diff = hm1.getOrDefault(val, 0) - hm2.getOrDefault(val, 0);
//             if (diff != 0) {
//                 int count = Math.abs(diff) / 2;
//                 for (int i = 0; i < count; i++) {
//                     surplus.add(val);
//                 }
//             }
//         }

//         Collections.sort(surplus);
//         int swapsNeeded = surplus.size() / 2;

//         long cost = 0;
//         for (int i = 0; i < swapsNeeded; i++) {
//             cost += Math.min(surplus.get(i), 2L * globalMin);
//         }

//         return cost;
//     }
// }

    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int m = Integer.MAX_VALUE;
        for (int b1 : basket1) {
            freq.put(b1, freq.getOrDefault(b1, 0) + 1);
            m = Math.min(m, b1);
        }
        for (int b2 : basket2) {
            freq.put(b2, freq.getOrDefault(b2, 0) - 1);
            m = Math.min(m, b2);
        }

        List<Integer> merge = new ArrayList<>();
        for (var entry : freq.entrySet()) {
            int count = entry.getValue();
            if (count % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                merge.add(entry.getKey());
            }
        }

        Collections.sort(merge);
        long res = 0;
        for (int i = 0; i < merge.size() / 2; i++) {
            res += Math.min(2 * m, merge.get(i));
        }
        return res;
    }
}