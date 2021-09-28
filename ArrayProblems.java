class ArrayProblems{
    public static void main(String[] args) {
        int[] arr = {2,3,5,8,46,46,8};
        //System.out.println(largestElementInArray(arr));
        //System.out.println(secondLargestElementInArray(arr));
        int arr1[] = {5, 12, 12, 15, 35};
        //System.out.println(checkIfArrayIsSorted(arr1));
        //reverseAnArray(arr1);
        int[] arr2 = {0,1,1,2,2,2,3};
        //removeDuplicatesFromSortedArray(arr2);
        int[] arr3 = {1,0,1,0,0,2,3};
        //moveZerosToEnd(arr3);
        //leftRotateArrayByDPlaces(arr3,3);
        int[] arr4 = {1,2,3,2,0,6,0,10,4,2,1};
        //leadersOfAnArray(arr4);
        //maximumDifference(arr4);
        int[] arr5 = {10,10,10,30,40,50,50};
        //printFrequenciesInSortedArray(arr5);
        int[] price = {1,5,3,8,12};
        //System.out.println(stockBuyAndSell(price));
        int[] water = {5,0,6,2,3};
        //System.out.println(trappingRainWater(water));
        int[] arr6 = {1,1,0,1,1,1,1,0,0,1};
        //System.out.println(findMaxConsecutive1s(arr6));
        int[] arr7 = {5,1,2,-6,-8,2};
        //System.out.print(maxSubArraySum(arr7));
        int[] arr8 = {1,2,3,4,5,7,8,9,10,12};
        System.out.println(maxEvenOdd(arr8));
    }

    public static int largestElementInArray(int[] arr){
        int largest = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>largest)
                largest = arr[i];
        }
        return largest;
    }

    public static int secondLargestElementInArray(int[] arr){
        int largest = 0;
        int secondlargest = -1 ;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[largest]){
                secondlargest = largest;
                largest = i;
            }
            else if(arr[i] != arr[largest]){
                if(secondlargest != -1 || arr[i] > arr[secondlargest])
                    secondlargest = i;
            }
        }
        return secondlargest;
    }

    public static boolean checkIfArrayIsSorted(int[] arr) {
        int j;
        for(int i = 0;i<arr.length - 1; i++){
            j=i+1;
            if(arr[j] < arr[i] )
                return false;
        } 
        return true;
    }

    public static void reverseAnArray(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        int temp;
        while(i<j){
            temp  = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        for(int k:arr)
            System.out.print(k+" ");
    }

    public static void removeDuplicatesFromSortedArray(int[] arr){
        int res = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[res-1] != arr[i]){
                arr[res] = arr[i];
                res++;
            }
        }
        for(int i=0;i<res;i++)
            System.out.print(i+" ");
    }

    public static void moveZerosToEnd(int[] arr){
        int n = arr.length;
        int count = 0;
        for(int i=0;i <n; i++){
            if(arr[i]!=0){
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;
                count++;
            }
        }

        for(int i:arr)
            System.out.print(i + " ");
    }

    public static void leftRotateArrayByDPlaces(int[] arr, int d){
        reverseArray(arr,0,d-1);
        reverseArray(arr,d,arr.length-1);
        reverseArray(arr,0,arr.length-1);
        for(int i:arr)
            System.out.print(i + " ");

    }
    public static void reverseArray(int[] arr,int low, int high ){
        while(low < high){
            int temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            low++;
            high--;
        }
    }

    public static void leadersOfAnArray(int[] arr){
        //An element is a leader if all the elements right of it are less than it
        int n=arr.length;
        int currentleader = arr[n-2];
        System.out.print(arr[n-1]+" ");
        for(int i = n-2;i>=0;i--){
            if(currentleader<arr[i])
            {
                System.out.print(arr[i]+" ");
                currentleader = arr[i];
            }
        }
    }

    public static void maximumDifference(int[] arr){
        //max value of arr[j]-arr[i] aych that j>i
        int minval = arr[0];
        int res = arr[1] - arr[0];
        for(int i=2;i<arr.length;i++){
            minval = Math.min(minval,arr[i]);
            res = Math.max(res, arr[i] - arr[minval]);
        }
        System.out.print(res);
    }

    public static void printFrequenciesInSortedArray(int[] arr){
        int freq = 1, element = arr[0];
        for(int i = 1; i <arr.length; i++){
            if(arr[i] == arr[i-1]){
                freq++;
            }
            else{
                System.out.println(element+" "+freq);
                element = arr[i];
                freq = 1;
            }
        }
        System.out.println(element+" "+freq);
    }

    public static int stockBuyAndSell(int[] price){
        int profit = 0;
        for(int i = 1;i<price.length; i++){
            if(price[i]>price[i-1]){
                profit += (price[i]-price[i-1]);
            }
        }
        return profit;
    }

    public static int trappingRainWater(int[] arr){
        int n=arr.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = arr[0];
        rmax[n-1] = arr[n-1];
        for(int i=1; i<n; i++)
            lmax[i] = Math.max(lmax[i-1],arr[i]);
        for(int i = n-2; i>=0;i--)
            rmax[i] = Math.max(rmax[i+1],arr[i]);
        int res = 0;
        for(int i=1; i<n; i++){
            res+=(Math.min(lmax[i],rmax[i])-arr[i]);
        }
        return res;
    }

    public static int findMaxConsecutive1s(int[] arr){      
        int res = 0, current = 0;
        for(int i = 0;i<arr.length; i++){
            if(arr[i] == 0)
                current = 0;
            else{
                current++;
                res = Math.max(res, current);
            }
        }
        return res;
    }

    public static int maxSubArraySum(int[] arr){
        int maxending = arr[0], res = arr[0];
        for(int i = 1; i<arr.length; i++){
            maxending = Math.max(maxending+arr[i],arr[i]);
            res = Math.max(res,maxending);
        }
        return res;
    }

    public static int maxEvenOdd(int[] arr){
        int curr = 1, res = 1;
        for(int i=1; i<arr.length; i++){
            if((arr[i]%2==0 && arr[i-1]%2!=0) || (arr[i]%2!=0 && arr[i-1]%2==0)){
                curr++;
                res = Math.max(res,curr);
            }
            else
                curr = 1;
        }
        return res;
    }

    
}