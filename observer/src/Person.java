import java.util.*;

public class Person implements Subject<Post>, Observer<Person> {

    String name;
    Set<Person> observerList = new HashSet<>();
    Set<Person> personList = new HashSet<>();

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void register(Person observer) {
        observerList.add(observer);
    }

    @Override
    public void unregister(Person observer) {
        if (observerList.contains(observer)) {
            observerList.remove(observer);
        }
    }

    @Override
    public void publish(Post post) {
        notifyObservers(post);
    }


    public String getName() {
        return name;
    }

    private void notifyObservers(Post post) {
        observerList.forEach(observer -> sendMessage(post,observer));
    }

    private void sendMessage(Post post, Person observer){
        System.out.println("Hi " + observer.getName() + ", added new post " + post.message + " in: " + name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
