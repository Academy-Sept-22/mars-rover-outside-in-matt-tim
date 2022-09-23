public class MarsRoverAPI {
    private CommandParser commandParser;

    public MarsRoverAPI(CommandParser commandParser, MarsRover marsRover) {
        this.commandParser = commandParser;
    }

    public void execute(String commands) {
        throw new UnsupportedOperationException();
    }

    public String getCoordinates() {
        throw new UnsupportedOperationException();
    }

}
