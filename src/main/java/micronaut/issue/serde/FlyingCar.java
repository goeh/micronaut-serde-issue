package micronaut.issue.serde;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@JsonDeserialize(as = FlyingCar.class)
public class FlyingCar extends StandardCar {
    private int propellers;

    public int getPropellers() {
        return propellers;
    }

    public void setPropellers(int propellers) {
        this.propellers = propellers;
    }
}
