import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

class MarsRoverAPIShould {
    @Mock CommandParser commandParser;
    @Mock MarsRover marsRover;
    @Test
    void execute() {
        String commandString = "L";
        List<Commands> instructions = List.of(Commands.LEFT);
        given(commandParser.buildInstructions(commandString)).willReturn(instructions);
        MarsRoverAPI marsRoverAPI = new MarsRoverAPI(commandParser, marsRover);

        marsRoverAPI.execute(commandString);

        verify(marsRover).execute(instructions);
    }


}