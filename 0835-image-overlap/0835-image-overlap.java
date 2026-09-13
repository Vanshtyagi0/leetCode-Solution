class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
       int n = img1.length;

       List<int[]> ones1 = new ArrayList<>();
       List<int[]> ones2 = new ArrayList<>();

       for(int r = 0; r < n; r++){
        for(int c = 0; c < n; c++){
            if(img1[r][c] == 1){
                ones1.add(new int[]{r, c});
            }

            if(img2[r][c] == 1){
                ones2.add(new int[]{r, c});
            }
        }
       }

       int maxOverlap = 0;
       HashMap<String, Integer> map = new HashMap<>();

       for(int[] p1 : ones1){
        for(int[] p2 : ones2){
            
            int shiftRows = p2[0] - p1[0];
            int shiftCols = p2[1] - p1[1];

            String key = shiftRows + "," + shiftCols;

            int count = map.getOrDefault(key, 0) + 1;
            map.put(key, count);

            maxOverlap = Math.max(maxOverlap, count);
        }
       }

       return maxOverlap;
    }
}