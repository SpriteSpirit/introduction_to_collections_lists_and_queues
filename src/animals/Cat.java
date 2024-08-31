package animals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cat extends Pet implements Trained {
    private static int count;

    public static int getCount() {
        return count;
    }

    public static class Breed {
        public enum HairType {BALD, SHORT, MEDIUM, LONG}

        private final String name;
        private final String country;
        private final HairType hairType;

        public Breed(
            String name,
            String country,
            HairType hairType
        ) {
            this.name = name;
            this.country = country;
            this.hairType = hairType;
        }

        public String getName() {
            return name;
        }

        public String getCountry() {
            return country;
        }

        public HairType getHairType() {
            return hairType;
        }
    }

    public class FavToy {
        private String name;
        private String type;

        public FavToy(
            String name,
            String type
        ) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getCatName() {
            return Cat.this.getName();
        }
    }

    private FavToy toy;
    private List<Pet> friends;
    private Breed breed;

    public Cat(String name) {
        this(name, 0);
    }

    public Cat(int birthYear) {
        this("Кот", birthYear);
    }

    public Cat(String name, int age) {
       super(name, age);

        friends = new LinkedList<>();
        count++;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        if (this.breed == null) {
            this.breed = breed;
        }
    }

    public void meow() {
        System.out.println("Мяу!");
        System.out.println("Меня зовут " + getName());
        System.out.println("Мне " + getAge() + " лет");
    }

    @Override
    public void eat() {
        System.out.println("Насыпают кошачий корм в миску");
        System.out.println("Ем корм");
        System.out.println("Пью воду");
    }

    public List<Pet> getFriends() {
        return friends;
    }

//    public void addFriends(Pet friend) {
//        this.friends.add(friend);
//        System.out.println(getName() + " подружился с " + friend.getName());
//    }

    public void removeFriend(Pet oldFriend) {
        friends.remove(oldFriend);
    }

    public FavToy getToy() {
        return toy;
    }

    public void setToy(FavToy toy) {
        this.toy = toy;
    }

    @Override
    public String toString() {
        return "Cat Name " + getName();
    }

    @Override
    public TrainedCommand[] getTrainedCommands() {
        return new TrainedCommand[0];
    }

    @Override
    public TrainedCommand[] getAllCommands() {
        return new TrainedCommand[0];
    }

    @Override
    public void train(TrainedCommand command) {

    }

    @Override
    public void doCommand(TrainedCommand command) {

    }
}
