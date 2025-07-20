<img src = "https://cxu.igu.mybluehost.me/wp-content/uploads/2025/06/Kapibarasan.png">
# B+ Tree Visualizer (Java + Graphviz + FFmpeg + Python)

This project provides a visual representation of operations on a B+ Tree data structure, such as insertions, deletions, and searches.  
Each operation step is exported as a `.dot` file (Graphviz format), converted to `.png` images, and finally compiled into an animation (`.mp4` video).

## 📦 Features

- B+ Tree implementation in Java with:
  - Insertion, deletion, and search
  - Visual snapshots at each step
- Exports Graphviz `.dot` files with unique timestamped filenames
- Batch conversion to `.png` via Graphviz
- Generates a video of the steps using FFmpeg

---

## 🛠 Requirements

- **Java 8+**
- **Graphviz** (add `dot` command to PATH)
- **FFmpeg** (add `ffmpeg` to PATH)
- Windows OS (due to `.bat` scripts)

---

&copy; Takanori Nagashima, OTH student.