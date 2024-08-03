public class Main {  
   static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
       solve(q, k);
       int s = q.size() - k;
       while( s-- > 0){
           int x = q.poll();
           q.add(x);
       }
       return q;
   }
   static void solve(Queue<Integer> q, int k){
       if(k == 0) return;
       int e = q.poll();
       solve(q, k - 1);
       q.add(e);
   }
   public static void main (String[] args) {
       Queue<Integer> queue = new LinkedList<Integer>();
       queue.add(10);
       queue.add(20);
       queue.add(30);
       queue.add(40);
       queue.add(50);
       queue.add(60);
       queue.add(70);
       queue.add(80);
       queue.add(90);
       queue.add(100);
 
       int k = 5;
       queue = reverseFirstK(queue, k);
      while (!queue.isEmpty()) {
           System.out.print(queue.poll() + " ");
       }
   }
}

Output : 
50 40 30 20 10 60 70 80 90 100 
