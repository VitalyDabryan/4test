public class RainWater {
//    Дано n неотрицательных целых чисел, представляющих карту высот,
//    где ширина каждой полосы равна 1, вычислите, сколько воды она
//    может задержать после дождя.

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] water = new int[height.length];
        int maxHeightLeft = height[0];
        int maxHeightRight = height[2];
        int count = 0;

        for (int i = 1; i < height.length-1; i++) {
            if (height[i] < maxHeightLeft) {
                for (int j=i; j < height.length; j++){
                    if (height[j] <= maxHeightRight)
                    {
                        for (int k = j; k < height.length; k++) {
                            if (height[k] > maxHeightRight) {maxHeightRight = height [k]; j = k; break;}
                        }
                        for (int k = i; k < j; k++) {
                            water[k] =  Math.min(maxHeightLeft, maxHeightRight) - height[k];
                        }
                        if (maxHeightLeft < maxHeightRight) maxHeightLeft = maxHeightRight;
            if (j != height.length)
                            maxHeightRight = height[j+1];
                        i = j; break;
                    } else maxHeightRight = height[j];
                }
            } else maxHeightLeft = height[i];
        }

        System.out.println("Water flooded the cells:");
        for (int i = 0; i < water.length; i++) {
            System.out.print(water[i] + " ");
            count += water[i];
        }
        System.out.println(" ");
        System.out.print("How much water it can trap after raining: " + count);
    }
}
