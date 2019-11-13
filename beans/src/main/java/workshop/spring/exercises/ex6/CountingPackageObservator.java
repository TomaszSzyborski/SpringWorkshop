package workshop.spring.exercises.ex6;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class CountingPackageObservator {

  private int numberOfPackages;


  @Order
  @EventListener
  public void onPackageReceived(PackageObtainedEvent packageObtainedEvent){
    numberOfPackages++;
  }

  public int getNumberOfPackages() {

    return numberOfPackages;
  }


  void reset() {
      numberOfPackages = 0;
  }
}
