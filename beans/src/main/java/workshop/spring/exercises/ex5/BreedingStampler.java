package workshop.spring.exercises.ex5;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order
public class BreedingStampler implements CowStampler {

    @Override
    public String getStamp() {
        return "Breeding";
    }

    @Override
    public boolean applies(Cow cow) {
        return true;
    }
}

