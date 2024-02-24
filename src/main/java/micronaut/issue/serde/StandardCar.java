package micronaut.issue.serde;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class StandardCar implements Car {
    private int wheels;

    @Override
    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}
