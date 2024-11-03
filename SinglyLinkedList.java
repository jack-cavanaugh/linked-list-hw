public class SinglyLinkedList {
    public class Node {
        public int value;
        public Node next = null;
    }
    public Node head;

    public void print() {
        Node current = head;
        if (current == null) {
            System.out.println("Nothing in list!");
        }
        else {
            System.out.print("[");
            while (current.next != null) {
                System.out.print(current.value + ",");
                current = current.next;
            }
            System.out.print(current.value);
            System.out.print("]");
        }
    }

    public void add(int v) {
        Node new_node = new Node();
        new_node.value = v;
        if (head == null){
            head = new_node;
        }
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new_node;   
        }
    }

    public void cons(int v) {
        Node new_node = new Node();
        new_node.value = v;
        if (head == null) {
            head = new_node;
        }
        else {
            Node current = head;
            head = new_node;
            new_node.next = current;
        }
    }

    public int lookup(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                return -1;
            }
            current = current.next;
        }
        if (current.next == null) {
            return -1;
        }
        System.out.print(current.value);
        return 0;
    }

    public void insertValueAt(int v, int index) {
        Node new_node = new Node();
        new_node.value = v;
        if (head == null && index == 0) {
            head = new_node;
        }
        else if (index == 0) {
            new_node.next = head;
            head = new_node;
        }
        else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                if (current.next == null) {
                    System.out.println("Your index is out of range (insert index)");
                    return;
                }
                current = current.next;
            }
            Node next = current.next;
            current.next = new_node;
            new_node.next = next;
        }
    }

    public void deleteIndex(int index) {
        if (head == null) {
            System.out.println("Your index is out of range (delete index)");
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        Node previous = null;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
            if (current.next == null) {
                System.out.println("Your index is out of range (delete index)");
                return;
            }
        }
        previous.next = current.next;
    }

    public void secondToLast() {
        if (head == null || head.next == null) {
            System.out.println("Less than two values in list!");
            return;
        }
        Node current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        System.out.print(previous.value);
    }

    public void concat(SinglyLinkedList M) {
        if (M.head == null) {
            System.out.println("M is empty");
            return;
        }
        Node lastNode = head;
        if (lastNode == null) {
            head = M.head;
            return;
        }
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = M.head;
    }

    public void swap(Node x, Node y) {
        if (x == null || y == null) {
            System.out.println("X or Y does not exist");
            return;
        }
        Node valueBeforeX = null;
        Node valueBeforeY = null;
        Node current = head;
        while (current != x) {
            valueBeforeX = current;
            current = current.next;
        }
        current = head;
        while (current != y) {
            valueBeforeY = current;
            current = current.next;
        }
        if (valueBeforeX != null) {
            valueBeforeX.next = y;
        }
        else {
            head = y;
        }
        if (valueBeforeY != null) {
            valueBeforeY.next = x;
        }
        else {
            head = x;
        }
        Node pointer = x.next;
        x.next = y.next;
        y.next = pointer;
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void clones() {
        SinglyLinkedList M = new SinglyLinkedList();
        Node current = head;
        Node tail = null; 
        while (current != null) {
            Node new_node = new Node();
            new_node.value = current.value;
            if (M.head == null) {
                M.head = new_node;
                tail = new_node;
            }
            else {
                tail.next = new_node;
                tail = new_node;
            }
            current = current.next;
        }
    }


    public static void main(String[] args) {
        SinglyLinkedList myList = new SinglyLinkedList();

        myList.add(1);
        myList.print();
        myList.secondToLast();
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.print();
        myList.cons(5);
        myList.print();
        myList.cons(6);
        myList.print();
        myList.add(7);
        myList.print();
        myList.lookup(4);
        myList.insertValueAt(8,2);
        myList.print();
        myList.deleteIndex(5);
        myList.print();
        myList.secondToLast();
        myList.reverse();
        myList.print();
    }
}