import java.util.*;

/**
 * Pencarian angka n dengan Depth-First Search (DFS)
 * NIM: 049283996 -> nilai node diambil dari potongan NIM (49, 92, 28, 83, 39, 99, 04, 96)
 */
public class DFSSearch {

    static String[] nama  = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8"};
    static int[]    nilai = { 49,   92,   28,   83,   39,   99,    4,   96 };

    // Daftar tetangga (indeks 0 = a1 ... 7 = a8), graf tidak berarah
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

    static boolean[] visited = new boolean[8];
    static int langkah = 0;

    static boolean dfs(int u, int n, String indent) {
        visited[u] = true;
        langkah++;
        System.out.printf("%sLangkah %d: kunjungi %s (nilai %d)%n", indent, langkah, nama[u], nilai[u]);

        if (nilai[u] == n) {
            System.out.println(indent + ">>> DITEMUKAN! " + nama[u] + " bernilai " + n);
            return true;
        }
        for (int v : adj[u]) {
            if (!visited[v]) {
                System.out.printf("%s   %s -> %s (belum dikunjungi, masuk lebih dalam)%n", indent, nama[u], nama[v]);
                if (dfs(v, n, indent + "   ")) return true;
                System.out.printf("%s   backtrack ke %s%n", indent, nama[u]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 96;            // angka yang dicari (2 digit akhir NIM)
        int start = 0;         // mulai dari a1
        System.out.println("=== DFS: mencari angka " + n + " mulai dari " + nama[start] + " ===");
        if (!dfs(start, n, "")) {
            System.out.println("Angka " + n + " tidak ditemukan pada graf.");
        }
    }
}