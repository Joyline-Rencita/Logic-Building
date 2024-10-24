class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows == 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++)
            sbs[i] = new StringBuilder();
        int len = s.length();
        int count = 0;
        int index = 0;
        boolean down = true;
        while(index < len){
            char c = s.charAt(index++);
            sbs[count].append(c);
            if(down) count++;
            else count--;
            if(count == numRows - 1 || count == 0)	//此处要注意减1。
                down = !down;
        }
        for(int i = 1; i < numRows; i++)
            sbs[0].append(sbs[i].toString());
        return sbs[0].toString();
    }
}
