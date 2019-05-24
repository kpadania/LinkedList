// Java program to implement
// a Singly Linked List
public class LinkedList {

    /**
     *
     */
    private Node head; // head of list

    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    static class Node {

        int data;
        Node next;

        // Constructor
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    // Method to insert a new node
    private static LinkedList insert(LinkedList list, int data)
    {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }
    // Remove nth node from the front of the linked list
    public static void removeFromFront(LinkedList list, int index) throws Exception
    {
        int count = 1;
        if (list.head == null) {
            throw new Exception("List is empty");
        } else {
            Node current = list.head;
            Node temp = current;
            while(count<index){
                current=temp;
                temp = temp.next;
                count++;
            }
            if(temp == null){
                throw new Exception("Kth node is greater than the length of the list");
            } else {
                current.next = temp.next;
                temp.next = null;
            }

        }
    }
    // Remove nth Node from the back of the linked list
    public static void removeFromBack(LinkedList list, int index) throws Exception
    {
        int count = 1;
        if (list.head == null) {
            throw new Exception("List is empty");
        } else {
            Node first = list.head;
            Node second = list.head;
            Node temp = null;
            while(count<index){
                second = second.next;
                count++;
            }
            if(second!=null && second.next == null){
                while (first.next != null) {
                    temp = first;
                    first = first.next;
                }
            }
            while (second!=null && second.next != null) {
                    temp = first;
                    second = second.next;
                    first = first.next;
            }
            if(temp != null){
                temp.next = first.next;
                first.next = null;
                second.next = null;
            }
        }
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }

    public static Node getNthNode(LinkedList list,int n)
    {
        int counter = 1;
        Node current = list.head;
        while(counter<n){
            current = current.next;
            counter++;
        }
        return current;
    }
    // Detect if loop is present in linked list
    public static boolean detectCycle(LinkedList list)
    {
        Node slow = list.head;
        Node fast = list.head;

        slow = slow.next;
        fast= fast.next.next;
        while(slow != fast && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow==fast){
            return true;
        }
        return false;
    }

    // Return origin of the loop in Linked List
    public static Node findLoop(LinkedList list)
    {
        Node slow = list.head.next;
        Node fast = list.head.next.next;

        while(slow != fast && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow==fast){
            slow = list.head;
            while(slow != fast && fast.next!= null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }

    // Reverse the Linked List
    public static void reverseList(LinkedList list)
    {
        Node prev = null;
        Node curr = list.head;
        Node next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        list.head = prev;


    }

    public static void removeNodesBackInsertHead(LinkedList list, int n)
    {
        int count = 1;
        Node prev = null;
        Node curr = list.head;
        Node next = list.head;
        while(count<n){
            next = next.next;
            count++;
        }

        while (next!=null && next.next != null) {
            prev = curr;
            next = next.next;
            curr = curr.next;
        }

        prev.next = null;
        //reverse the new list
        prev = null;
        Node newCurr = curr;
        next = null;

        while(newCurr != null){
            next = newCurr.next;
            newCurr.next = prev;
            prev = newCurr;
            newCurr = next;
        }
        curr = prev;
        Node temp = curr;
        //Attached the new reversed list to the old list and point the head to the new list
        while(temp.next!=null)
        {
            temp = temp.next;
        }

        temp.next = list.head;
        list.head = curr;

    }
    // Driver code
    public static void main(String[] args) throws Exception {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();

        //
        // ******INSERTION******
        //

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        //getNthNode(list,5).next = getNthNode(list,3);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);
        /*Node curr = findLoop(list);
        System.out.println(curr.data)*/
        // Print the LinkedList
        removeNodesBackInsertHead(list, 5);
        printList(list);

        //removeFromFront(list,5);
        //removeFromBack(list,6);

        //printList(list);
    }
}
