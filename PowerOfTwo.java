package LeetcodeAugChallenge;

// public class PowerOfTwo {
//     public boolean isPowerOfTwo(int n) {
//         if(n > 0){
//             //10 & 01 = 00
//             //100 & 011 = 000
//             if((n & (n - 1)) == 0) //because power of two has only one 1
//                 return true;
//         }
//         return false;
//     }
// }

public class PowerOfTwo {
        public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}