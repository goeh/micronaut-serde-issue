package micronaut.issue.serde;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.serde.ObjectMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
class DeserializeTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    ObjectMapper objectMapper;

    @Test
    void applicationIsRunning() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void deserializeStandardCar() throws Exception {
        StandardCar standardCar = new StandardCar();
        standardCar.setWheels(4);
        Car car = objectMapper.readValue(objectMapper.writeValueAsString(standardCar), Car.class);
        assertEquals(4, car.getWheels());
    }

    @Test
    void deserializeFlyingCarAsCar() throws Exception {
        FlyingCar flyingCar = new FlyingCar();
        flyingCar.setWheels(4);
        flyingCar.setPropellers(2);
        Car car = objectMapper.readValue(objectMapper.writeValueAsString(flyingCar), Car.class);
        assertEquals(4, car.getWheels());
    }

    @Test
    void deserializeFlyingCarAsFlyingCar() throws Exception {
        FlyingCar flyingCar = new FlyingCar();
        flyingCar.setWheels(4);
        flyingCar.setPropellers(2);
        FlyingCar car = objectMapper.readValue(objectMapper.writeValueAsString(flyingCar), FlyingCar.class);
        assertEquals(4, car.getWheels());
        assertEquals(2, car.getPropellers());
    }
}
