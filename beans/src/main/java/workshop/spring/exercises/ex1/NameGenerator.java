package workshop.spring.exercises.ex1;

import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Component
public class NameGenerator {

  private SequentialNameGiver counter;
  private String prefix = "customName:";
  private int i = 1;

  public String getNextName() {

    return prefix + i++;
  }

  public void setPrefix(String prefix) {

    this.prefix = prefix;
  }
}
