#  DAA-Assignment-1

**Design & Analysis of Algorithms** — Java implementation of classic divide-and-conquer algorithms with benchmarking, metrics logging, and reporting.

---

##  Features

- **Sorting Algorithms**
  - MergeSort (baseline + buffer reuse + cutoff to insertion sort)
  - QuickSort (randomized pivot, smaller-first recursion)

- **Selection**
  - Deterministic Select (Median of Medians, group of 5)

- **Geometry**
  - Closest Pair of Points (2D, divide-and-conquer, O(n log n))

- **Utilities**
  - Metrics collection (comparisons, swaps, allocations, recursion depth, runtime)
  - CSV writer for results
  - CLI interface to run algorithms with parameters

- **Benchmarking**
  - JMH harness for comparing Select vs Sort

- **Docs**
  - Master theorem cases, Akra–Bazzi intuition
  - Initial runtime plots

---
```
## Project Structure

DAA-Assignment-1/
├─ src/
│ ├─ main/java/com/example/
│ │ ├─ sort/ # MergeSort, QuickSort
│ │ ├─ select/ # Deterministic Select (MoM5)
│ │ ├─ geometry/ # Closest Pair of Points
│ │ ├─ util/ # Swap, partition, shuffle, guards
│ │ ├─ Metrics.java
│ │ ├─ CsvWriter.java
│ │ └─ Main.java # CLI entry point
│ └─ test/java/com/example/
│ └─ ... (JUnit 5 tests)
├─ docs/
│ ├─ report.md
│ └─ plots/
│ ├─ mergesort.png
│ ├─ quicksort.png
│ └─ select.png
├─ pom.xml
└─ README.md

```
---

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+

### Build
```bash
mvn clean install

java -cp target/daa-assignment-1-1.0-SNAPSHOT.jar com.example.Main \
  --algo mergesort --size 10000 --output metrics.csv
```
```
mvn test
```

- **Metrics**
  - Runtime
  - Coparisions
  - Swaps
  - Recursions Depth
  - Allocations
  - Input size 

Output is written to metrics.csv for later plotting.

---

### Report & Analysis

## Master Theorem Cases

- **We use the Master Theorem to analyze standard recurrences:**
  - Case 1 (Sublinear work dominates):
  
    T(n) = aT(n/b) + O(n^d), with d < log_b(a).

    Example: Binary Search
  
  T(n) = T(n/2) + O(1) → O(log n).
  - Case 2 (Balanced work):
    
    f(n) = Θ(n^log_b(a)).
    
    Example: MergeSort
    
    T(n) = 2T(n/2) + Θ(n) → O(n log n).

  - Case 3 (Outside work dominates):
    
    f(n) grows faster than n^log_b(a).
    
    Example: Strassen-like preprocessing.

---

## Akra–Bazzi Intuition

- **The Akra–Bazzi theorem generalizes Master Theorem to unbalanced recursions.**
- QuickSort recurrence:
- 
  T(n) = T(U) + T(n – U – 1) + Θ(n), with random pivot U.
  
  Expected complexity: O(n log n).

- Deterministic Select (MoM5):
  
  Groups of 5 → median-of-medians pivot → guarantees linear O(n) time.
  
  Recurrence: T(n) ≤ T(n/5) + T(7n/10) + O(n).

---

## Experimental Results
- **We ran algorithms on increasing input sizes and collected metrics.
  Plots (see docs/plots/) confirm theoretical behavior:**
  - MergeSort → Θ(n log n)

  - QuickSort (randomized pivot) → Θ(n log n) expected

  - Deterministic Select → Θ(n)

  - Closest Pair of Points → Θ(n log n)
## Development 

- **Conventional commits are used:**
- Feat: new algorithms or CLI features
- refactor: internal utilities
- test: unit test

