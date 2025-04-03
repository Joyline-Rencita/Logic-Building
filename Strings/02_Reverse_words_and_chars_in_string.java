public class Main {

    // Function to reverse a portion of the character array
    void reverse(char[] str, int start, int end) {
        char temp;
        while (start < end) {
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

    // Function to reverse the entire string
    char[] reverseCharacters(char[] s) {
        reverse(s, 0, s.length - 1);
        return s;
    }

    // Function to reverse each word in the string
    char[] reverseWords(char[] s) {
        int start = 0;
        for (int end = 0; end < s.length; end++) {
            if (s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1;
            }
        }
        // Reverse the last word
        reverse(s, start, s.length - 1);
        return s;
    }

    // Function to reverse both words and characters within the string
    char[] reverseWordsAndCharacters(char[] s) {
        // Step 1: Reverse the entire string
        reverseCharacters(s);

        // Step 2: Reverse each word in the reversed string
        reverseWords(s);

        return s;
    }

    // Driver Code
    public static void main(String[] args) {
        Main main = new Main();
        String s = "i like this program very much";

        // Reverse only characters
        char[] charsReversed = main.reverseCharacters(s.toCharArray());
        System.out.println(charsReversed);

        // Reset to original for next operation
        s = "i like this program very much";
        
        // Reverse only words
        char[] wordsReversed = main.reverseWords(s.toCharArray());
        System.out.println(wordsReversed);

        // Reset to original for next operation
        s = "i like this program very much";

        // Reverse both words and characters
        char[] wordsAndCharsReversed = main.reverseWordsAndCharacters(s.toCharArray());
        System.out.println(wordsAndCharsReversed);
    }
}

OUTPUT : 
hcum yrev margorp siht ekil i
i ekil siht margorp yrev hcum
much very program this like i
