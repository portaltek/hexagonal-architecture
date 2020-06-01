package portaltek.hexa.domain.interfaces;

/*
 * Notify DB, WebServices, Queue, SMS, sockets, etc.
 * */
public interface Notifier<T> {

    T notify(T t);
}
