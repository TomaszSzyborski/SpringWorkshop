package workshop.spring.exercises.ex2.services;

import org.springframework.stereotype.Component;
import workshop.spring.exercises.ex2.domain.Bus;
import workshop.spring.exercises.ex2.domain.SafetyReport;

import java.util.stream.Collectors;

@Component
public class SeatBeltValidator implements IBusValidator {
    public SeatBeltValidator() {
    }

    @Override
    public void validate(final SafetyReport safetyReport, final Bus bus) {
        safetyReport.thingsToFix.addAll(bus.seats.stream().filter(seat ->
                !seat.seatBelt.doItWork).map(seat -> seat.seatBelt)
                .collect(Collectors.toList()));
    }
}