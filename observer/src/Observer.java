public interface Observer<T> {

    void register(T observer);

    void unregister(T observer);
}
