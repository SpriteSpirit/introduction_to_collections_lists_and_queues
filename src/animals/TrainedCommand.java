package animals;

public enum TrainedCommand {
    CMD_SIT("Сидеть!"),
    CMD_VOICE("Голос!"),
    CMD_FETCH("Аппорт!"),
    CMD_LIE_DOWN("Лежать!");

    private final String voiceCommand;

    TrainedCommand(String voiceCommand) {
        this.voiceCommand = voiceCommand;
    }

    public static TrainedCommand findByVoiceCommand(String voiceCommand) {
        for (TrainedCommand command : values()) {
            if (command.getVoiceCommand().equals(voiceCommand)) {
                return command;
            }
        }

        return null;
    }

    public String getVoiceCommand() {
        return voiceCommand;
    }
}
