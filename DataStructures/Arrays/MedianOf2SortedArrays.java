/*
    Q:  Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays. 
    
    Constraints: 
        nums1.length == m
        nums2.length == n
        0 <= m <= 1000
        0 <= n <= 1000
        1 <= m + n <= 2000
        -106 <= nums1[i], nums2[i] <= 106
    
    Source: leetcode
*/ 




/* 
    Solution-1
    Author: D-madhukar
    TimeComplexity: O(nlogn)
    Desc: Create a single array, then sort and get the median
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n=nums2.length;
        int res[] = new int[n+m];
        for(int i=0;i<m;i++)
            res[i]=nums1[i];
        for(int i=0;i<n;i++)
            res[i+m]=nums2[i];
        double result;
        Arrays.sort(res);
        if(res.length%2==0) {
            int mid1 = res.length/2;
            int mid2 = (res.length/2)-1;
            result=(res[mid1]+res[mid2])/2.0;
        } else {
            result=res[res.length/2];
        }
        return result;
    }
}