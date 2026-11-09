class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] result = new int[index.length];

        for(int i = 0; i < index.length; i++){
            insert(result, index[i], nums[i]);
        }

        return result;
    }

    private void insert(int[] arr, int i, int val){
        int j = arr.length - 1;
        while(j > i){
            arr[j] = arr[j - 1];
            j--;
        }
        arr[i] = val;
    }
}