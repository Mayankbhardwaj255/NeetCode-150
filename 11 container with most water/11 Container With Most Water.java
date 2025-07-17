//Brute force:- 


class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
       int maxArea = 0;
        for(int i = 0; i< n; i++){
            for(int j = i+1; j<n; j++){
                int h = Math.min(height[i], height[j]);
                int w = j-i;
                int area = h*w;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
        
    }
}


// optimal approach :- Here 


class Solution {
    public int maxArea(int[] height) {
        
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left<right){
            
            int width = Math.min(height[left], height[right]);
            int length = right - left;
            
            max = Math.max(max, width*length);
            
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        
        return max;
        
    }
}
