import java.util.ArrayList;
import java.util.List;

public class CommandParserStub extends CommandParser{

    private List<Commands> instructions;

    public CommandParserStub(List<Commands> list) {
        this.instructions = list;
    }

    @Override
    public List<Commands> buildInstructions(String commandString) {
        return instructions;
    }
}
