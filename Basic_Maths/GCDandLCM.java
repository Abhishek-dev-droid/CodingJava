class Solution {
    static Long[] lcmAndGcd(Long A , Long B) {
        // code here
    //     long gcd=1;
    //     long lcm=1;
    //     for(int i = 1; i <= Math.min(A,B); i++){
    //         if(A % i == 0 && B % i == 0)
    //             gcd = i;
    //         if(A % i == 0 || B % i == 0)
    //             lcm = lcm * i;
                
    //     }
    //     return new Long []{lcm,gcd};
    // }
      long fno = A;
      long sno = B;
    
        while( A > 0 && B > 0){
            if(A > B)
                A = A % B;
            else
                 B = B % A;
        }
        if(A == 0)
            return new Long[]{(fno * sno)/ B,B};
        else
            return new  Long[]{(fno * sno)/ A , A};
        
   
    }
