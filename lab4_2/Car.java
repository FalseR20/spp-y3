package lab4_2;

import org.jetbrains.annotations.NotNull;

public class Car {
    public final Wheel[] wheels;

    Car() {
        wheels = new Wheel[]{null, null, null, null};
    }

    Car(Wheel @NotNull [] wheels) {
        assert wheels.length == 4;
        this.wheels = wheels;
    }

    public boolean isBroken() {
        for (var wheel : wheels) {
            if (wheel == null || wheel.is_pierced()) {
                return true;
            }
        }
        return false;
    }
}

