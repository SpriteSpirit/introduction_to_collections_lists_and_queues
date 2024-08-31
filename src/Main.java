import animals.*;
import exception.CantTalkException;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Cat begemot = new Cat("Бегемот", 1);
        Cat murzik = new Cat("Мурзик", 5);
        Dog sharik = new Dog("Шарик", 2005);
        Dog cerber = new Dog("Цербер", 100500);
        Parrot kesha = new Parrot("Кеша", 2);

        // Заменили метод addFriends на геттер и добавление элемента списка
        murzik.getFriends().add(0, begemot);
        murzik.getFriends().add(sharik);
        murzik.getFriends().add(kesha);

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

        System.out.println(murzik.getFriends().size());

        for (int i = 0; i < murzik.getFriends().size(); i++) {
            System.out.println(murzik.getFriends().get(i).getName().toUpperCase());
        }

        System.out.println("Мурзик дружит с Бегемотом ? " + (murzik.getFriends().contains(begemot) ? "Да" : "Нет"));
        System.out.println("Мурзик дружит с Шариком ? " + (murzik.getFriends().contains(sharik) ? "Да" : "Нет"));
        System.out.println("Мурзик дружит с Цербером ? " + (murzik.getFriends().contains(cerber) ? "Да" : "Нет"));

//        talk(sharik, murzik, kesha);
        Pattern pattern = Pattern.compile("^([a-z0-9_.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})$", Pattern.CASE_INSENSITIVE);
        System.out.println(pattern.matcher("test@example.com").matches());

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
            for (TrainedCommand ignored : animal.getTrainedCommands()) {
                animal.doCommand(ignored);
            }
        }
    }
}
