public class CompareableList<T extends Compare> extends List {
    public CompareableList() {
        super();
    }
    public CompareableList(T[] in) {
        super(in);
    }

    public void mergeSort() {
        if(super.getLength() != 0) {
            mergeSort(this);
        }
    }
    public CompareableList<T> mergeSort(CompareableList<T> list) {
        if(list.getLength()>1) {
            try {
                return mergeLists(mergeSort(list.subset(list.getLength()/2)), mergeSort(list.subset(list.getLength()/2, list.getLength())));
            } catch(ListIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        } else {
            return list;
        }
        return null;
    }
    public CompareableList<T> mergeLists(CompareableList<T> list1, CompareableList<T> list2) {
        int i1 = 0;
        int i2 = 0;
        CompareableList<T> out = new CompareableList<>();
        while(i1 < list1.getLength() || i2 < list2.getLength()) {
            try {
                if(i1 == list1.getLength()) {
                    out.add(list2.get(i2));
                    ++i2;
                } else if(i2 == list2.getLength()) {
                    out.add(list1.get(i1));
                    ++i1;
                } else {
                    if (((Compare) list1.get(i1)).compare((Compare) list2.get(i2)) > 0) {
                        out.add(list2.get(i2));
                        ++i2;
                    } else {
                        out.add(list1.get(i1));
                        ++i1;
                    }
                }
            } catch(ListIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        return out;
    }
    @Override
    public CompareableList<T> subset(int beginIndex, int endIndex) throws ListIndexOutOfBoundsException {
        if (beginIndex < 0 || endIndex > getLength() || beginIndex > endIndex) {
            throw new ListIndexOutOfBoundsException("Length: " + getLength() + " beginIndex: " + beginIndex + " endIndex: " + endIndex);
        }
        CompareableList<T> out = new CompareableList<>();
        for (int i = beginIndex; i < endIndex; ++i) {
            out.add(get(i));
        }
        return out;
    }
    @Override
    public CompareableList<T> subset(int endIndex) throws ListIndexOutOfBoundsException {
        return subset(0,endIndex);
    }
}
