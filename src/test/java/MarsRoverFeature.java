import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverFeature {

    @Test
    void
    move_and_turn_when_given_commands() {
        CommandParser commandParser = new CommandParser();
        MarsRover marsRover = new MarsRover();
        MarsRoverAPI marsRoverAPI = new MarsRoverAPI(commandParser, marsRover);
        marsRoverAPI.execute("MRM");

        assertEquals("1:1:E",  marsRoverAPI.getCoordinates() );

    }

}
