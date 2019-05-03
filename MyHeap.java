public class MyHeap {

  //Pushes a number down the heap till its sufficiently sorted
  private static void pushDown(int[] data, int size, int index) {
    boolean go  = true; //Boolean to check whether or not to keep switching
    while (go && index < size) {
      if (2 * index + 2 < size) {
        //If already sorted, method is finished
        if (data[index] >= data[2 * index + 2] && data[index] >= data[2 * index + 1]) {
          go = false;
        }
        //Checking for the 1st child
        else if (data[2 * index + 1] > data[2 * index + 2]){
          swap(data, index, 2 * index + 1);
          index = 2 * index + 1;
        }
        //Checking for the 2nd child
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

  //Swaps the places of two indicies in an array
  private static void swap(int[] arr, int x, int y) {
    int holder = arr[x];
    arr[x] = arr[y];
    arr[y] = holder;
  }

  //Pushes a number up the heap till its sufficiently sorted
  private static void pushUp(int[] data, int index) {
    boolean go = true;
    while (go) {
      if (index == 0) go = false;
      else {
        int parentI  = (index - 1) / 2;
        if (data[parentI] < data[index]) {
          swap(data, parentI, index);
          index = parentI;
        }
        else go = false;
      }
    }
  }

  //Turns an array into a heap
  public static void heapify(int[] data) {
    for (int x = (int) Math.pow(2, Math.log(data.length) / Math.log(2)); x >= 0; x --) {
      pushDown(data, data.length, x);
    }
  }

  //Sorts the heap
  public static void heapsort(int[] data) {
    heapify(data);
    for (int x = data.length - 1; x >= 0; x --) {
      swap(data, x, 0);
      pushDown(data, x, 0);
    }
  }
}
