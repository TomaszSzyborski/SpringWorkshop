package workshop.oop.drive.insurance;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class OCInsuranceTest {

  @Test
  @Order(10)
  public void shouldHaveDefaultInsurance() {
    //given
    OCInsurance ocInsurance = new OCInsurance(300);
    //when

    //then
    assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(300);
  }

  @Order(20)
  @Test
  public void calculatePriceWithAbsoluteDiscount() {
    //given
    OCInsurance ocInsurance = new OCInsurance(300);
    //when
    ocInsurance.addAbsoluteDiscount(20);

    //then
    assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(280);
  }

  @Order(30)
  @Test
  public void calculatePriceWithAbsoluteAndRelativeDiscount() {
    //given
    OCInsurance ocInsurance = new OCInsurance(300);
    //when
    ocInsurance.addAbsoluteDiscount(20);
    ocInsurance.addRelativeDiscount(10);

    //then
    assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(252);
  }

  @Order(40)
  @Test
  public void calculatePriceWithAbsoluteAndRelativeDiscountV2() {
    //given
    OCInsurance ocInsurance = new OCInsurance(300);
    //when
    ocInsurance.addAbsoluteDiscount(20);
    ocInsurance.addRelativeDiscount(10);
    ocInsurance.addAbsoluteDiscount(30);

    //then
    assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(222);
    assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(222);
  }

  @Order(40)
  @Test
  public void calculatePriceWithAbsoluteAndRelativeDiscountV3() {
    //given
    OCInsurance ocInsurance = new OCInsurance(300);
    //when
    ocInsurance.addAbsoluteDiscount(20);
    ocInsurance.addRelativeDiscount(10);
    ocInsurance.addAbsoluteDiscount(30);
    ocInsurance.addRelativeDiscount(50);
    //then
    assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(111);
    assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(111);
  }

  @Order(50)
  @Test
  public void calculatePriceWithRemovedAbsoluteDiscounts() {
    //given
    OCInsurance ocInsurance = new OCInsurance(300);
    //when
    ocInsurance.addAbsoluteDiscount(20);
    ocInsurance.addRelativeDiscount(10);
    ocInsurance.removeAbsoluteDiscounts();

    //then
    assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(270);
  }

  @Order(60)
  @Test
  public void addVipDiscountWhichApplies() {
    //given
    OCInsurance ocInsurance = new OCInsurance(10000);
    //when
    ocInsurance.addAbsoluteDiscount(1000);
    ocInsurance.addVIPDiscount(50);

    //then
    assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(4500);
  }

  @Order(70)
  @Test
  public void addVipDiscountWhichNotApplies() {
    //given
    OCInsurance ocInsurance = new OCInsurance(300);
    //when
    ocInsurance.addAbsoluteDiscount(1000);
    ocInsurance.addVIPDiscount(50);

    //then
    assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(300);
  }

  @Order(80)
  @Test
  public void addFemaleDiscount() {
    //given
    OCInsurance ocInsurance = new OCInsurance(Sex.FEMALE, 300);
    //when
    ocInsurance.addAbsoluteDiscount(20);
    ocInsurance.addSexDiscount(Sex.FEMALE, 20);

    //then
    assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(224);
  }

  @Order(90)
  @Test
  public void addFemaleDiscountThatDoesntWork() {
    //given
    OCInsurance ocInsurance = new OCInsurance(Sex.MALE, 300);
    //when
    ocInsurance.addAbsoluteDiscount(20);
    ocInsurance.addSexDiscount(Sex.FEMALE, 20);

    //then
    assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(280);
  }



}
