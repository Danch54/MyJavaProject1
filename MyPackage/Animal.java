package MyPackage;

public class Animal {
    String name;
    String sound;

    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    void speak() {
        System.out.println(name + " зовут. Он говорит: " + sound);
    }
}