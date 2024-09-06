import java.util.*;
class Main {
    static void towerOfHanoi(int n, char beg, char end, char aux)
    {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, beg, aux, end);
        System.out.println("Move disk " + n + " from rod "+ beg + " to rod " + end);
        towerOfHanoi(n - 1, aux, end, beg);
    }
    public static void main(String args[])
    {
        int N = 3;
        towerOfHanoi(N, 'A', 'C', 'B');
    }
}
