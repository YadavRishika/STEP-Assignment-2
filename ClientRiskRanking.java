import java.util.*;

class Client{
    String name;
    int riskScore;
    double accountBalance;

    Client(String name,int riskScore,double accountBalance){
        this.name=name;
        this.riskScore=riskScore;
        this.accountBalance=accountBalance;
    }

    public String toString(){
        return name+":"+riskScore;
    }
}

public class ClientRiskRanking{

    public static void bubbleSort(Client[] clients){
        int n=clients.length;
        int swaps=0;

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(clients[j].riskScore>clients[j+1].riskScore){
                    Client temp=clients[j];
                    clients[j]=clients[j+1];
                    clients[j+1]=temp;
                    swaps++;
                }
            }
        }

        System.out.println("Bubble (asc): "+Arrays.toString(clients));
        System.out.println("Swaps: "+swaps);
    }

    public static void insertionSort(Client[] clients){

        for(int i=1;i<clients.length;i++){

            Client key=clients[i];
            int j=i-1;

            while(j>=0 && (clients[j].riskScore<key.riskScore ||
                    (clients[j].riskScore==key.riskScore &&
                     clients[j].accountBalance<key.accountBalance))){
                clients[j+1]=clients[j];
                j--;
            }

            clients[j+1]=key;
        }

        System.out.println("Insertion (desc): "+Arrays.toString(clients));
    }

    public static void topRisks(Client[] clients,int k){

        System.out.print("Top "+k+" risks: ");

        for(int i=0;i<k && i<clients.length;i++){
            System.out.print(clients[i].name+"("+clients[i].riskScore+")");
            if(i<k-1 && i<clients.length-1){
                System.out.print(", ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args){

        Client[] clients={
                new Client("clientC",80,2000),
                new Client("clientA",20,5000),
                new Client("clientB",50,3000)
        };

        Client[] bubbleList=clients.clone();
        Client[] insertionList=clients.clone();

        bubbleSort(bubbleList);

        insertionSort(insertionList);

        topRisks(insertionList,3);
    }
}