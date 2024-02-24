package micronaut.issue.serde;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = StandardCar.class)
public interface Car {
    int getWheels();
}
