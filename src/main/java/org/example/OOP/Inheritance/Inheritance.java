package org.example.OOP.Inheritance;

interface Swimmer {
    void swim();
}

abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    public abstract void makeSound();
}

class Dolphin extends Animal implements Swimmer {
    public Dolphin(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " clicks and whistles");
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming gracefully");
    }

    public void jump() {
        System.out.println(name + " jumps out of the water!");
    }
}

class BabyDolphin extends Dolphin {
    public BabyDolphin(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println(name + " also makes baby noises");
    }
}

public class Main {
    public static void main(String[] args) {

        Animal myAnimal = new Dolphin("Flipper");
        myAnimal.makeSound();
        myAnimal.sleep();

        Swimmer swimmer = new Dolphin("Dolly");
        swimmer.swim();

        BabyDolphin baby = new BabyDolphin("Little Fin");
        baby.makeSound();
        baby.jump();
        baby.swim();
    }
}

/*

Output:
Flipper clicks and whistles // myAnimal.makeSound() (polymorphism)
Flipper is sleeping // myAnimal.sleep() (inherited from Animal)

Dolly is swimming gracefully // swimmer.swim() (via Swimmer interface)

Little Fin clicks and whistles // baby.makeSound() (1st part - super call)
Little Fin also makes baby noises // baby.makeSound() (2nd part - override)
Little Fin jumps out of the water! // baby.jump() (inherited from Dolphin)
Little Fin is swimming gracefully // baby.swim() (inherited from interface)

*/