public class MarsRoverStub extends MarsRover {
    private static RoverEngine engine;
    private static SteeringWheel steeringWheel;
    private RoverLocation roverLocation;

    public MarsRoverStub(RoverLocation roverLocation) {
        super(engine, steeringWheel);
        this.roverLocation = roverLocation;
    }

    @Override
    public RoverLocation collectLocation() {
        return this.roverLocation;
    }
}
