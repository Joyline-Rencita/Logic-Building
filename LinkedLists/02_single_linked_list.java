import java.util.Scanner;

/* Class Node */
class Node {
    int data;
    Node next;

    /* Constructor */
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/* Class SinglyLinkedList */
class SinglyLinkedList {
    private Node head;
    private int size;

    /* Constructor */
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    /* Function to check if the list is empty */
    public boolean isEmpty() {
        return head == null;
    }

    /* Function to get the size of the list */
    public int getSize() {
        return size;
    }

    /* Function to insert an element at the beginning */
    public void insertAtStart(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /* Function to insert an element at the end */
    public void insertAtEnd(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    /* Function to insert an element at a specific position */
    public void insertAtPos(int val, int pos) {
        if (pos <= 1) {
            insertAtStart(val);
        } else if (pos > size) {
            insertAtEnd(val);
        } else {
            Node newNode = new Node(val);
            Node temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    /* Function to delete an element at a specific position */
    public void deleteAtPos(int pos) {
        if (pos < 1 || pos > size) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
    }

    /* Function to reverse the linked list */
    public void reverseList() {
        Node prev = null, current = head, next;
        while (current != null) {
            next = current.next; // store the next node
            current.next = prev; // reverse the link
            prev = current; // move prev one step forward
            current = next; // move current one step forward
        }
        head = prev; // update head to the new front of the list
    }

    /* Function to display the elements of the linked list */
    public void display() {
        System.out.print("Singly Linked List = ");
        if (size == 0) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

/* Main Class */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("Singly Linked List Operations\n");
        char ch;
        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert at the beginning");
            System.out.println("2. Insert at the end");
            System.out.println("3. Insert at a specific position");
            System.out.println("4. Delete from a specific position");
            System.out.println("5. Reverse the linked list");
            System.out.println("6. Check if the list is empty");
            System.out.println("7. Get the size of the list");
            System.out.println("8. Display the list");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert at the beginning:");
                    list.insertAtStart(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Enter integer element to insert at the end:");
                    list.insertAtEnd(scan.nextInt());
                    break;
                case 3:
                    System.out.println("Enter integer element to insert:");
                    int num = scan.nextInt();
                    System.out.println("Enter position:");
                    int pos = scan.nextInt();
                    list.insertAtPos(num, pos);
                    break;
                case 4:
                    System.out.println("Enter position to delete:");
                    list.deleteAtPos(scan.nextInt());
                    break;
                case 5:
                    list.reverseList();
                    System.out.println("Linked list reversed.");
                    break;
                case 6:
                    System.out.println("Empty status = " + list.isEmpty());
                    break;
                case 7:
                    System.out.println("Size = " + list.getSize());
                    break;
                case 8:
                    list.display();
                    break;
                default:
                    System.out.println("Wrong Entry");
                    break;
            }
            System.out.println("\nDo you want to continue (Type y or n)?");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
        scan.close();
    }
}
