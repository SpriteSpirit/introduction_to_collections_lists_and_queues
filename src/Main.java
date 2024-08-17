import animals.*;
import exception.CantTalkException;

public class Main {
    public static void main(String[] args) {
        Cat begemot = new Cat("Бегемот", 1);
        Cat murzik = new Cat("Мурзик", 5);
        Dog sharik = new Dog("Шарик", 2005);
        Dog cerber = new Dog("Цербер", 100500);
        Parrot kesha = new Parrot("Кеша", 2);

        murzik.addFriends(begemot);
        murzik.addFriends(sharik);
        murzik.addFriends(kesha);

        for (Pet friend : murzik.getFriends()) {
            if (friend instanceof Cat) {
                Cat cat = (Cat) friend;
                cat.meow();
            } else if (friend instanceof Parrot) {
                try {
                    ((Parrot) friend).talk();
                } catch (CantTalkException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println(friend);
            }
        }

        murzik.removeFriend(sharik);

        for (int i = 0; i < murzik.getFriends().size(); i++) {
            System.out.println(murzik.getFriends().get(i).getName().toUpperCase());
        }

        System.out.println("Мурзик дружит с Бегемотом ? " + (murzik.getFriends().contains(begemot) ? "Да" : "Нет"));
        System.out.println("Мурзик дружит с Шариком ? " + (murzik.getFriends().contains(sharik) ? "Да" : "Нет"));
        System.out.println("Мурзик дружит с Цербером ? " + (murzik.getFriends().contains(cerber) ? "Да" : "Нет"));
    }

    public static void talk(Pet... pets) {
        for (Pet pet : pets) {
            try {
                pet.talk();
            } catch (CantTalkException e) {
                System.out.println("Произошла ошибка с животным " + e.getPet().getName());
                System.out.println(e.getMessage());
            }
        }
    }

    public static void checkTrained(Trained... animals) {
        for (Trained animal : animals) {
            for (TrainedCommand trainedCommand : animal.getTrainedCommands()) {
                animal.doCommand(trainedCommand);
            }
        }
    }
}
