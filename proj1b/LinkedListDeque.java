public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        private Node prev;
        private T item;
        private Node next;

        private Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public LinkedListDeque() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        if (size == 0) {
            head = new Node(null, item, null);
            tail = head;
            head.next = tail;
            tail.prev = head;
        } else {
            Node newNode = new Node(tail, item, head);
            tail.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == 0) {
            head = new Node(null, item, null);
            tail = head;
            head.next = tail;
            tail.prev = head;
        } else {
            Node newNode = new Node(tail, item, head);
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public void printDeque() {
        if (size == 0) {
            return;
        }
        Node p = head;
        while (p != tail) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item);
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = head.item;
        head = head.next;
        head.prev = tail;
        tail.next = head;
        size--;
        return item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T item = tail.item;
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        size--;
        return item;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        Node p = head;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p.item;
    }

    private T getRecursiveHelper(int index, Node p) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(index - 1, p.next);
    }

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return getRecursiveHelper(index, head);
    }
}
