package workshop.spring.exercises.ex2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import workshop.spring.exercises.ex2.domain.Bus;
import workshop.spring.exercises.ex2.domain.SafetyReport;

@Component
public class BusChecker {


  private SafetyReport safetyReport;

  public SafetyReport check(Bus bus) {
this.safetyReport = new SafetyReport(bus);
    BusValidator busValidator = new BusValidator(safetyReport);
    safetyReport = busValidator.prepareReport(bus);
    return this.safetyReport;
  }
}
