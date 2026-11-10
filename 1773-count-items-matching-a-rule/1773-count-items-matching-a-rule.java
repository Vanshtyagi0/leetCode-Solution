class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int keyIndex = -1;
        if(ruleKey.equals("type")) keyIndex = 0;
        else if(ruleKey.equals("color")) keyIndex = 1;
        else keyIndex = 2;

        int count = 0;
        for(List<String> item: items){
            if(item.get(keyIndex).equals(ruleValue)) count++;
        }

        return count;
    }
}