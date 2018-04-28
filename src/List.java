//Order for updating references: before, current, after, first, last
public class List<T> {
    private ListElement<T> first;
    private ListElement<T> last;
    private int length = 0;

    public List() {
        first = null;
        last = null;
    }
    public List(T[] in) {
        addAll(in);
    }

    public int getLength() {
        return length;
    }

    public T getFirst() {
        return first.getElement();
    }
    public T getLast() {
        return last.getElement();
    }

    private ListElement<T> getListElement(int index) throws ListIndexOutOfBoundsException {
        if(index<0 || index>=length) {
            throw new ListIndexOutOfBoundsException();
        }
        ListElement<T> out = first;
        for(int i=0; i<index; ++i) {
            out = out.getNext();
        }
        return out;
    }
    public T get(int index) throws ListIndexOutOfBoundsException {
        return getListElement(index).getElement();
    }

    public int find(T target) {
        int index;
        ListElement<T> current = first;
        for(index=0; index<length; ++index) {
            if(index != 0) {
                current = current.getNext();
            }
            if(current.getElement().equals(target)) {
                return index;
            }
        }
        return -1;
    }

    private void add(ListElement<T> in) {
        if(last == null) {
            first = in;
            last = in;
            in.clear();
        } else {
            last.setNext(in);
            in.setPrev(last);
            in.setNext(null);
            last = in;
        }
        ++length;
    }
    public void add(T in) {
        ListElement<T> a = new ListElement<T>(in);
        add(a);
    }
    public void addAll(T[] in) {
        for(T t : in) {
            add(t);
        }
    }

    public void insert(T in, int index) throws ListIndexOutOfBoundsException {
        if(index<0 || index>length) {
            throw new ListIndexOutOfBoundsException();
        }
        ListElement<T> ins = new ListElement<>(in);
        if(length == 0) {
            add(ins);
        } else if(index == 0) {
            ins.setNext(first);
            first.setPrev(ins);
            first = ins;
        } else if(index == length) {
            ins.setPrev(last);
            last.setNext(ins);
            last = ins;
        } else {
            ListElement<T> insBefore = getListElement(index);
            insBefore.getPrev().setNext(ins);
            ins.setPrev(insBefore.getPrev());
            ins.setNext(insBefore);
            insBefore.setPrev(ins);
        }
        ++length;
        assert get(index) == in;
    }

    public T remove(int index) throws ListIndexOutOfBoundsException {
        if(index<0 || index>=length) {
            throw new ListIndexOutOfBoundsException();
        }
        ListElement<T> rem = getListElement(index);
        if(rem == first && rem == last) {
            first = null;
            last = null;
        } else if(rem == first) {
            rem.getNext().setPrev(null);
            first = rem.getNext();
        } else if(rem == last) {
            rem.getPrev().setNext(null);
            last = rem.getPrev();
        } else {
            rem.getPrev().setNext(rem.getNext());
            rem.getNext().setPrev(rem.getPrev());
        }
        --length;
        return rem.getElement();
    }
}
