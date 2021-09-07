public class testing {
    public static void main(String args[]) {
        int[] nums={5,1,2,3,4};
        int p=0;
        int r=nums.length-1;
        int q=(p+r)/2;
        if(nums[q]<=nums[r] && nums[q]>=nums[p]){
            System.out.println( nums[0]);
        }
        while(p<=r){
            q=(p+r)/2;
            if(q!=nums.length-1){
                if(nums[q]>nums[q+1])
                    System.out.println( nums[q+1]);
                    else if(nums[q]>nums[p])
                    p=q;
                    else if(nums[q]>nums[r])
                    r=q;
            }
            
            
            
        }
        System.out.println( -1);
        
        
    }
    
}
