public class Main
{   
    static int factorialOfN(int num){
        if(num==0||num==1){
            return 1;
        }
        return num*factorialOfN(num-1);
    }
    static int nthFibonnaci(int num){
        if(num == 0 || num == 1){
            return num;
        }
        return nthFibonnaci(num-1)+nthFibonnaci(num-2);
    }
    static boolean palindromeCheck(String s, int start, int end){
        if(start>=end)
            return true;
        return ((s.charAt(start) == s.charAt(end)) && palindromeCheck(s,start+1,end-1));
    }
    static int sumOfDigits(int num){
        if(num==0)
            return 0;
        return (num%10)+sumOfDigits(num=num/10);
    }
    static int ropeCutting(int n,int a, int b, int c){
        if(n==0)
            return 0;
        if(n<0)
            return -1;
        int res = Math.max(ropeCutting(n-a,a,b,c), 
                            Math.max(ropeCutting(n-b,a,b,c), 
                                        ropeCutting(n-c,a,b,c)));
        if(res==-1)
            return -1;
        return res+1;
    }
    static void generateSubSets(String s, String curr, int i){
        if(i==s.length()){
            System.out.print(curr+" ");
            return ;
        }
        generateSubSets(s,curr,i+1);
        generateSubSets(s,curr+s.charAt(i),i+1);
    }
    static void towerOfHanoi(int n, char a, char b, char c){
        if(n==1){
            System.out.println("move 1 disc from "+a+" to "+c);
            return;
        }
        towerOfHanoi(n-1,a,c,b);
        System.out.println("move disc "+n+" from "+a+" to "+c);
        towerOfHanoi(n-1,b,a,c);
    }
    static int josephus(int n, int k){
        if(n==1){
            return 0;
        }
        return (josephus(n-1,k)+k)%n;
    }
    static int subSetSum(int[] arr,int currsum ,int reqsum, int i){
        if(i==0){
            if(reqsum == currsum){
                return 1;
            }
            return 0;
        }
        return subSetSum(arr,currsum,reqsum,i-1) + 
                subSetSum(arr,currsum+arr[i-1],reqsum,i-1);
    }
    static String swap(String str, int i, int j){
        if (j == str.length() - 1)
            return str.substring(0, i) + str.charAt(j)
                + str.substring(i + 1, j) + str.charAt(i);
 
        return str.substring(0, i) + str.charAt(j)
            + str.substring(i + 1, j) + str.charAt(i)
            + str.substring(j + 1, str.length());
    }
    static void permutations(String s, int i){
        if(i==(s.length()-1)){
            System.out.println(s);
            return;
        }
        for(int j=i;j<s.length();j++){
            s=swap(s,i,j);
            permutations(s,i+1);
            s=swap(s,i,j);
        }
    }
	public static void main(String[] args) {
		int num = 2, x = 4, res=1;
		while(x>0){
		    if((x%2)!=0){
		        res = res * num;
		    }
		    x=x/2;
		    num*=num;
		}
		//System.out.println(res);
		//System.out.println(factorialOfN(4));
		//System.out.println(nthFibonnaci(3));
		//System.out.println(palindromeCheck("abcba",0,"abcba".length() -1 ));
		//System.out.println(sumOfDigits(123));
		//System.out.println(ropeCutting(23,12,11,9));
		//generateSubSets("abc","",0);
		//towerOfHanoi(3,'A','B','C');
		//System.out.println(josephus(5,3));
		int[] arr= {10,20,5};
		//System.out.println(subSetSum(arr,0,5,arr.length));
		permutations("ABC",3);
	}
}