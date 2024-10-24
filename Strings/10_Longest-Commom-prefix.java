class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return divideAndConquer(strs, 0, strs.length - 1);
    }
    private String divideAndConquer(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int mid = (left + right) / 2;
        String leftPrefix = divideAndConquer(strs, left, mid);
        String rightPrefix = divideAndConquer(strs, mid + 1, right);
        return commonPrefix(leftPrefix, rightPrefix);
    }
    private String commonPrefix(String left, String right) {
        int minLen = Math.min(left.length(), right.length());
        for (int i = 0; i < minLen; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, minLen);
    }
}
