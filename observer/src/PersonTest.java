import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Test
    public void shouldSuccessfullyAddNewObserver () {
        //given
        Person person = new Person("Justyna");

        //when
        person.register(new Person("Patryk"));

        //then
        assertEquals(person.observerList.size(),1);
    }

    @Test
    public void shouldNotAddNewObserver () {
        //given
        Person person = new Person("Justyna");
        person.observerList.add(new Person("Patryk"));

        //when
        person.register(new Person("Patryk"));

        //then
        assertEquals(person.observerList.size(),1);
    }
}
