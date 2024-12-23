class Heap {
    private int[] heap;
    private int size;
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int idx) {
        return (idx - 1) / 2;
    }

    private int leftChild(int idx) {
        return 2 * idx + 1;
    }

    private int rightChild(int idx) {
        return 2 * idx + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapify(int idx, boolean isUp) {
        if (isUp) {
            while (idx > 0 && heap[parent(idx)] < heap[idx]) {
                swap(idx, parent(idx));
                idx = parent(idx);
            }
        } else {
            int left = leftChild(idx);
            int right = rightChild(idx);
            int largest = idx;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }

            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }

            if (largest != idx) {
                swap(idx, largest);
                heapify(largest, false);
            }
        }
    }

    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = value;
        size++;
        heapify(size - 1, true);
    }

    public int deleteMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0, false);
        return max;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(15);
        heap.insert(30);

        System.out.println("Heap after insertions:");
        heap.display();

        System.out.println("Deleted max: " + heap.deleteMax());

        System.out.println("Heap after deletion:");
        heap.display();
    }
}
