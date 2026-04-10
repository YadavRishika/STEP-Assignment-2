import java.util.*;

class Asset{
    String name;
    double returnRate;
    double volatility;

    Asset(String name,double returnRate,double volatility){
        this.name=name;
        this.returnRate=returnRate;
        this.volatility=volatility;
    }

    public String toString(){
        return name+":"+returnRate+"%";
    }
}

public class PortfolioReturnSorting{

    public static void mergeSort(Asset[] assets,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(assets,left,mid);
            mergeSort(assets,mid+1,right);
            merge(assets,left,mid,right);
        }
    }

    public static void merge(Asset[] assets,int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;

        Asset[] L=new Asset[n1];
        Asset[] R=new Asset[n2];

        for(int i=0;i<n1;i++)
            L[i]=assets[left+i];

        for(int j=0;j<n2;j++)
            R[j]=assets[mid+1+j];

        int i=0,j=0,k=left;

        while(i<n1 && j<n2){
            if(L[i].returnRate<=R[j].returnRate){
                assets[k]=L[i];
                i++;
            }else{
                assets[k]=R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            assets[k]=L[i];
            i++;
            k++;
        }

        while(j<n2){
            assets[k]=R[j];
            j++;
            k++;
        }
    }

    public static void quickSort(Asset[] assets,int low,int high){
        if(low<high){
            int pi=partition(assets,low,high);
            quickSort(assets,low,pi-1);
            quickSort(assets,pi+1,high);
        }
    }

    public static int partition(Asset[] assets,int low,int high){
        double pivot=assets[high].returnRate;
        int i=low-1;

        for(int j=low;j<high;j++){
            if(assets[j].returnRate>pivot){
                i++;
                Asset temp=assets[i];
                assets[i]=assets[j];
                assets[j]=temp;
            }
        }

        Asset temp=assets[i+1];
        assets[i+1]=assets[high];
        assets[high]=temp;

        return i+1;
    }

    public static void main(String[] args){

        Asset[] assets={
                new Asset("AAPL",12,5),
                new Asset("TSLA",8,9),
                new Asset("GOOG",15,4)
        };

        Asset[] mergeList=assets.clone();
        Asset[] quickList=assets.clone();

        mergeSort(mergeList,0,mergeList.length-1);
        System.out.println("Merge: "+Arrays.toString(mergeList));

        quickSort(quickList,0,quickList.length-1);
        System.out.println("Quick (desc): "+Arrays.toString(quickList));
    }
}