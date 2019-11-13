package workshop.spring.exercises.ex5;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order
public class BreedingStampler implements CowStampler {
    @Override
    public boolean stamp(Cow cow) {
        cow.setStamp("breeding");
        return true;
    }
}

