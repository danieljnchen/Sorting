public class ListElement<T> {
    private T element;
    private ListElement<T> prev;
    private ListElement<T> next;

    public ListElement(T element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }
    public ListElement(T element, ListElement<T> prev, ListElement<T> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public T getElement() {
        return element;
    }
    public ListElement<T> getPrev() {
        return prev;
    }
    public void setPrev(ListElement<T> prev) {
        this.prev = prev;
    }
    public ListElement<T> getNext() {
        return next;
    }
    public void setNext(ListElement<T> next) {
        this.next = next;
    }
    public void clear() {
        prev = null;
        next = null;
    }

}
