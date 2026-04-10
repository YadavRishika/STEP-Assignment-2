import java.util.*;

class Trade{
    String name;
    int volume;

    Trade(String name,int volume){
        this.name=name;
        this.volume=volume;
    }

    public String toString(){
        return name+":"+volume;
    }
}

public class TradeVolumeAnalysis{

    public static void mergeSort(Trade[] trades,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(trades,left,mid);
            mergeSort(trades,mid+1,right);
            merge(trades,left,mid,right);
        }
    }

    public static void merge(Trade[] trades,int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;

        Trade[] L=new Trade[n1];
        Trade[] R=new Trade[n2];

        for(int i=0;i<n1;i++)
            L[i]=trades[left+i];

        for(int j=0;j<n2;j++)
            R[j]=trades[mid+1+j];

        int i=0,j=0,k=left;

        while(i<n1 && j<n2){
            if(L[i].volume<=R[j].volume){
                trades[k]=L[i];
                i++;
            }else{
                trades[k]=R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            trades[k]=L[i];
            i++;
            k++;
        }

        while(j<n2){
            trades[k]=R[j];
            j++;
            k++;
        }
    }

    public static void quickSortDesc(Trade[] trades,int low,int high){
        if(low<high){
            int pi=partition(trades,low,high);
            quickSortDesc(trades,low,pi-1);
            quickSortDesc(trades,pi+1,high);
        }
    }

    public static int partition(Trade[] trades,int low,int high){
        int pivot=trades[high].volume;
        int i=low-1;

        for(int j=low;j<high;j++){
            if(trades[j].volume>pivot){
                i++;
                Trade temp=trades[i];
                trades[i]=trades[j];
                trades[j]=temp;
            }
        }

        Trade temp=trades[i+1];
        trades[i+1]=trades[high];
        trades[high]=temp;

        return i+1;
    }

    public static Trade[] mergeLists(Trade[] a,Trade[] b){
        Trade[] merged=new Trade[a.length+b.length];

        int i=0,j=0,k=0;

        while(i<a.length && j<b.length){
            if(a[i].volume<=b[j].volume){
                merged[k++]=a[i++];
            }else{
                merged[k++]=b[j++];
            }
        }

        while(i<a.length)
            merged[k++]=a[i++];

        while(j<b.length)
            merged[k++]=b[j++];

        return merged;
    }

    public static int totalVolume(Trade[] trades){
        int sum=0;
        for(Trade t:trades)
            sum+=t.volume;
        return sum;
    }

    public static void main(String[] args){

        Trade[] trades={
                new Trade("trade3",500),
                new Trade("trade1",100),
                new Trade("trade2",300)
        };

        Trade[] mergeList=trades.clone();
        Trade[] quickList=trades.clone();

        mergeSort(mergeList,0,mergeList.length-1);
        System.out.println("MergeSort: "+Arrays.toString(mergeList));

        quickSortDesc(quickList,0,quickList.length-1);
        System.out.println("QuickSort (desc): "+Arrays.toString(quickList));

        Trade[] morning={
                new Trade("m1",200),
                new Trade("m2",400)
        };

        Trade[] afternoon={
                new Trade("a1",100),
                new Trade("a2",200)
        };

        Trade[] merged=mergeLists(morning,afternoon);

        int total=totalVolume(merged);

        System.out.println("Merged morning+afternoon total: "+total);
    }
}