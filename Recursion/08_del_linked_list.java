// Java program to delete a linked list using recursion
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}
// Given the head of a list, delete the list using recursion
public class main {
     static void deleteList(Node curr) {
        
        // Base case: If the list is empty, return
        if (curr == null) {
            return;
        }
        // Recursively delete the next node
        deleteList(curr.next);
        
        // Delete the current node
        curr = null;
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
   
        deleteList(head);
        head = null;
        System.out.print("Linked List deleted.");
    }
}
