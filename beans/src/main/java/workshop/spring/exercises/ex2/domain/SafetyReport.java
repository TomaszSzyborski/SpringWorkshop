package workshop.spring.exercises.ex2.domain;

import com.google.common.collect.Sets;
import java.util.Set;

public class SafetyReport {
  private final Bus bus;
  public Set<Object> thingsToFix = Sets.newHashSet();

  public SafetyReport(Bus bus) {
    this.bus = bus;
  }

  public Set<Object> getThingsToFix() {
    return thingsToFix;
  }

}
