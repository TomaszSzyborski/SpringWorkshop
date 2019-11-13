package workshop.spring.exercises.ex2.services;

import org.springframework.stereotype.Component;
import workshop.spring.exercises.ex2.domain.Bus;
import workshop.spring.exercises.ex2.domain.Engine;
import workshop.spring.exercises.ex2.domain.SafetyReport;

@Component
public class EngineValidator implements IBusValidator {
    public EngineValidator() {
    }

    @Override
    public void validate(final SafetyReport safetyReport, final Bus bus) {
        if (bus.engine.condition == Engine.Condition.BAD) {
            safetyReport.thingsToFix.add(bus.engine);
        }
    }
}