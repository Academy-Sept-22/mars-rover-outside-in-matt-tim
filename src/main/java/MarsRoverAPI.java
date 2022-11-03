import java.util.List;

public class MarsRoverAPI {
    private final CommandParser commandParser;
    private final MarsRover marsRover;
    private GPSReader gPSReader;

    public MarsRoverAPI(CommandParser commandParser, MarsRover marsRover, GPSReader gPSReader) {
        this.commandParser = commandParser;
        this.marsRover = marsRover;
        this.gPSReader = gPSReader;
    }

    public void execute(String commands) {
        List<Commands> instructions = commandParser.buildInstructions(commands);
        marsRover.execute(instructions);
    }

    public String getCoordinates() throws Exception {
        RoverLocation location = marsRover.collectLocation();
        return gPSReader.parse(location);
    }

}
