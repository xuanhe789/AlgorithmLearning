public class 移动零 {
    //第一种双指针
    public void moveZeroes(int[] nums) {
        //k指向0的元素
        int k=0,j=0;
        for ( j=0;j<nums.length;j++){
            if (nums[j]!=0){
                int temp=nums[j];
                nums[j]=nums[k];
                nums[k]=temp;
                k++;
            }
        }
    }

    //第二种双指针
    public void moveZeroes2(int[] nums) {
        int j=0;
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i=j;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
