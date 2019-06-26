package xin.shenheng.demo08;

public class Demo01Instanceof {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();


        if(animal instanceof  Cat) {
            Cat cat = (Cat) animal;
            cat.method();
        }
        if(animal instanceof  Dog) {
            Dog dog = (Dog) animal;
            dog.method();
        }
        //
    }
}
