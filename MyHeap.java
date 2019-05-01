import java.util.*;

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
    while (index * 2 + 1 < size){ //has at least one child (not a leaf)
      if (index * 2 + 2 < size){ //has two children
        int child1 = data[index * 2 + 1];
        int child2 = data[index * 2 + 2];
        if (child1 > child2 && child1 > data[index]){ //first child is larger than second child and is greater than parent
          int temp = child1; //swap values
          data[index * 2 + 1] = data[index];
          data[index] = temp;
          index = index * 2 + 1; //update index
        } else if (child2 >= child1 && child2 > data[index]){ //second child is larger than first child and is greater than parent
          int temp = child2; //swap values
          data[index * 2 + 2] = data[index];
          data[index] = temp;
          index = index * 2 + 2; //update index
        } else { //children are not larger
          return; //exit function
        }
      } else { //only one child
        int child1 = data[index * 2 + 1];
        if (child1 > data[index]){ //child is greater than parent
          int temp = child1; //swap values
          data[index * 2 + 1] = data[index];
          data[index] = temp;
          index = index * 2 + 1; //update index
        } else { //child is not greater
          return; //exit method
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
    while (index != 0){ //not the root
      int parent = data[(index-1)/2];
      if (data[index] > parent){ //is larger than parent
        int temp = parent; //swap values
        data[(index-1)/2] = data[index];
        data[index] = temp;
        index = (index-1)/2;
      } else { //not larger than parent
        return; //exit function
      }
    }
  }

  //- convert the array into a valid heap.
  //  [ should be O(n) ]
  public static void heapify(int[]data){
    for(int i = data.length; i >= 0; i--){ //looping from back to front
      pushDown(data, data.length, i); //push all values down to valid positions
    }
  }

  //- sort the array by converting it into a heap then removing the largest value n-1 times.
  //  [ should be O(nlogn) ]
  public static void heapsort(int[]data){
    heapify(data); //changes data into heap
    for(int i = data.length-1; i >= 0; i--){ //looping from back to front
      int swap = data[i]; //stores largest number
      data[i] = data[0]; //swaps largest number to proper position
      data[0] = swap;
      pushDown(data,i,0); //pushes down swapped value
    }
  }

  /*public static void main(String args[]){
    int[] data = {3,5,32,446,7,4784,7,43,4,3436,6564,532,4,7,786,2};
    System.out.println(HeapHelp.toString(data));
    //pushDown(data,data.length,0);
    //pushUp(data,8);
    heapsort(data);
    System.out.println(HeapHelp.toString(data));
  }*/

  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        MyHeap.heapsort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}

}
