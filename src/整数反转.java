public class 整数反转 {
    public int reverse(int x) {
        int res=0;
      while (x!=0){
          int temp=x%10;
          if (res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&temp>Integer.MAX_VALUE%10)){
              return 0;
          }
          if (res <Integer.MIN_VALUE/10|| (res==Integer.MIN_VALUE/10&&temp<Integer.MIN_VALUE%10)){
              return 0;
          }
          res=res*10+temp;
          x=x/10;
      }
      return res;
    }

    public static void main(String[] args) {
        String s="021";
        System.out.println(Integer.parseInt(s));
    }
}
