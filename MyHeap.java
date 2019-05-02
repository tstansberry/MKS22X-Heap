public class MyHeap {

  public static void main(String[] args) {
    int size = 15;
    int[] test = new int[size];
    for (int i = 0; i < size; i++) test[i] = (int)(Math.random()*9);
    HeapPrinter.print(test);
    heapsort(test);
    HeapPrinter.print(test);
  }

  private static void pushDown(int[] data, int size, int index) {
    boolean go  = true; //Boolean to check whether or not to keep switching
    while (go && index < size) {
      if (2 * index + 2 < size) {
        if (data[index] >= data[2 * index + 1] && data[index] >= data[2 * index + 2]) {
          go = false;
        }
        else if (data[2 * index + 1] > data[2 * index + 2]){
          swap(data, index, 2 * index + 1);
          index = 2 * index + 1;
        }
        else {
          swap(data, index, 2 * index + 2);
          index = 2 * index + 2;
        }
      }
      else if (2 * index + 1 < size && data[index] < data[2 * index + 1]) {
        swap(data, index, 2 * index + 1);
        go = false;
      }
      else go = false;
    }
  }
//Algorithm for parent: (index - 1) / 2
//Algorithm for child: 2(index + 1)

  private static void swap(int[] arr, int x, int y) {
    int holder = arr[x];
    arr[x] = arr[y];
    arr[y] = holder;
  }

  private static void pushUp(int[] data, int index) {

  }

  public static void heapify(int[] data) {
    for (int x = (int) Math.pow(2, Math.log(data.length) / Math.log(2)); x >= 0; x --) {
      pushDown(data, data.length, x);
    }
  }

  public static void heapsort(int[] data) {
    heapify(data);
    for (int x = data.length - 1; x >= 0; x --) {
      swap(data, x, 0);
      pushDown(data, x, 0);
    }
  }
}
