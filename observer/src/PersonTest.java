import org.junit.Test;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Test
    public void shouldSuccessfullyAddNewObserver() {
        //given
        Person person = new Person("Justyna");

        //when
        person.register(new Person("Patryk"));

        //then
        assertEquals(person.observerList.size(), 1);
    }

    @Test
    public void shouldNotAddNewObserver() {
        //given
        Person person = new Person("Justyna");
        person.observerList.add(new Person("Patryk"));

        //when
        person.register(new Person("Patryk"));

        //then
        assertEquals(person.observerList.size(), 1);
    }

    @Test
    public void shouldNotifyObservers() {
        //given
        Person person = new Person("Patryk");
        Post post = new Post("Good Morning", ":))");
        Person observer1 = new Person("Kamil");
        Person observer2 = new Person("Wojtek");
        person.personList.add(observer1);
        person.personList.add(observer2);

        //when
        person.publish(post);

    }
}
