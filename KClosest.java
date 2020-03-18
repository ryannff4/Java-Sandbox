import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        // create a priority queue that contains a custom comparator to handle comparing arrays
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] left, int[] right) {
                // subtract left from right to have a maxheap order
                return (getSquareSum(right) - getSquareSum(left));
            }
        });
        int length = points.length;
        // iterate through points, and order them using a max heap; when there are more elements than needed (K), remove the element at the head of the heap as it is the farthest away from origin
        for (int i = 0; i < length; i++) {
            pq.add(points[i]);
            // remove the beginning element in the maxheap if there are too many in the heap
            if (pq.size() > K) {
                pq.poll(); // the coordinates farthest away from the origin are removed
            }
        }

        int[][] answer = new int[K][2];
        // move arrays from the max heap into the answers array
        for (int i = 0; i < K; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }
    public int getSquareSum(int[] coord) {
        return coord[0] * coord[0] + coord[1] * coord[1];
    }
}
