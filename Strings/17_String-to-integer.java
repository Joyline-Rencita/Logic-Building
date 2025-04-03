class Solution {
    public int myAtoi(String str) {
        if(str == null || str.trim().length() == 0) return 0;
        str = str.trim();
        int len = str.length();
        int index = 0;
        boolean negative = false, exist = false;
        long res = 0L;
        while(index < len){
            char c = str.charAt(index++);
            if(index - 1 == 0 && (c == '+' || c == '-')){
                if(!exist){
                    negative = c == '+' ? false: true;
                    exist = true;
                }
                else return 0;
                continue;
            }
            if(Character.isDigit(c)){
                int num = c - '0';
                res *= 10;
                res += num;
                res = !negative ?  (res > Integer.MAX_VALUE ? Integer.MAX_VALUE: res) 
                    : (res > Math.abs((long)Integer.MIN_VALUE)) ? Math.abs((long)Integer.MIN_VALUE): res;
                continue;
            }
            if(c == ' ' || !Character.isDigit(c)) break;
        }
        if(negative) res *= -1;
        return (int)res;
    }
}
