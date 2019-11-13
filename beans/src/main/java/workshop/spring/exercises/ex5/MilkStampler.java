package workshop.spring.exercises.ex5;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
@Order(1)
public class MilkStampler implements CowStampler {
  @Override
  public String getStamp() {
    return "Milk";
  }

  @Override
  public boolean applies(Cow cow) {
    return cow.sex == Sex.FEMALE && cow.weight > 200;
  }

  private static final Predicate<Cow> PREDICATE = cow -> cow.sex == Sex.FEMALE && cow.weight > 200;

}

