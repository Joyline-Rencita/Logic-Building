public class GFG
{

static void fibo(int n, int a, int b)
{
	if (n > 0) {
		// Function call
		fibo(n - 1, b, a + b);
		System.out.print(a + " ");
	}
}

public static void main(String args[])
{
	int N = 10;
	fibo(N, 0, 1);
}
}
