package workshop.spring.exercises.ex2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workshop.spring.exercises.ex2.domain.Bus;
import workshop.spring.exercises.ex2.domain.SafetyReport;

@Component
public class BusChecker {

    @Autowired
    BusChecker busChecker;

     private SafetyReport safetyReport;

  public SafetyReport check(Bus bus) {
this.safetyReport = new SafetyReport(bus);
//TODO FIX
//    BusValidator busValidator = new BusValidator();
//    safetyReport = busValidator.prepareReport(bus);
    return this.safetyReport;
  }
}
