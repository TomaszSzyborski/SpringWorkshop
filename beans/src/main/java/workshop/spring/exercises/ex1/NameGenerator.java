package workshop.spring.exercises.ex1;

import org.springframework.stereotype.Component;

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
