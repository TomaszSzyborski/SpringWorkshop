package workshop.spring.exercises.ex2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workshop.spring.exercises.ex2.domain.Bus;
import workshop.spring.exercises.ex2.domain.SafetyReport;

@Component
public class BusValidator {

    private BusAgeValidator busAgeValidator;
    private SeatBeltValidator seatBeltValidator;
    private SeatsValidator seatsValidator;
    private TireValidator tireValidator;
    private EngineValidator engineValidator;

    private SafetyReport safetyReport;

    public BusValidator(@Autowired BusAgeValidator busAgeValidator,
                        @Autowired SeatBeltValidator seatBeltValidator,
                        @Autowired SeatsValidator seatsValidator,
                        @Autowired TireValidator tireValidator,
                        @Autowired EngineValidator engineValidator) {
        this.busAgeValidator = busAgeValidator;
        this.seatBeltValidator = seatBeltValidator;
        this.seatsValidator = seatsValidator;
        this.tireValidator = tireValidator;
        this.engineValidator = engineValidator;
    }

    public SafetyReport prepareReport(Bus bus) {
        validateBus(bus);
        if (!this.safetyReport.thingsToFix.isEmpty()) {
            this.safetyReport.thingsToFix.add(bus);
        }
        return this.safetyReport;
    }

    private void validateBus(Bus bus) {
        busAgeValidator.validate(this.safetyReport, bus);
        engineValidator.validate(this.safetyReport, bus);
        tireValidator.validate(this.safetyReport, bus);
        seatsValidator.validate(this.safetyReport, bus);
        seatBeltValidator.validate(this.safetyReport, bus);
    }

}
