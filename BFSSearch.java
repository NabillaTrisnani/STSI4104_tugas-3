import java.util.*;

/**
 * Pencarian angka n dengan Breadth-First Search (BFS)
 * NIM: 049283996 -> nilai node diambil dari potongan NIM (49, 92, 28, 83, 39, 99, 04, 96)
 */
public class BFSSearch {

    static String[] nama  = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8"};
    static int[]    nilai = { 49,   92,   28,   83,   39,   99,    4,   96 };

    static int[][] adj = {
        {1, 2},      // a1 -> a2, a3
        {0, 3, 4},   // a2 -> a1, a4, a5
        {0, 5, 6},   // a3 -> a1, a6, a7
        {1},         // a4 -> a2
        {1, 7},      // a5 -> a2, a8
        {2, 7},      // a6 -> a3, a8
        {2},         // a7 -> a3
        {4, 5}       // a8 -> a5, a6
    };

    static String isiQueue(Queue<Integer> q) {
        StringBuilder sb = new StringBuilder("[");
        for (int x : q) sb.append(nama[x]).append(" ");
        return sb.toString().trim() + "]";
    }

    public static void main(String[] args) {
        int n = 96;       // angka yang dicari
        int start = 0;    // mulai dari a1

        boolean[] visited = new boolean[8];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        System.out.println("=== BFS: mencari angka " + n + " mulai dari " + nama[start] + " ===");
        System.out.println("Queue awal: " + isiQueue(queue));

        int langkah = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            langkah++;
            System.out.printf("%nLangkah %d: dequeue %s (nilai %d)%n", langkah, nama[u], nilai[u]);

            if (nilai[u] == n) {
                System.out.println(">>> DITEMUKAN! " + nama[u] + " bernilai " + n);
                return;
            }
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                    System.out.println("   enqueue " + nama[v]);
                }
            }
            System.out.println("   Queue sekarang: " + isiQueue(queue));
        }
        System.out.println("Angka " + n + " tidak ditemukan pada graf.");
    }
}