import java.util.*;

class Transaction{
    String id;
    double fee;
    String timestamp;

    Transaction(String id,double fee,String timestamp){
        this.id=id;
        this.fee=fee;
        this.timestamp=timestamp;
    }

    public String toString(){
        return id+":"+fee+"@"+timestamp;
    }
}

public class TransactionFeeSorting{

    public static void bubbleSort(List<Transaction> transactions){
        int n=transactions.size();
        int passes=0;
        int swaps=0;

        for(int i=0;i<n-1;i++){
            boolean swapped=false;

            for(int j=0;j<n-i-1;j++){
                if(transactions.get(j).fee>transactions.get(j+1).fee){

                    Transaction temp=transactions.get(j);
                    transactions.set(j,transactions.get(j+1));
                    transactions.set(j+1,temp);

                    swaps++;
                    swapped=true;
                }
            }

            passes++;

            if(!swapped){
                break;
            }
        }

        System.out.println("BubbleSort (fees): "+transactions);
        System.out.println("Passes: "+passes+" Swaps: "+swaps);
    }

    public static void insertionSort(List<Transaction> transactions){

        for(int i=1;i<transactions.size();i++){

            Transaction key=transactions.get(i);
            int j=i-1;

            while(j>=0 && (transactions.get(j).fee>key.fee ||
                    (transactions.get(j).fee==key.fee &&
                            transactions.get(j).timestamp.compareTo(key.timestamp)>0))){
                transactions.set(j+1,transactions.get(j));
                j--;
            }

            transactions.set(j+1,key);
        }

        System.out.println("InsertionSort (fee+ts): "+transactions);
    }

    public static void findOutliers(List<Transaction> transactions){

        System.out.print("High-fee outliers: ");
        boolean found=false;

        for(Transaction t:transactions){
            if(t.fee>50){
                System.out.print(t+" ");
                found=true;
            }
        }

        if(!found){
            System.out.print("none");
        }

        System.out.println();
    }

    public static void main(String[] args){

        List<Transaction> transactions=new ArrayList<>();

        transactions.add(new Transaction("id1",10.5,"10:00"));
        transactions.add(new Transaction("id2",25.0,"09:30"));
        transactions.add(new Transaction("id3",5.0,"10:15"));

        List<Transaction> bubbleList=new ArrayList<>(transactions);
        List<Transaction> insertionList=new ArrayList<>(transactions);

        bubbleSort(bubbleList);
        insertionSort(insertionList);
        findOutliers(transactions);
    }
}