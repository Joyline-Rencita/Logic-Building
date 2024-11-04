class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        if(s == null || s.length() < 10) return result;
        int len = s.length();
        for(int i = 0; i <= len - 10; i++){
            String sub = s.substring(i, i + 10);
            if(!map.containsKey(sub)){
                map.put(sub, 1);
            }else if(map.get(sub) == 1){
                result.add(sub);
                map.put(sub, map.get(sub) + 1);
            }else continue;
        }
        return result;
    }
}
