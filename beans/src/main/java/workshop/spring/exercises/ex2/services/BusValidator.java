package workshop.spring.exercises.ex2.services;

import org.springframework.stereotype.Component;
import workshop.spring.exercises.ex2.domain.Bus;
import workshop.spring.exercises.ex2.domain.Engine;
import workshop.spring.exercises.ex2.domain.SafetyReport;
import workshop.spring.exercises.ex2.domain.Seat;
import workshop.spring.exercises.ex2.domain.Tire;

import java.util.stream.Collectors;

public class BusValidator {


    private SafetyReport safetyReport;

    public BusValidator(SafetyReport safetyReport) {
        this.safetyReport = safetyReport;
    }

    public SafetyReport prepareReport(Bus bus) {
//        this.safetyReport = new SafetyReport(bus);
//        validateAge(safetyReport, bus);
//        validateEngine(safetyReport, bus);
//        validateTires(safetyReport, bus);
//        validateSeats(safetyReport,bus);
//        validateSeatBelts(safetyReport,bus);
        validateBus(bus);
        if (!this.safetyReport.thingsToFix.isEmpty()){
            this.safetyReport.thingsToFix.add(bus);
        }
        return this.safetyReport;
    }

    private void validateBus(Bus bus){
        validateAge(this.safetyReport, bus);
        validateEngine(this.safetyReport, bus);
        validateTires(this.safetyReport, bus);
        validateSeats(this.safetyReport,bus);
        validateSeatBelts(this.safetyReport,bus);
    }
    private void validateSeatBelts(SafetyReport safetyReport, Bus bus) {
        safetyReport.thingsToFix.addAll(bus.seats.stream().filter(seat ->
                !seat.seatBelt.doItWork ).map(seat -> seat.seatBelt)
                .collect(Collectors.toList()));
    }

    private void validateSeats(SafetyReport safetyReport, Bus bus) {
//        for (Seat seat: bus.seats
//        ) {
//            if(seat.howManyHoles > 0 || !seat.seatBelt.doItWork){
//                safetyReport.thingsToFix.add(seat);
//            }
//        }

        safetyReport.thingsToFix.addAll(bus.seats.stream().filter(seat ->
                seat.howManyHoles > 1 )
                .collect(Collectors.toList()));
    }

    private void validateTires(SafetyReport safetyReport, Bus bus) {
//        for (Tire tire: bus.tires
//        ) {
//            if(tire.runnerDepth < 5 ){
//                safetyReport.thingsToFix.add(tire);
//            }
//        }

        safetyReport.thingsToFix.addAll(bus.tires.stream().filter(tire ->
                tire.runnerDepth < 5).collect(Collectors.toList()));
    }


    private void validateEngine(SafetyReport safetyReport, Bus bus) {
        if(bus.engine.condition == Engine.Condition.BAD){
            safetyReport.thingsToFix.add(bus.engine);
        }
    }

    private void validateAge(SafetyReport safetyReport, Bus bus) {
        if(bus.age > 15){
            safetyReport.thingsToFix.add(bus);
        }
    }
}
