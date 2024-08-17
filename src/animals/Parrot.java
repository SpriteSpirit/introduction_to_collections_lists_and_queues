package animals;

import exception.CantTalkException;

public class Parrot extends Pet {
    private boolean talking;
    private String breed;

    public Parrot(String name) {
        super(name, 0);
    }

    public Parrot(String name, int age) {
        super(name, age);
    }

    @Override
    public String getName() {
        return super.getName().toUpperCase();
    }

    public void talk() throws CantTalkException {
        super.talk();
        System.out.println("Hello!");
    }

    public void talk(String word) throws CantTalkException {
        System.out.println(word);
        talk();
    }

    public void talk(String... words) throws CantTalkException {
        talk();
        for (String word : words) {
            System.out.println(word);
        }
    }

    @Override
    public void eat() {
        System.out.println("Ем корм из кормушки");
    }

    public boolean isTalking() {
        return talking;
    }

    public void setTalking(boolean talking) {
        this.talking = talking;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
