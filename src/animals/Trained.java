package animals;

public interface Trained {
    TrainedCommand[] getTrainedCommands();

    TrainedCommand[] getAllCommands();

    void train(TrainedCommand command);

    void doCommand(TrainedCommand command);
}
