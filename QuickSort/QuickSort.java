public class QuickSort {
    public static void main(String args[]){
        int[] nums = {5, 4, 3, 2, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }
    public static void quickSort(int[] nums, int low, int high){
        int s = low; 
        int e = nums.length - 1;

        if(s>=e){
            return; 
        }
        int mid = s+(e-s) / 2;
        int pivot = nums[mid];
        while(s<pivot){
         s++;
        }
        while(e > pivot){
            e--;
        }
        while(s <= e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
        quickSort(nums, s, high);
        quickSort(nums, low, e);


    }

}

