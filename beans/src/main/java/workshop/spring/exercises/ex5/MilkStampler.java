package workshop.spring.exercises.ex5;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MilkStampler implements CowStampler {
  @Override
  public boolean stamp(Cow cow) {
    if (cow.sex == Sex.FEMALE && cow.weight > 200) {
      cow.setStamp("Milk");
      return true;
    }
    return false;
  }
}

