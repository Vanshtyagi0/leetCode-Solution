class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        HashMap<String, String> map = new HashMap<>();

        for(List<String> knowi : knowledge){
            String key = knowi.get(0);
            String value = knowi.get(1);
            map.put(key, value);
        }
        StringBuilder result = new StringBuilder();
        int start = -1;
        int i = 0;
        while(i < s.length()){

            char ch = s.charAt(i);

            if(ch == '('){
                i++;
                start = i;
                int j = i;
                while(j < s.length() && s.charAt(j) != ')'){
                    j++;
                }

                String key = s.substring(i, j);
                String value = map.containsKey(key)? map.get(key): "?";
                result.append(value);
                i = j;
            }
            else{
                result.append(ch);
            }
            i++;
        }

        return result.toString();
    }
}