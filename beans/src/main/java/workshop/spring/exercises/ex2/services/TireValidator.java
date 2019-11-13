package workshop.spring.exercises.ex2.services;

import org.springframework.stereotype.Component;
import workshop.spring.exercises.ex2.domain.Bus;
import workshop.spring.exercises.ex2.domain.SafetyReport;

import java.util.stream.Collectors;

@Component
public class TireValidator implements IBusValidator{
    public TireValidator() {
    }

    @Override
    public void validate(final SafetyReport safetyReport, final Bus bus) {
        safetyReport.thingsToFix.addAll(bus.tires.stream().filter(tire ->
                tire.runnerDepth < 5).collect(Collectors.toList()));
    }
}