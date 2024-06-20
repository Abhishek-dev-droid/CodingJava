class Solution {
    static String armstrongNumber(int n) {
        // code here
        int num=0;
        int original=n;
        while(n > 0){
            int rem = n % 10;
            num += rem * rem * rem;
            n = n/10;
        }
        if(num == original)
            return "true";
        else
            return "false";
    }
}
