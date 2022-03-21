import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Wallet wallet = new Wallet();

        while (true){
            Scanner input = new Scanner(System.in);
            System.out.print("\n\nSelect an option:\n1. Enter coin to add\n2. Display number of coins\n3. Remove coin\n");
            int option = (Integer.parseInt(input.nextLine()));

            if (option == 1){
                System.out.print("\nEnter the coin name (Nickel, Dime, Quarter, Loonie, Toonie): ");
                String enterCoinName = input.nextLine();
                Coin enteredCoin = new Coin(enterCoinName);
                wallet.addCoin(enteredCoin);
                System.out.print("You added a " + enterCoinName + "." + " Its value is $" + enteredCoin.getValue() + ".");

            }
            else if (option == 2){
                wallet.displayCoins();
            }

            else if (option == 3){
                System.out.print("Enter coin name to remove: ");
                String coinToRemove = input.nextLine();

                System.out.print("Enter amount of coins to remove: ");
                int coinRemoveAmount = (Integer.parseInt(input.nextLine()));
                wallet.removeCoins(coinToRemove, coinRemoveAmount);
            }
            else {
                System.out.print("Goodbye");
                break;
            }
        }
    }
}

class Coin {
    private String coinName;
    private double value;

    public Coin(String coinName){
        if (coinName.equals("Nickel")){
            this.coinName = "Nickel";
            this.value = 0.05;
        }
        else if (coinName.equals("Dime")){
            this.coinName = "Dime";
            this.value = 0.10;
        }
        else if (coinName.equals("Quarter")){
            this.coinName = "Quarter";
            this.value = 0.25;
        }
        else if (coinName.equals("Loonie")){
            this.coinName = "Loonie";
            this.value = 1.00;
        }
        else if (coinName.equals("Toonie")){
            this.coinName = "Toonie";
            this.value = 2.00;
        }
        else {
            this.value = 0.00;
        }
    }

    public void setCoin(String coinName, double value){
        this.coinName = coinName;
        this.value = value;
    }

    public String getCoinName(){
        return coinName;
    }

    public double getValue(){
        return value;
    }
}





class Wallet {
    ArrayList<Coin> alCoin = new ArrayList<>();
    private int totalNickels = 0;
    private int totalDimes = 0;
    private int totalQuarters = 0;
    private int totalLoonies = 0;
    private int totalToonies = 0;
    private double sum = 0.0;

    public void addCoin(Coin coin){
        this.alCoin.add(coin);
    }

    public void eachCoinsTotal(){
        totalNickels = 0;
        totalDimes = 0;
        totalQuarters = 0;
        totalLoonies = 0;
        totalToonies = 0;

        for (int i = 0; i < alCoin.size(); i++){
            if (alCoin.get(i).getCoinName().equals("Nickel")){
                this.totalNickels = this.totalNickels+1;
            }
            else if (alCoin.get(i).getCoinName().equals("Dime")){
                this.totalDimes = this.totalDimes+1;
            }
            else if (alCoin.get(i).getCoinName().equals("Quarter")){
                this.totalQuarters = this.totalQuarters+1;
            }
            else if (alCoin.get(i).getCoinName().equals("Loonie")){
                this.totalLoonies = this.totalLoonies+1;
            }
            else if (alCoin.get(i).getCoinName().equals("Toonie")){
                this.totalToonies = this.totalToonies+1;
            }
        }
    }

    public void totalValue(){
        this.sum = 0;
        for (int i = 0; i < alCoin.size(); i++){
            this.sum = sum+alCoin.get(i).getValue();
        }
    }

    public void removeCoins(String coinName, int howMany){
        int countCoins = 0;
        for (int i = alCoin.size()-1; i >= 0; i--){
            if (alCoin.get(i).getCoinName().equals(coinName)){
                if (countCoins < howMany){
                    countCoins = countCoins+1;
                }
                else {
                    break;
                }
                alCoin.remove(i);
            }
        }
        displayCoins();
    }

    public void displayCoins(){
        totalValue();
        eachCoinsTotal();
        System.out.print("Nickels: " + this.totalNickels + "\nDimes: " + this.totalDimes + "\nQuarters: " + totalQuarters + "\nLoonies: " + totalLoonies + "\nToonies: " + totalToonies);
        System.out.print("\n\nTotal Money: $" + sum);
    }
}