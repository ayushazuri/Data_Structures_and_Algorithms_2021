public class SingleElementInDuplicates {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length-2; // if element is last, to consider last element take high to be last second so that low reaches last
        while(l <= h){
            int mid = (l + h) >> 1;
            if(nums[mid] == nums[mid^1])
                l = mid +1;
            else
                h = mid - 1;
        }
        return nums[l];
    }
}

/*
* Left side
* 1st instance even
* 2nd instance odd
*
* mid^1 => if mid is even it give next number if mid is odd, it gives prev number
* 3^1 == 2 (11^1 == 10)
* 4^1 == 5 (100^1==101)
* */