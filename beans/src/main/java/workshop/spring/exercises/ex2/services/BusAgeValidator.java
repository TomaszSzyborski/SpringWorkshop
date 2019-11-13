package workshop.spring.exercises.ex2.services;

import org.springframework.stereotype.Component;
import workshop.spring.exercises.ex2.domain.Bus;
import workshop.spring.exercises.ex2.domain.BusPart;
import workshop.spring.exercises.ex2.domain.SafetyReport;

@Component
public class BusAgeValidator implements IBusValidator{
    public BusAgeValidator() {
    }


    @Override
    public void validate(SafetyReport safetyReport, Bus bus) {
        if (bus.age > 15) {
            safetyReport.thingsToFix.add(bus);
        }
    }

}