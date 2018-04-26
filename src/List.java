public class List<T> {
    ListElement<T> first;
    ListElement<T> last;

    public List() {
        first = null;
        last = null;
    }
    public List(ListElement<T> first, ListElement<T> last) {
        this.first = first;
        this.last = last;
    }

    public ListElement<T> get(int l) throws ListIndexOutOfBoundsException {
        ListElement<T> out = first;
        for(int i=0; i<l; ++i) {
            if(out.getNext() != null) {
                out = out.getNext();
            } else {
                throw new ListIndexOutOfBoundsException();
            }
        }
        return out;
    }

    public void add(ListElement<T> in) {
        last.setNext(in);
        in.setPrev(last);
        in.setNext(null);
        last = in;
    }
    public void add(T in) {
        ListElement<T> a = new ListElement<T>(in);
        add(a);
    }

    public void insert(ListElement<T> in, int i) {

    }

    public ListElement<T> remove(int i) throws ListIndexOutOfBoundsException {
        ListElement<T> rem = get(i);
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
        rem.clear();
        return rem;
    }
}
