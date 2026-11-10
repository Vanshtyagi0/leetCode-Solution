class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        for(int[] row : image){
            reverse(row);
        }

        return image;
    }

    private void reverse(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int temp = arr[left];
            arr[left] = arr[right] ^ 1;
            arr[right] = temp ^ 1;
            left++;
            right--;
        }
    }
}