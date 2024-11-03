public class DoublyLinkedList {
    public class Node {
        public Node prev;
        public int value;
        public Node next;
    }
    public Node head;
    public Node tail;

    public void print() {
        Node current = head;
        if (head == null) {
            System.out.println("Nothing in list!");
        }
        else {
            System.out.print("[");
            while (current != tail) {
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
        if (tail == null) {
            tail = new_node;
            head = new_node;
        }
        else {
            tail.next = new_node;
            new_node.prev = tail;
            tail = new_node;
        }
    }

    public int lookup(int index) {
        if (head == null) {
            System.out.println("Index out of range");
            return -1;
        }
        else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                if (current.next == null) {
                    System.out.println("Index out of range");
                    return -1;
                }
                current = current.next;
            }
            System.out.print(current.value);
            return 0;
        }

    }

    public void insertValueAt(int v, int index) {
        Node new_node = new Node();
        new_node.value = v;
        if (head == null && index == 0) {
            head = new_node;
            tail = new_node;
            return;
        }
        if (head == null) {
            System.out.println("Index out of range (insert)");
            return;
        }
        if (index == 0) {
            new_node.next = head;
            head.prev = new_node;
            head = new_node;
            return;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                if (i == index - 1) {
                    current.next = new_node;
                    new_node.prev = current;
                    tail = new_node;
                    return;
                }
                else {
                    System.out.println("Index out of range (insert)");
                    return;
                }
            }
            current = current.next;
        }
        new_node.next = current;
        new_node.prev = current.prev;
        current.prev.next = new_node;
        current.prev = new_node;
    }

    public void deleteIndex(int index) {
        if (head == null) {
            System.out.println("Index out of range (delete)");
            return;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                System.out.println("Index out of range (delete)");
                return;
            }
            current = current.next;
        }
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
        else if (current.next == null) {
            current.prev.next = null;
        }
        else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public void findMiddle() {
        if (head == null) {
            System.out.print("No values in list");
            return;
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        int midpoint = 0;
        if (count%2 == 0) {
            midpoint = (count / 2) - 1;
        }
        else {
            midpoint = count / 2;
        }
        Node iterate = head;
        for (int i = 0; i < midpoint; i++) {
            iterate = iterate.next;
        }
        System.out.print(iterate.value);
    }

    public void swap(Node x, Node y) {
        if (x == y) {
            return;
        }
        Node XPrev = x.prev;
        Node XNext = x.next;
        Node YPrev = y.prev;
        Node YNext = y.next;
        if (XPrev != null) {
            XPrev.next = y;
        }
        else {
            head = y;
        }
        if (XNext != null) {
            XNext.prev = y;
        }
        if (YPrev != null) {
            YPrev.next = x;
        }
        else {
            head = x;
        }
        if (YNext != null) {
            YNext.prev = x;
        }
        x.prev = YPrev;
        x.next = YNext;
        y.prev = XPrev;
        y.next = XNext;
    }

    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.print();
        myList.add(1);
        myList.print();
        myList.add(2);
        myList.add(3);
        myList.print();
        myList.add(4);
        myList.print();
        myList.lookup(1);
        myList.insertValueAt(5,0);
        myList.insertValueAt(6,4);
        myList.print();
        myList.insertValueAt(7,6);
        myList.print();
        myList.findMiddle();
        myList.add(8);
        myList.print();
        for (int i=9; i<500000; i++) {
            myList.add(i);
        }
    }
}
