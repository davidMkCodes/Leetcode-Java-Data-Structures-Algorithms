//Leetcode #4
//https://leetcode.com/problems/median-of-two-sorted-arrays/
//Time Complexity: O(n+m)
//Space Complexity: O(n+m)
public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int totalSize = nums1.length + nums2.length;
        int[]totalList = new int[totalSize];
        
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                totalList[i+j] = nums1[i];
                i++;
            }else{
                totalList[i+j] = nums2[j];
                j++;
            }
        }
        
        while(i < nums1.length){
            totalList[i+j] = nums1[i];
            i++;
        }
        
        while(j < nums2.length){
            totalList[i+j] = nums2[j];
            j++;
        }
        
        int middle = (totalSize/2);
        if(totalSize % 2 == 0){
            double a = totalList[middle-1];
            double b = totalList[middle];
            
            return (a+b)/2;
        }
        
        return totalList[middle];
    }
}
