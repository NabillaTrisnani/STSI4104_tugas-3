# Tugas 3 — STSI4104 Struktur Data

Program Java untuk **pencarian graf** menggunakan dua algoritma traversal: **Depth-First Search (DFS)** dan **Breadth-First Search (BFS)**.

## Identitas

| Keterangan    | Data                         |
| ------------- | ---------------------------- |
| Nama          | Nabilla Zahra Trisnani       |
| NIM           | 049283996                    |
| Program Studi | Sistem Informasi             |
| Fakultas      | Fakultas Sains dan Teknologi |
| UPBJJ UT      | Malang                       |

## Video Demo

Link YouTube: https://youtu.be/XJ37mH3Bxc0

## Isi Kode

| File           | Algoritma | Keterangan                                                                 |
| -------------- | --------- | -------------------------------------------------------------------------- |
| `DFSSearch.java` | DFS       | Pencarian mendalam (rekursif) dengan backtracking, mulai dari node a1      |
| `BFSSearch.java` | BFS       | Pencarian level-by-level menggunakan queue, mulai dari node a1             |

## Cara Menjalankan

Pastikan Java (JDK) sudah terpasang, kemudian jalankan perintah berikut di folder ini:

```bash
# Compile
javac DFSSearch.java
javac BFSSearch.java

# Run
java DFSSearch
java BFSSearch
```

## Contoh Output

**DFSSearch.java** (mencari nilai 96 dari node a1):
```
=== DFS: mencari angka 96 mulai dari a1 ===
Langkah 1: kunjungi a1 (nilai 49)
   a1 -> a2 (belum dikunjungi, masuk lebih dalam)
Langkah 2: kunjungi a2 (nilai 92)
   a2 -> a4 (belum dikunjungi, masuk lebih dalam)
Langkah 3: kunjungi a4 (nilai 83)
   backtrack ke a2
   a2 -> a5 (belum dikunjungi, masuk lebih dalam)
Langkah 4: kunjungi a5 (nilai 39)
   a5 -> a8 (belum dikunjungi, masuk lebih dalam)
Langkah 5: kunjungi a8 (nilai 96)
>>> DITEMUKAN! a8 bernilai 96
```

**BFSSearch.java** (mencari nilai 96 dari node a1):
```
=== BFS: mencari angka 96 mulai dari a1 ===
Queue awal: [a1 ]

Langkah 1: dequeue a1 (nilai 49)
   enqueue a2
   enqueue a3
   Queue sekarang: [a2 a3 ]

Langkah 2: dequeue a2 (nilai 92)
   enqueue a4
   enqueue a5
   Queue sekarang: [a3 a4 a5 ]

Langkah 3: dequeue a3 (nilai 28)
   enqueue a6
   enqueue a7
   Queue sekarang: [a4 a5 a6 a7 ]

Langkah 4: dequeue a4 (nilai 83)
   Queue sekarang: [a5 a6 a7 ]

Langkah 5: dequeue a5 (nilai 39)
   enqueue a8
   Queue sekarang: [a6 a7 a8 ]

Langkah 6: dequeue a6 (nilai 99)
   Queue sekarang: [a7 a8 ]

Langkah 7: dequeue a7 (nilai 4)
   Queue sekarang: [a8 ]

Langkah 8: dequeue a8 (nilai 96)
>>> DITEMUKAN! a8 bernilai 96
```
