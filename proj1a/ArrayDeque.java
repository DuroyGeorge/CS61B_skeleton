public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int capacity;
    private int head;
    private int tail;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        head = 0;
        tail = 7;
        capacity = 8;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private void resize(int newCapacity) {
        T[] newItems = (T[]) new Object[newCapacity];
        int p = (head - 1 + capacity) % capacity;
        for (int i = size - 1; i >= 0; i--) {
            newItems[i] = items[p];
            p = (p - 1 + capacity) % capacity;
        }
        items = newItems;
        head = size;
        tail = newCapacity - 1;
        capacity = newCapacity;
    }

    public void addFirst(T item) {
        if (isFull()) {
            resize(capacity * 2);
        }
        items[head] = item;
        head = (head + 1) % capacity;
        size++;
    }

    public void addLast(T item) {
        if (isFull()) {
            resize(capacity * 2);
        }
        items[tail] = item;
        tail = (tail - 1 + capacity) % capacity;
        size++;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        int p = (head - 1 + capacity) % capacity;
        while (p != tail) {
            System.out.print(items[p] + " ");
            p = (p - 1 + capacity) % capacity;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = items[(head - 1 + capacity) % capacity];
        head = (head - 1 + capacity) % capacity;
        size--;
        if (capacity >= 16 && size < capacity / 4) {
            resize(capacity / 2);
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = items[(tail + 1) % capacity];
        tail = (tail + 1) % capacity;
        size--;
        if (capacity >= 16 && size < capacity / 4) {
            resize(capacity / 2);
        }
        return item;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return items[(head - index - 1 + capacity) % capacity];
    }
}
