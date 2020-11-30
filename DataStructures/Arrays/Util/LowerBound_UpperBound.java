class Solution {
    /*
        Author: D-madhukar, RamaKrishnaKunda
        Desc: Finding LowerBound and UpperBound for an element in an array using BinarySearch
    */
    public static void main(String args[]) {
        int input[]=new int[]{5,10,21,24,26,32,45,46};
        //Normal case both lower bound and upperBound exist
        System.out.println(lowerBound(input,15));
        System.out.println(upperBound(input,15));
        
        //Case-2: where lowerBound doesnot exist
        System.out.println(lowerBound(input,2));
        
        //Case-3: where upperBound doesnot exist
        System.out.println(upperBound(input,49));
        
    }
    public static int lowerBound(int nums[], int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
            int mid =left+(right-left+1)/2;
            if(nums[mid]>=target)
                right=mid-1;
            else 
                left=mid;
        }
        return nums[left]<target?left:-1;
    }
    public static int upperBound(int nums[], int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
            int mid =left+(right-left)/2;
            if(nums[mid]>target)
                right=mid;
            else 
                left=mid+1;
        }
        return nums[left]>target?left:-1;
    }

}
