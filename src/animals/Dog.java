package animals;

import exception.CantTalkException;

public class Dog extends Pet implements Trained {
    private final TrainedCommand[] trainedCommands = new TrainedCommand[TrainedCommand.values().length];

    public Dog(String name) {
        this(name, 0);
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("Насыпают собачий корм в миску");
        System.out.println("Дают команду");
        System.out.println("Ем корм");
        System.out.println("Пью воду");
    }

    @Override
    public String toString() {
        return "Dog Name " + getName();
    }

    @Override
    public TrainedCommand[] getTrainedCommands() {
        return trainedCommands;
    }

    @Override
    public TrainedCommand[] getAllCommands() {
        return TrainedCommand.values();
    }

    @Override
    public void train(TrainedCommand command) {
        for (int i = 0; i < trainedCommands.length; i++) {
            boolean isEmpty = trainedCommands[i] == null;

            if (!isEmpty && trainedCommands[i] == command) {
                break;
            }

            if (isEmpty) {
                trainedCommands[i] = command;
                break;
            }
        }
    }

    @Override
    public void doCommand(TrainedCommand command) {
        System.out.println("Выполняю команду " + command);

        switch (command) {
            case CMD_SIT:
                System.out.println("Собака садится на пол");
                break;
            case CMD_VOICE:
                try {
                    talk();
                } catch (CantTalkException e) {
                    throw new RuntimeException(e);
                }
                break;
            case CMD_FETCH:
                System.out.println("Собака побежала за палкой");
                System.out.println("Собака принесла палку");
                break;
            case CMD_LIE_DOWN:
                System.out.println("Собака легла на пол");
            default:
                System.out.println("Нет такой команды!");
        }
    }
}
