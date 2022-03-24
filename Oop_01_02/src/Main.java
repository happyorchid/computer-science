class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.bark();
        myDog.sit();
    }
}

class Dog {
    public void bark(){
        System.out.println("Woof! Woof!");
    }

    public void sit(){
        System.out.println("Spot, sit");
    }
}