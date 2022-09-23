import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser {
    public List<Commands> buildInstructions(String commandString) {
        List<Commands> instructions = new ArrayList<>();
        String[] commandStringList = commandString.split("");

        for (String command : commandStringList) {
            if (command.equals("M")) {
                instructions.add(Commands.FORWARD);
            }
            if (command.equals("R")) {
                instructions.add(Commands.RIGHT);
            }
        }


        return instructions;
    }
}
