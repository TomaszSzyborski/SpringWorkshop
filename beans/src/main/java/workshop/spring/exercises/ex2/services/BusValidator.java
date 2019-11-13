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
        safetyReport = new SafetyReport();
        prepareSaftyReport(bus,safetyReport);
        if (!safetyReport.thingsToFix.isEmpty()) {
            safetyReport.thingsToFix.add(bus);
        }
        return safetyReport;
    }

    private void validateBus(Bus bus, SafetyReport safetyReport) {
        busAgeValidator.validate(safetyReport, bus);
        engineValidator.validate(safetyReport, bus);
        tireValidator.validate(safetyReport, bus);
        seatsValidator.validate(safetyReport, bus);
        seatBeltValidator.validate(safetyReport, bus);
    }
    private void prepareSaftyReport(final Bus bus, final SafetyReport safetyReport) {
        validateBus(bus, safetyReport);
    }
}
