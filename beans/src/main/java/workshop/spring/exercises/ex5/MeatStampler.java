package workshop.spring.exercises.ex5;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MeatStampler implements CowStampler {
    @Override
    public String getStamp() {
        return "Meat";
    }

    @Override
    public boolean applies(Cow cow) {
        return cow.sex == Sex.MALE && cow.weight > 400;
    }

}

