import java.io.*; 

class CalcMean 
{ 
	// Function Definition of findMean function 
	static float findMean(int A[], int N) 
	{ 
		if (N == 1) 
			return (float)A[N-1]; 
		else
			return ((float)(findMean(A, N-1)*(N-1) + 
										A[N-1]) / N); 
	} 

	public static void main (String[] args) 
	{ 
		float Mean = 0; 
		int A[] = {1, 2, 3, 4, 5}; 
		int N = A.length; 
		System.out.println(findMean(A, N)); 
	} 
} 
