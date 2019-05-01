public class MyHeap {

  /*- size is the number of elements in the data array.
    - push the element at index i downward into the correct position.
      This will swap with the larger of the child nodes provided that child is larger.
      This stops when a leaf is reached, or neither child is larger.
      [ should be O(logn) ]
    - precondition: index is between 0 and size-1 inclusive
    - precondition: size is between 0 and data.length-1 inclusive.
  */
  private static void pushDown(int[]data,int size,int index){
    while (index * 2 + 1 < size){
      if (index * 2 + 2 < size){
        int child1 = data[index * 2 + 1];
        int child2 = data[index * 2 + 2];
        if (child1 > child2 && child1 > data[index]){
          int temp = child1;
          data[index * 2 + 1] = data[index];
          data[index] = temp;
          index = index * 2 + 1;
        } else if (child2 > child1 && child2 > data[index]){
          int temp = child2;
          data[index * 2 + 2] = data[index];
          data[index] = temp;
          index = index * 2 + 2;
        } else {
          return;
        }
      } else {
        int child1 = data[index * 2 + 1];
        if (child1 > data[index]){
          int temp = child1;
          data[index * 2 + 1] = data[index];
          data[index] = temp;
          index = index * 2 + 1;
        } else {
          return;
        }
      }

    }
  }

  /*- push the element at index i up into the correct position.
      This will swap it with the parent node until the parent node is larger or the root is reached.
      [ should be O(logn) ]
    - precondition: index is between 0 and data.length-1 inclusive.
  */
  private static void pushUp(int[]data,int index){
    while (index != 0){
      int parent = data[(index-1)/2];
      if (index > parent){
        int temp = parent;
        data[(index-1)/2] = data[index];
        data[index] = temp;
        index = (index-1)/2;
      } else {
        return;
      }
    }
  }

  //- convert the array into a valid heap.
  //  [ should be O(n) ]
  /*public static void heapify(int[]data){


  }

  //- sort the array by converting it into a heap then removing the largest value n-1 times.
  //  [ should be O(nlogn) ]
  public static void heapsort(int[]data){

  }*/

  public static void main(String args[]){
    int[] data = {2,36,41,6,5,8,1,3,1};
    System.out.println(HeapHelp.toString(data));
    pushDown(data,data.length,0);
    System.out.println(HeapHelp.toString(data));
  }

}
