import java.util.List;

public class MarsRoverSpy extends MarsRover {
    private static RoverEngine engine;
    private static SteeringWheel steeringWheel;
    private int counter;

    public MarsRoverSpy() {
        super(engine, steeringWheel);
    }

    @Override
    public void execute(List<Commands> commands) {
        counter++;
    }

    public String verify() {
        return "execute was called " + counter + " times";
    }
}
