import java.text.MessageFormat;

public class GPSReaderMock extends GPSReader {
    private String coordinate;
    private RoverLocation expectedRoverLocation;
    private int counter = 0;

    public GPSReaderMock(String coordinate, RoverLocation expectedRoverLocation) {
        this.coordinate = coordinate;
        this.expectedRoverLocation = expectedRoverLocation;
    }

    @Override
    public String parse(RoverLocation roverLocation)  {
        if (roverLocation != expectedRoverLocation) {
            throw new AssertionError(
                    MessageFormat.format(
                            "Parse was not called with: {0}\ninstead was called with: {1}",
                            this.expectedRoverLocation.toString(), roverLocation.toString()
                    )
            );
        }
        counter++;
        return this.coordinate;
    }

    public void verifyCalledTimes(int times) {
        String errorMessage = "Parse was only called " + counter + " times with the expected argument: " + this.expectedRoverLocation.toString();

        if (times != counter) {
            throw new AssertionError(errorMessage);
        }
    }
}
