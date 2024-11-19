import java.util.ArrayList;

public class Main {
    private ArrayList<Integer> heap;

    public Main() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;
        while (current > 0 && heap.get(current) > heap.get((current - 1) / 2)) {
            swap(current, (current - 1) / 2);
            current = (current - 1) / 2;
        }
    }

    public int delete() {
        if (heap.isEmpty()) return -1;
        int root = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);
        return root;
    }

    private void heapify(int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heap.size() && heap.get(left) > heap.get(largest)) largest = left;
        if (right < heap.size() && heap.get(right) > heap.get(largest)) largest = right;

        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {
        Main heap = new Main();
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);
        System.out.println(heap.delete());
        System.out.println(heap.delete());
    }
}
