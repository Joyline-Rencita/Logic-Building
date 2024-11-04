class Solution {
    public boolean isHappy(int n) {
        if(n <= 0) return false;
        Set<Integer> visited = new HashSet<>();
        List<Integer> temp = null;
        while(!visited.contains(n)){
            visited.add(n);
            temp = new ArrayList<>();
            getDigits(temp, n);
            int count = 0;
            for(Integer d : temp){
                count += d * d;
            }
            if(count == 1) return true;
            n = count;
        }
        return false;
    }
    
    private void getDigits(List<Integer> list, int n){
        while(n != 0){
            list.add(n % 10);
            n /= 10;
        }
    }
}
