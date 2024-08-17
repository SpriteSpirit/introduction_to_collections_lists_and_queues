import animals.Trained;
import animals.TrainedCommand;

//public class Trainer<A extends Trained, B extends Pet & Trained> {
public class Trainer<A extends Trained> {
    private String name;
    private String grade;
//    private B animal;
    private A animal;

    public Trainer(String name) {
        this.name = name;
    }

//    public Trainer(String name, B animal) {
//        this.name = name;
//        this.animal = animal;
//    }

    public Trainer(String name, A animal) {
        this.name = name;
        this.animal = animal;
    }

    public void train(A pet) {
//        System.out.println("Начинаю тренировать [" + pet.getName() + "]");

        for (TrainedCommand command : pet.getAllCommands()) {
            System.out.println("Обучаю команде " + command);
            pet.train(command);
        }

//        System.out.println("Заканчиваю тренировать [" + pet.getName() + "]");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
