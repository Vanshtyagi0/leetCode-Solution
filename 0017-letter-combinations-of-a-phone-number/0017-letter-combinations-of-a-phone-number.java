class Solution {
    String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        backTrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backTrack(List<String> ans, StringBuilder curr, String digits, int index){

        if(digits.length() == index){
            ans.add(curr.toString());
            return;
        }

        int num = digits.charAt(index) - '0';
        String key = keys[num];

        for(char ch : key.toCharArray()){
            curr.append(ch);
            backTrack(ans, curr, digits, index + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

}