package workshop.oop.list;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public <TYPE> Collection<TYPE> toCollection(TYPE object){
        return Arrays.asList(object, object);
    }
}
