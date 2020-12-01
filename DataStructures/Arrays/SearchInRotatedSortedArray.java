/*
	Q:  You are given an integer array nums sorted in ascending order, and an integer target.
		Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
		If target is found in the array return its index, otherwise, return -1. 
    
    Constraints: 
        1 <= nums.length <= 5000
        -10^4 <= nums[i] <= 10^4
        All values of nums are unique.
        nums is guranteed to be rotated at some pivot
        -10^4 <= target <= 10^4
    
    Source: leetcode
*/

class Solution{

	public int search1(int[] nums, int target){
		/*
            Solution-1
            Author: RamaKrishnaKunda
            TimeComplexity: O(n)
            Desc: Loop over the complete array and check if target is present or not.
        */
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target)
                return i;
        }
        return -1;
	}

	public int search2(int[] nums, int target){
		/*
            Solution-1
            Author: RamaKrishnaKunda
            TimeComplexity: O(n)
            Desc: Comapre target with last element, if less, search from left else search from right. 
        */
        if(nums.length == 0)
            return -1;
        if(target <= nums[nums.length - 1]){
            int nextNumber = nums[nums.length - 1];
            for(int i = nums.length - 1; i >=0; i--){
                if(nums[i] == target)
                    return i;
                
                if(nextNumber < nums[i])
                    return -1;
            }
        }
        else{
            int prevNumber = nums[0];
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == target)
                    return i;
                if(prevNumber > nums[i])
                    return -1;
            }
        }
        return -1;
	}

	public int search3(int[] nums, int target){
		/*
            Solution-1
            Author: RamaKrishnaKunda
            TimeComplexity: O(logn)
            Desc: Find the least element index(lex). If target is less than last element do binary search between
            lex and nums.length-1, else do binary search between 0 and lex.
        */
        int leastIndex = getLeastIndex(nums);
        System.out.println(leastIndex);
        if(target <= nums[nums.length - 1]){
            return searchElement(nums, leastIndex, nums.length-1, target);
        }
        else{
            return searchElement(nums, 0, leastIndex, target);
        }
	}

	int getLeastIndex(int[] nums){
        int l = 0;
        int r = nums.length - 1;
        int m = l + (r-l)/2;
        while(l <= r){
            m = l + (r-l)/2;
            if(m+1 <= nums.length-1 && m-1>=0 && nums[m] < nums[m+1] && nums[m] < nums[m-1])
                return m;
            if(nums[m] < nums[r]){
                r = m - 1;
            }
            else 
                l = m + 1;
        }
        return m; 
    }
    int searchElement(int[] nums, int l, int r, int target){
        int m;
        while(l<=r){
            m = l + (r-l)/2;
            if(nums[m] == target)
                return m;
            if(nums[m] < target)
                l = m+1;
            else
                r = m-1;
        }
        return -1;
    }

    public int search4(int[] nums, int target){
		/*
            Solution-1
            Author: RamaKrishnaKunda
            TimeComplexity: O(logn)
            Desc: We can see that if the array is divided into half, one part of the array is sorted. Check
            if left of mid is sorted or not. If sorted see if target is present in sorted part. If not sorted
            check the other half. if target is not present or prsent in the sorted half shift the low and high positions
            accordingly
        */
        int l = 0;
        int h = nums.length - 1;
        int mid = l+ (h -l)/2;
        while(l<=h){
            mid = l+ (h -l)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target <= nums[mid])
                {
                    h = mid-1;
                    continue;
                }
                else{
                    l = mid+1;
                    continue;
                }
            }
            else{
                if(nums[mid+1]<= target && target <= nums[h]){
                    l = mid+1;
                    continue;
                }
                else{
                    h = mid-1;
                    continue;
                }
            }
        }
        return -1;
     }

}