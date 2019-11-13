package workshop.spring.exercises.ex5;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class HerdStampler {
    @Autowired
    private final List<CowStampler> cowStamplerList;

    public HerdStampler(List<CowStampler> cowStamplerList) {
        this.cowStamplerList = cowStamplerList;
    }

    public void stamp(Cow... cows) {
        for (Cow cow : cows) {
            stampSingleCow(cow);
        }
    }


    private void stampSingleCow(Cow cow) {
        for (CowStampler cowStampler : cowStamplerList) {
            if(cowStampler.stamp(cow)){
                return;
            }
        }
    }
}
