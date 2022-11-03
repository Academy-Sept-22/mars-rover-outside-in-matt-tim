public class GPSReaderMock extends GPSReader {
    private String coordinate;
    private RoverLocation expectedRoverLocation;
    private int counter = 0;

    public GPSReaderMock(String coordinate, RoverLocation expectedRoverLocation) {
        this.coordinate = coordinate;
        this.expectedRoverLocation = expectedRoverLocation;
    }

    @Override
    public String parse(RoverLocation roverLocation) throws Exception {
        if (roverLocation != expectedRoverLocation) {
            throw new Exception(
                    "Parse was not called with: " +
                     this.expectedRoverLocation.toString() + "\n" +
                    "instead was called with: " + roverLocation.toString()
            );
        }
        counter++;
        return this.coordinate;
    }

    public String verify() {
        return "Parse was called " + counter + " times with the expected argument: " + this.expectedRoverLocation.toString();
    }
}
