// Iterative Java program to reverse a linked list

class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Given the head of a list, reverse the list and return the
// head of reversed list
public class GfG {
    public static Node reverseList(Node head) {
        
        // Initialize three pointers: curr, prev and next
        Node curr = head, prev = null, next;

        // Traverse all the nodes of Linked List
        while (curr != null) {
            
            // Store next
            next = curr.next;
            
            // Reverse current node's next pointer
            curr.next = prev;
            
            // Move pointers one position ahead
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // This function prints the contents of the linked list starting from the head
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Print the original linked list
        System.out.print("Given Linked list:");
        printList(head);
        
        // Function call to return the reversed list
        head = reverseList(head);

        // Print the reversed linked list
        System.out.print("\nReversed Linked List:");
        printList(head);
    }
}
