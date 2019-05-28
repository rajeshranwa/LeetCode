/*** Two Sum https://leetcode.com/problems/two-sum/ ***/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
    	Map<Integer,Integer> map = new HashMap<>();
    	for(int i=0;i<nums.length;i++) {
    		if(!map.containsKey(nums[i])) {
    			map.put(nums[i],i);
    		}
    	}
    	int[] r = new int[2];
    	for(int i=0;i<nums.length;i++) {
    		if(map.containsKey(target-nums[i])&&i!=map.get(target-nums[i])) {
    			//i,map.get(target-nums[i])
    			r[0]=Math.min(i,map.get(target-nums[i]));
    			r[1]=Math.max(i,map.get(target-nums[i]));
    			return r;
    		}
    	}
    	
    	return null;
    }
}