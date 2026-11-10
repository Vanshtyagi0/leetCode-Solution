class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        for(int[] row : image){
            reverse(row);
        }

        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[0].length; j++){
                if(image[i][j] == 0) image[i][j] = 1;
                else image[i][j] = 0;
            }
        }

        return image;
    }

    private void reverse(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}