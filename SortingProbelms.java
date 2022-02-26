import java.util.*;
class SortEvenOdd implements Comparator<Integer>{
    public int compare(Integer a, Integer b){
        return (a%2) - (b%2);
    }
}
class ArraySortProblems{
    public static void main(String[] args) {
        sortArrayEvenOdd();
    }
    static void sortArrayEvenOdd(){
        Integer[] arr={5,20,1,3,2,5};
        Arrays.sort(arr,new SortEvenOdd());
        System.out.println(Arrays.toString(arr));
    }
}