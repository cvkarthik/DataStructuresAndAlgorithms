import java.util.*;
class Mathematics{
    public static void main(String[] args) {
        //countNum(850);
        //System.out.println(isPalindromeNum(55));
        //System.out.println(factorial(5));
        //System.out.println(trailingZeros(100));
        //System.out.println(gcd(8,3));
        //System.out.println(lcm(8,3));
        //System.out.println(isPrime(83));
        //printPrimeFactors(120);
        //printDivisors(15);
        //seiveOfEratosthenes(25);
        //System.out.println(powerUsingRecursion(5,2));
        System.out.println(powerUsingIterative(3,3));
    }
    public static void countNum(int num){
        int count = 0;
        if(num < 0){
            num= (-1) * num;
        }
        while(num>0){
            num=num/10;
            count++;
        }
        System.out.println(count);
    }
    public static boolean isPalindromeNum(int num){
        if(num<0){
            num = num * (-1);
        }
        int rev = 0, temp =  num;
        while(temp>0){
            rev=(rev*10)+(temp%10);
            temp /= 10;
        }
        if(rev == num)
            return true;
        else
            return false;
    }
    public static int factorial(int num){
        int res = 1;
        if(num == 0)
            return 1;
        while(num>0){
            res=res * num;
            num-=1;
        }
        return res;
    }

    public static int trailingZeros(int num){
        int res = 0;
        for(int i=5;i<num;i=i*5){
            res = res + (num/i);
        }
        return res;
    }

    public static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }

    public static int lcm(int a, int b){
        int l = (a*b)/gcd(a,b);
        return l;
    }

    public static boolean isPrime(int num){
        if(num == 1)
            return false;
        if(num == 2 || num == 3)
            return true;
        if(num % 2 ==0 || num % 3 ==0)
            return false;
        for(int i = 5; i*i<= num; i=i+6)
        {
            if(num%i == 0 || num%(i+2) == 0)
                return false;
        }
        return true;
    }

    public static void printPrimeFactors(int num){
        if(num<1)
            System.out.println();
        while(num%2 == 0){
            System.out.println(2+" ");
            num = num/2;
        }
        while(num%3 == 0){
            System.out.println(3 + " ");
            num = num / 3;
        }
        for(int i=5;i*i<=num;i+=6){
            while(num%i == 0){
                System.out.println(i+" ");
                num/=i;
            }
            while(num%(i+2) == 0){
                System.out.println((i+2)+" ");
                num/=(i+2);
            }
        }
        if(num>3)
            System.out.println(num);
    }

    public static void printDivisors(int num){
        for(int i=1; i*i<=num; i++){
            if(num%i == 0){
                if(i == num/i)
                 System.out.println(i+" ");
                else
                    System.out.println(num/i+" ");
            }
        }
    }

    public static void seiveOfEratosthenes(int num){ //to get all primes less than givrn num
        boolean[] arr = new boolean[num+1];
        Arrays.fill(arr,true);
        for(int i=2;i<=num;i++){
            if(arr[i]){

                for(int j= 2*i; j<=num; j=j+i){
                    arr[j] = false;
                }
            }
        }
        for(int i=2;i<=num;i++){
            if(arr[i])
                System.out.print(i+" ");
        }
    }

    public static int powerUsingRecursion(int num, int pow){
        if(pow == 0)
            return 1;
        int temp = powerUsingRecursion(num, pow/2);
        int x = temp * temp;
        if(pow%2 == 0)
            return x;
        else
            return x * num;
    }

    public static int powerUsingIterative(int num, int pow){
        int res = 1;
        while(pow > 0){
            if((pow&1) == 1)
                res = res * num;
            num = num * num;
            pow=pow>>1;
        }
        return res;
    }

    public static int square(int n){
        if(n == 0)
            return 0;
        if(n < 0)
            n = -n;
        int x = n >> 1;

        if(n%2!=0)
            return (square(x) << 2)+ (x<<2) + 1;
        else
            return (square(x) << 2);
    }
}