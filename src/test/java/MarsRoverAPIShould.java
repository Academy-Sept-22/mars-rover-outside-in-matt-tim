import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

class MarsRoverAPIShould {
    @Mock CommandParser commandParser;
    @Mock MarsRover marsRover;
    @Test
    void execute() {
        String commandString = "L";
        List commands = List.of(Commands.LEFT);

        given(commandParser.buildInstructions(commandString)).willReturn(commands);

        MarsRoverAPI marsRoverAPI = new MarsRoverAPI(commandParser, marsRover);

        verify(marsRover).execute(commands);
    }


}