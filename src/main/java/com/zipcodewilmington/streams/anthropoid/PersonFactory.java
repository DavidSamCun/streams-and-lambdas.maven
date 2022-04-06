package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by leon on 5/1/17.
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from using loops of any sort within the definition of this class.
 */
public final class PersonFactory {
    public PersonFactory() {
        /** this class is not to be instantiated */
    }

    /**
     * @return a new instance of a person with fields of random values
     */
    public Person createRandomPerson() {
        String name = StringUtils.capitalizeFirstChar(RandomUtils.createString('a', 'e', 3));
        String[] aliases = RandomUtils.createStrings('a', 'z', 3, 5);
        boolean isMale = RandomUtils.createBoolean(50);
        long personalId = System.nanoTime();
        Date birthDate = RandomUtils.createDate(1950, 2010);

        Person randomPerson = new Person(name, isMale, personalId, birthDate, aliases);
        return randomPerson;
    }

    /**
     * Section 8.8
     *
     * @param listSize - number of Person objects to create
     * @return - ArrayList of Person objects
     */ // TODO
    public List<Person> createPersonList(int listSize) {
        //Using the regular method
        List<Person> output1 = new ArrayList<>();
        for(int i = 0; i < listSize; i++){
            output1.add(createRandomPerson());
        }

        //Now use the stream method
        List<Person> output2 = new ArrayList<>();
        //Stream<Person> personStream = output2.stream().
        //Stream.generate(Person::new).limit(listSize).collect(Collectors.toList());
        //Stream<Person> stream = createPersonStream(listSize).collect(Collectors.toList())
        //Stream<Person> stream = c

//        return IntStream.range(0, listSize)
//                .mapToObj(Object::new) // or x -> new Object(x).. or any other constructor
//                x-> createRandomPerson()
//                .collect(Collectors.toList());
//        List<Person> output3 = IntStream.range(0, listSize).boxed()
//                .collect(Collectors.toList(
//                        createRandomPerson()-> i
//                ));

        List<Person> output3 = createPersonStream(listSize).collect(Collectors.toList());

        return output3;
    }


    /**
     * @param arrayLength - number of Person objects to create
     * @return - Array of Person objects
     */ // TODO
    public Person[] createPersonArray(int arrayLength) {

        return createPersonStream(arrayLength).toArray(Person[]::new);
    }


    /**
     * Section 8.2
     *
     * @param streamCount - number of Person objects to create
     * @return - Stream representation of collection of Person objects
     */ // TODO
    public Stream<Person> createPersonStream(int streamCount) {
        Stream<Person> personStream = Stream.generate(()->createRandomPerson()).limit(streamCount);
        return personStream;
    }
}
