
//Brute force:- Gives TLE: - O(n^2) time complexity and O(1) space complexity.
class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int water= 0;
        for(int i = 0; i < n; i++){
            int maxLeft = 0, maxRight = 0;
            for(int j = 0; j<= i; j++){
                maxLeft = Math.max(maxLeft, height[j]);
            }

            for(int j = i; j<n; j++){
                maxRight = Math.max(maxRight, height[j]);
            }
            water+=Math.min(maxLeft, maxRight) - height[i];
        }
        return water;
    }
}
//--------------------------------------------------------------------------------------------------------------------------

//2nd Approach:- Better Approach. In this we approach we use two arrays leftMax and rightMax to store the max height to the left and right of each index. 

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0)
        return 0;
         int water=0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        for(int i= 1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        for(int i = n-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        for(int i = 0; i < n; i++){
            water+=Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}
//-------------------------------------------------------------------------------------------------------------------------

//3rd Approach:- Optimal Approach.

class Solution {
    public int trap(int[] height) {
       int left = 0;
        int right = height.length - 1;
        
        int total = 0;
        int leftMax = height[0];
        int rightMax = height[right];
        
        while(left<right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                if(leftMax-height[left] >0){
                    total=total+leftMax-height[left];
                }
                left++;
            }
            else{
                rightMax = Math.max(rightMax,height[right]);
                if(rightMax - height[right] > 0){
                    total = total+rightMax-height[right];
                }
                right--;
            }
        }
        return total;
    }
}