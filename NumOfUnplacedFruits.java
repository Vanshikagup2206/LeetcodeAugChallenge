package LeetcodeAugChallenge;

public class NumOfUnplacedFruits {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] usedBaskets = new boolean[baskets.length];
        int count = 0;

        for(int i = 0; i < fruits.length; i++){
            boolean placed = false;
            for(int j = 0; j < baskets.length; j++){
                if(fruits[i] <= baskets[j] && !usedBaskets[j]){
                    usedBaskets[j] = true;
                    placed = true;
                    break;
                }
            }
            if(!placed)
                count++;
        }
        return count;
    }
}