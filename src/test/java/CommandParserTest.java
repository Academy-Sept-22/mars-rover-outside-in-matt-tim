import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {
    @Test
    void builds_forward_command() {
        String forwardCommand = "M";
        CommandParser commandParser = new CommandParser();

        List<Commands> result = commandParser.buildInstructions(forwardCommand);

        assertEquals(result.get(0), Commands.FORWARD);
    }
    @Test
    void builds_right_command() {
        String rightCommand = "R";
        CommandParser commandParser = new CommandParser();

        List<Commands> result = commandParser.buildInstructions(rightCommand);

        assertEquals(result.get(0), Commands.RIGHT);
    }
    @Test
    void builds_two_forward_and_one_right_command() {
        String commands = "MMR";
        List<Commands> instructions = List.of(
                Commands.FORWARD,
                Commands.FORWARD,
                Commands.RIGHT
        );

        CommandParser commandParser = new CommandParser();

        List<Commands> result = commandParser.buildInstructions(commands);

        assertEquals(result, instructions);
    }
}