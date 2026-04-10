import java.util.*;

public class RiskThresholdLookup {

    public static void linearSearch(int[] risks,int target){

        int comparisons=0;
        boolean found=false;

        for(int i=0;i<risks.length;i++){
            comparisons++;
            if(risks[i]==target){
                System.out.println("Linear: threshold="+target+" found at index "+i+" ("+comparisons+" comps)");
                found=true;
                break;
            }
        }

        if(!found)
            System.out.println("Linear: threshold="+target+" -> not found ("+comparisons+" comps)");
    }

    public static void binaryFloorCeiling(int[] risks,int target){

        int low=0;
        int high=risks.length-1;
        int comparisons=0;

        int floor=-1;
        int ceiling=-1;

        while(low<=high){

            comparisons++;

            int mid=(low+high)/2;

            if(risks[mid]==target){
                floor=risks[mid];
                ceiling=risks[mid];
                break;
            }

            if(risks[mid]<target){
                floor=risks[mid];
                low=mid+1;
            }else{
                ceiling=risks[mid];
                high=mid-1;
            }
        }

        System.out.println("Binary floor("+target+"): "+floor+", ceiling: "+ceiling+" ("+comparisons+" comps)");
    }

    public static void main(String[] args){

        int[] risks={10,25,50,100};

        System.out.println("Sorted risks: "+Arrays.toString(risks));

        linearSearch(risks,30);

        binaryFloorCeiling(risks,30);
    }
}