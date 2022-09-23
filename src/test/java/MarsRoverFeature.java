import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverFeature {

    @Test
    void
    move_and_turn_when_given_commands() {
        CommandParser commandParser = new CommandParser();
        RoverEngine engine = new RoverEngine();
        SteeringWheel steeringWheel = new SteeringWheel();
        MarsRover marsRover = new MarsRover(engine, steeringWheel);
        GPSReader gPSReader = new GPSReader();

        MarsRoverAPI marsRoverAPI = new MarsRoverAPI(commandParser, marsRover, gPSReader);
        marsRoverAPI.execute("MRM");

        assertEquals("1:1:E",  marsRoverAPI.getCoordinates() );

    }

}
