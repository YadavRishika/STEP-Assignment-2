import java.util.*;

public class AccountIdLookup {

    public static int linearFirst(String[] logs,String target){
        int comparisons=0;

        for(int i=0;i<logs.length;i++){
            comparisons++;
            if(logs[i].equals(target)){
                System.out.println("Linear first "+target+": index "+i+" ("+comparisons+" comparisons)");
                return i;
            }
        }

        System.out.println("Not found");
        return -1;
    }

    public static int linearLast(String[] logs,String target){
        int comparisons=0;
        int index=-1;

        for(int i=0;i<logs.length;i++){
            comparisons++;
            if(logs[i].equals(target)){
                index=i;
            }
        }

        if(index!=-1)
            System.out.println("Linear last "+target+": index "+index+" ("+comparisons+" comparisons)");

        return index;
    }

    public static int binarySearch(String[] arr,String target){
        int low=0;
        int high=arr.length-1;
        int comparisons=0;

        while(low<=high){
            comparisons++;
            int mid=(low+high)/2;

            if(arr[mid].equals(target)){
                System.out.println("Binary "+target+": index "+mid+" ("+comparisons+" comparisons)");
                return mid;
            }
            else if(arr[mid].compareTo(target)<0){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return -1;
    }

    public static int countOccurrences(String[] arr,String target){
        int count=0;

        for(String s:arr){
            if(s.equals(target))
                count++;
        }

        return count;
    }

    public static void main(String[] args){

        String[] logs={"accB","accA","accB","accC"};

        Arrays.sort(logs);

        System.out.println("Sorted logs: "+Arrays.toString(logs));

        linearFirst(logs,"accB");
        linearLast(logs,"accB");

        int index=binarySearch(logs,"accB");

        int count=countOccurrences(logs,"accB");

        System.out.println("Count="+count);
    }
}