package pl.mg.codewars;

/**
 * Write a method, isCircleSorted(int[] A), that determines if A is circularly sorted. An Array is circularly sorted if the elements are sorted in ascending order, but displaced, or rotated, by any number of steps.

For Example:

True:
isCirleSorted(A={2,3,4,5,0,1});
[4,5,6,9,1]
[10,11,6,7,9]
[1,2,3,4,5]
[5,7,43,987,-9,0]


False:
[4,1,2,5]
[8,7,6,5,4,3]
[6,7,4,8]
[7,6,5,4,3,2,1]
 * @author m
 *
 */
public class CircleSorted {
    public static void main(String[] args) {
    }

    public boolean isCircleSorted(int[] a) {
        if (a.length == 0) {
            return false;
        }
        if(a.length==1)
            return true;
        
        
        int startMin = a[0];
        int current = a[0];
        int index = 0;
        while (current<a[index+1]) {
          /*  current
            index++;*/
            
        }
        return false;
    }

    private boolean checkSecond(int[] a, int min, int startIndex) {
        return false;
    }
}
