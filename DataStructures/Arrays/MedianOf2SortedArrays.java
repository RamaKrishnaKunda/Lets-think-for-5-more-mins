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


class Solution {

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        /* 
            Solution-1
            Author: D-madhukar
            TimeComplexity: O(nlogn)
            Desc: Create a single array, then sort and get the median
        */
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

    
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        /*
            Solution-2
            Author: RamaKrishnaKunda
            TimeComplexity: O(m+n)
            Desc: Use the idea of Merge Sort on two sorted arrays. Median lies at (n/2, n/2 + 1) if n is even and (n/2 + 1) if n is odd.
        */
        int pos1 = -1;
        int pos2 = -1;
        double mean = 0;
        if((nums1.length + nums2.length) % 2 == 0){
            pos1 = ((nums1.length + nums2.length) / 2);
            pos2 = pos1 + 1;
        }
        else{
            pos1 = ((nums1.length + nums2.length) / 2) + 1;
        }
        int i = 0;
        int j = 0;
        while(i != nums1.length && j != nums2.length){
            if(i + j + 1 == pos1 || i + j + 1 ==pos2){
                if(nums1[i] <= nums2[j])
                    mean += nums1[i];
                else
                    mean += nums2[j];
            }
            if(nums1[i] <= nums2[j])
                i++;
            else
                j++;
        }
        if(i == nums1.length){
            while(j != nums2.length){
                if(i + j + 1 == pos1 || i + j + 1 ==pos2){
                    mean += nums2[j];
                }
                j++;
            }
        }
        else if(j == nums2.length){
            while(i != nums1.length){
                if(i + j + 1 == pos1 || i + j + 1 == pos2){
                    mean += nums1[i];
                }
                i++;
            }
        }
       if(pos2 != -1){
           return mean/2;
       }
       return mean;        
    }

}