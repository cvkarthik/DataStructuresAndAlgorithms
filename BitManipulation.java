class BitManipulation{
    public static void main(String[] args) {
        //System.out.println(checkKthBitSet(4,3));
        //System.out.println(countSetBits(5));
        //System.out.println(isPowerOf2(4));
        int[]  arr = {1,1,1,2,2,3,3};
        //System.out.println(findOddOccuring(arr));
        int[] arr1 = {1,2,3,5};
        //System.out.println(findMissingNum(arr1));
        int[] arr2 = {1,1,2,2,2,3,3,4,4,4};
        //findTwoOddOccuring(arr2);
        //powerSetOfString("abc");
        //System.out.println(countBitsToBeFlipped(10,20));
        //System.out.println(finPositionOfOnlySetBit(2));
        //System.out.println(isPowerOf2(4));
    }
    public static boolean checkKthBitSet(int num, int k){
        //Using Left Shift
        if((num & (1 << (k - 1))) != 0){
            return true;
        }
        else{
            return false;
        }
        //Using Right Shift
        /*if((1 & (num >> (k-1))) == 1){
            return true;
        }
        else{
            return false;
        }*/
    }
    public static int countSetBits(int num){
        //Brian Kerningham Algorithm
        int count = 0;
        while(num > 0){
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    public static boolean isPowerOf2(int num){
        if(num == 0)
            return false;
        return ((num & (num - 1) ) == 0);
    }

    public static int findOddOccuring(int arr[]){
        //find a num which is occuring odd no of times in array
        int res = 0;
        for(int i=0; i<arr.length; i++){
            res = res ^ arr[i];
        }
        return res;
    }

    public static int findMissingNum(int arr[]){
        //in an raay of size n, 1 to (n+1) numbers cacn be prpesent distinct, find missing num
        int res = 0;
        for(int i:arr)
            res = res ^ i;
        for(int i = 0; i<= arr.length+1; i++){
            res = res ^ i;
        }
        return res;
    }

    public static void findTwoOddOccuring(int[] arr){
        int xor = 0;
        for(int i:arr)
            xor = xor ^ i;
        int rightsetbit = xor & ~(xor-1);
        int res1=0,res2=0;
        for(int i=0; i < arr.length; i++){
            if((arr[i] & rightsetbit) != 0)
                res1 = res1 ^ arr[i];
            else
                res2 = res2 ^ arr[i];
        }
        System.out.print(res1+" "+res2);
    }

    public static void powerSetOfString(String s){
        int n = s.length();
        int powsize = (int)Math.pow(2,n);
        for(int counter=0; counter<powsize; counter++){
            for(int j =0;j<n;j++){
                if((counter & (1<<j))!=0)
                    System.out.print(s.charAt(j));
            }
            System.out.print("\n");
        }
    }

    public static int countBitsToBeFlipped(int a, int b){
        int res = a^b, count = 0;
        while(res>0){
            count++;
            res=res&(res-1);
        }
        return count;
    }

    public static int finPositionOfOnlySetBit(int num){
        int count = 0;
        int num = N,sets=0;
        while(num>0){
            num=num&(num-1);
            sets++;
        }
        while(N!=0){
            count++;
            N=N>>1;
        }
        if(sets>1 || sets == 0)
            return -1;
        return count;
    }

    public static boolean isPowerofTwo(long n){
        int count = 0;
        while(n>0){
            n=n&(n-1);
            count++;
        }
        if(count == 1)
            return true;
        return false;
    }
}