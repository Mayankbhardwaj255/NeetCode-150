import java.util.*;

// MaxHeap class using ArrayList
class MaxHeap {
    private List<Integer> heap;

    // Constructor to initialize empty heap
    public MaxHeap() {
        heap = new ArrayList<>();
    }

    // Returns index of parent node
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Returns index of left child
    private int left(int i) {
        return 2 * i + 1;
    }

    // Returns index of right child
    private int right(int i) {
        return 2 * i + 2;
    }

    // Insert a new element into the heap
    public void insert(int val) {
        heap.add(val); // Add at the end
        int i = heap.size() - 1;

        // Bubble up: move up until max-heap property is restored
        while (i != 0 && heap.get(parent(i)) < heap.get(i)) {
            Collections.swap(heap, i, parent(i));
            i = parent(i); // Move to parent index
        }
    }

    // Get the maximum value (root of the heap)
    public int getMax() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0); // Root is the maximum
    }

    // Extract and remove the maximum element from the heap
    public int extractMax() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int max = heap.get(0); // Store the root (max element)
        int last = heap.remove(heap.size() - 1); // Remove last element

        if (!heap.isEmpty()) {
            heap.set(0, last); // Move last element to root
            heapify(0);        // Restore heap property
        }

        return max; // Return the original max
    }

    // Heapify the subtree rooted at index i
    private void heapify(int i) {
        int largest = i;
        int l = left(i);
        int r = right(i);

        // Find the largest among root, left and right child
        if (l < heap.size() && heap.get(l) > heap.get(largest)) {
            largest = l;
        }
        if (r < heap.size() && heap.get(r) > heap.get(largest)) {
            largest = r;
        }

        // If root is not the largest, swap and continue heapify
        if (largest != i) {
            Collections.swap(heap, i, largest);
            heapify(largest); // Recursively heapify affected subtree
        }
    }

    // Print the current state of the heap
    public void printHeap() {
        System.out.println(heap);
    }
}