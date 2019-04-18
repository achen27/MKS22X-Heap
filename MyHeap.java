public class MyHeap {

  /*- size is the number of elements in the data array.
    - push the element at index i downward into the correct position.
      This will swap with the larger of the child nodes provided thatchild is larger.
      This stops when a leaf is reached, or neither child is larger.
      [ should be O(logn) ]
    - precondition: index is between 0 and size-1 inclusive
    - precondition: size is between 0 and data.length-1 inclusive.
  */
  private static void pushDown(int[]data,int size,int index){
    while (//index...has children && at least one child is larger){
      //check for second child??
      int child;
      //compare children
      //if there is a child larger than temp
      //swap with larger of the two children
      //change index and loop again
      //if there is no larger child --> return

    }
  }

  /*- push the element at index i up into the correct position.
      This will swap it with the parent node until the parent node is larger or the root is reached.
      [ should be O(logn) ]
    - precondition: index is between 0 and data.length-1 inclusive.
  */
  private static void pushUp(int[]data,int index){
    while (//not root && parent root is not larger){
      int parent;
      //swap with parent
    }
  }

  //- convert the array into a valid heap.
  //  [ should be O(n) ]
  public static void heapify(int[]data){


  }

  //- sort the array by converting it into a heap then removing the largest value n-1 times.
  //  [ should be O(nlogn) ]
  public static void heapsort(int[]data){

  }

}
