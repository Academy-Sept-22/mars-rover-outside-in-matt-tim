import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class MarsRoverTest {
    @Mock RoverEngine engine;
    @Mock SteeringWheel steeringWheel;

    @Test
    void moves_forward_twice() {
        List<Commands> commands = List.of(Commands.FORWARD, Commands.FORWARD);
        MarsRover marsRover = new MarsRover(engine, steeringWheel);

        marsRover.execute(commands);

        verify(engine, times(2)).move();
    }

    @Test
    void moves_right_twice() {
        List<Commands> commands = List.of(Commands.RIGHT, Commands.RIGHT);
        MarsRover marsRover = new MarsRover(engine, steeringWheel);

        marsRover.execute(commands);

        verifyNoInteractions(engine);
        verify(steeringWheel, times(2)).turnRight();
    }

    @Test
    void moves_forward_twice_then_Right_twice() {
        List<Commands> commands = List.of(
                Commands.FORWARD,
                Commands.FORWARD,
                Commands.RIGHT,
                Commands.RIGHT
        );
        MarsRover marsRover = new MarsRover(engine, steeringWheel);

        marsRover.execute(commands);

        verify(engine, times(2)).move();
        verify(steeringWheel, times(2)).turnRight();
    }

}