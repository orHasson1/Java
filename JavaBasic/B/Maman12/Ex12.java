
/**
 * Ex12 is a class for the answers of maman 12.
 *
 * @author Or hasson
 * @version 15/11/20
 */
public class Ex12{
    /**
     * The method receives an array which each number in it appears twice in
     * sequence, except for one number that appears only once. It returns the
     * number that has no partner.
     * efficiency: The while loop is advanced by division of 2 so it's efficiency 
     * is O(logn). The rest of the operations are negligible because they don't 
     * depend on the size of the input,Therefore the efficiency is O(logn).  
     * @param a The array of numbers.
     * @return The number that has no partner.
     */
    public static int findSingle (int [] a){
        /* The only number that has no couple should be in one of the 
         * indexes in [start,end].*/
        int start = 0;  
        int end = a.length -1;
        int median = (start + end) / 2; // The median index of [start,end]
        
        /* Before the appearance of the number that has no partner, in each one of 
         * the identical pairs, the first number is in an even index and the second 
         * is in an odd index. After the appearance of the number that has no 
         * partner, the situation is reversed (first in odd index and second in 
         * even index). In addition, number that has no partner can be only in 
         * an even indexes.
         */
        while(start < end){
            if(median % 2 == 0){
                if(a[median] == a[median-1]){
                    end = median - 2;
                } // If there is an identical pair as the first in odd index 
                  // and the second in even index (median).
                else if(a[median] == a[median+1]){
                    start = median + 2;
                } // If there is an identical pair as the first in even index 
                  // (median) and the second in odd index.
                else{
                    return a[median];
                } // If there is no partner to the number in median.
            } // If median is even.
            else{
                if(a[median] == a[median-1]){
                    start = median + 1;
                } // If there is an identical pair as the first in even index 
                  // and the second in odd index (median).
                if(a[median] == a[median+1]){
                    end = median - 1;
                } // If there is an identical pair as the first in odd index
                  // (median) and the second in even index.
            } // If median is odd.
            
            // Calculates the median index for the current start and stop.
            median = (start + end) / 2;
        } // End of while.
    
        return a[start]; // The command is executed only if start = end 
    } 
    
    /**
     * The method receives an array and an integer x. It returns the smallest 
     * subarray that it's sum is greater than x.
     * efficiency: The for loops make 1/2 * n * (n+1) iterations overall, as the
     * number of the subarrays of an array in length n. Therefore their time 
     * efficiency is O(n^2) (negligable components were discarded). The other 
     * components of the components are negligble, therefore the time efficiency is 
     * O(n^2).
     * @param arr The array
     * @param x The integer.
     * @return The smallest subarray of arr[] that it's sum is greater than x.
     */
    public static int smallestSubSum(int arr[], int x){
        int minLen = arr.length + 1; // The size of the smallest subarray that  
                                     // it's sum is greater than x.
        
        for (int i=0; i<arr.length; i++){
            int subArrSum = arr[i]; // The sum of the current subarray.
            
            if(subArrSum > x){
                return 1;
            } // If the number in index i is greater than x.
            
            for (int j=i+1; j<arr.length; j++){ 
                subArrSum += arr[j];
                int subArrLen = j - i + 1; // The length of the current subarray.
                if((subArrSum > x) && (subArrLen < minLen)){ 
                    minLen = subArrLen; 
                } // If the current subarray sum is greater than x and smaller 
                  // than minLen.
            } // End of inner for loop. 
        } // End of external for loop.
        
     minLen = minLen == arr.length + 1 ? -1 : minLen;
     return minLen; 
    }
}
