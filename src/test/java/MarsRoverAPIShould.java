import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MarsRoverAPIShould {

    private CommandParserStub commandParserStub;
    private MarsRoverSpy marsRoverSpy;
    private GPSReaderMock gpsReaderMock;

    @Test
    void execute() {
        String commandString = "L";
        List<Commands> instructions = List.of(Commands.LEFT);
        commandParserStub = new CommandParserStub(instructions);
        marsRoverSpy = new MarsRoverSpy();
        MarsRoverAPI marsRoverAPI = new MarsRoverAPI(commandParserStub, marsRoverSpy, gpsReaderMock);

        marsRoverAPI.execute(commandString);

        //verify(marsRover).execute(instructions);
        marsRoverSpy.verifyCalledTimes(1);
    }
    @Test
    void collects_location_and_converts_to_coordinates() {
        String coordinate = "0:0:N";
        RoverLocation roverLocation = new RoverLocation(0, 0, "N");

        //given(marsRover.collectLocation()).willReturn(roverLocation);
        MarsRoverStub marsRoverStub = new MarsRoverStub(roverLocation);

        //given(gPSReader.parse(roverLocation)).willReturn(coordinate);
        gpsReaderMock = new GPSReaderMock(coordinate, roverLocation);

        MarsRoverAPI marsRoverAPI = new MarsRoverAPI(commandParserStub, marsRoverStub, gpsReaderMock);

        String result = marsRoverAPI.getCoordinates();

        gpsReaderMock.verifyCalledTimes(1);
        //verify(gPSReader).parse(roverLocation);

        assertEquals(result, coordinate);
    }

}