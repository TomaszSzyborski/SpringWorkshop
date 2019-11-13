package workshop.spring.exercises.ex5;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MeatStampler implements CowStampler {
    @Override
    public boolean stamp(Cow cow) {
        if (cow.sex == Sex.MALE && cow.weight > 400) {
            cow.setStamp("meat");
            return true;
        }
        return false;
    }
}

