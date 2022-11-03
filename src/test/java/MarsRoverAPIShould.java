import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

class MarsRoverAPIShould {
    @Mock CommandParser commandParser;
    @Mock MarsRover marsRover;

    @Mock
    GPSReader gPSReader;
    @Test
    void execute() {
//        Create stub
        List<Commands> instructions = List.of(Commands.LEFT);
        CommandParserStub commandParserStub = new CommandParserStub(instructions);

//        Implement stub
        MarsRoverAPI marsRoverAPI = new MarsRoverAPI(commandParserStub, marsRover, gPSReader);

        String commandString = "L";
        marsRoverAPI.execute(commandString);

        verify(marsRover).execute(instructions);
    }
    @Test
    void collects_location_and_converts_to_coordinates() {
        String coordinate = "0:0:N";
        RoverLocation roverLocation = new RoverLocation(0, 0, "N");

        given(marsRover.collectLocation()).willReturn(roverLocation);
        given(gPSReader.parse(roverLocation)).willReturn(coordinate);

        MarsRoverAPI marsRoverAPI = new MarsRoverAPI(commandParser, marsRover, gPSReader);

        String result = marsRoverAPI.getCoordinates();

        verify(gPSReader).parse(roverLocation);
        assertEquals(result, coordinate);
    }

}