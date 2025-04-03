public class Solution {
  public static void main(String args[])
	{
		String str = "Geeks Gor Geeks";
		int index = 6;
		char ch = 'F';
		System.out.println("Original String = " + str);      // Print the original string
    
    //approach : 1
		str = str.substring(0, index) + ch + str.substring(index + 1);

		//approach : 2
     StringBuilder string = new StringBuilder(str);
     string.setCharAt(index, ch);

    //approach : 3
    StringBuffer string = new StringBuffer(str);
    string.setCharAt(index, ch);

		System.out.println("Modified String = " + str);     // Print the modified string
	}
}
