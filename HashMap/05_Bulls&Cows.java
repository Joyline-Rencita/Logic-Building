class Solution {
    public String getHint(String secret, String guess) {
        char[] sArr = secret.toCharArray();
        char[] gArr = guess.toCharArray();
        int A = 0;
        int B = 0;
        int[] aCount = new int[10];
        int[] bCount = new int[10];
        for(int i = 0; i < sArr.length; i++){
            if(sArr[i] == gArr[i]){
                A++;
            }else{
                aCount[sArr[i] - '0']++;
                bCount[gArr[i] - '0']++;
            }
        }
        for(int i = 0; i < 10; i++){
            B += Math.min(aCount[i], bCount[i]);
        }
        return A + "A" + B + "B";
    }
}
