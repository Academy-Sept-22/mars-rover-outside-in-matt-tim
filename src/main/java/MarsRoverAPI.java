import java.util.List;

public class MarsRoverAPI {
    private final CommandParser commandParser;
    private final MarsRover marsRover;

    public MarsRoverAPI(CommandParser commandParser, MarsRover marsRover) {
        this.commandParser = commandParser;
        this.marsRover = marsRover;
    }

    public void execute(String commands) {
        List<Commands> instructions = commandParser.buildInstructions(commands);
        marsRover.execute(instructions);
    }

    public String getCoordinates() {
        throw new UnsupportedOperationException();
    }

}
