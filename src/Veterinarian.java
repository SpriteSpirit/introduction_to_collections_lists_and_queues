import animals.Pet;

import java.util.LinkedList;
import java.util.Queue;

public class Veterinarian<T extends Pet> {
    private String name;
    private String specialization;
    private Queue<T> queue = new LinkedList<>();

    public void addPatient(T pet) {
        queue.offer(pet);
    }

    public void treat() {
        T pet = queue.poll();

        if (pet != null) {
            System.out.println("Доктор " + name + " лечит животное: "  + pet);
        }
    }

    public int queueSize() {
        return queue.size();
    }
}
