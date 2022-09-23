import java.util.List;

public class MarsRover {
    private RoverEngine engine;
    private SteeringWheel steeringWheel;

    public MarsRover(RoverEngine engine, SteeringWheel steeringWheel) {
        this.engine = engine;
        this.steeringWheel = steeringWheel;
    }

    public void execute(List<Commands> commands) {
        for (Commands command : commands) {
            if (command == Commands.RIGHT) {
                this.steeringWheel.turnRight();
            }
            if (command == Commands.FORWARD) {
                this.engine.move();
            }
        }
    }

    public RoverLocation collectLocation() {
        throw new UnsupportedOperationException();
    }
}
