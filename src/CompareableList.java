public class CompareableList<T extends Compare> extends List {
    public CompareableList() {
        super();
    }
    public CompareableList(T[] in) {
        super(in);
    }

    public static CompareableList mergeSort(CompareableList list) {
        if(list.getLength()>1) {
            try {
                return mergeLists(mergeSort(subset(list,list.getLength()/2)), mergeSort(subset(list,list.getLength()/2,list.getLength())));
            } catch(ListIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        } else {
            return list;
        }
        return null;
    }
    public static CompareableList mergeLists(CompareableList list1, CompareableList list2) {
        int i1 = 0;
        int i2 = 0;
        CompareableList out = new CompareableList();
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
    public static CompareableList subset(CompareableList list, int beginIndex, int endIndex) throws ListIndexOutOfBoundsException {
        if (beginIndex < 0 || endIndex > list.getLength() || beginIndex > endIndex) {
            throw new ListIndexOutOfBoundsException("Length: " + list.getLength() + " beginIndex: " + beginIndex + " endIndex: " + endIndex);
        }
        CompareableList out = new CompareableList();
        for (int i = beginIndex; i < endIndex; ++i) {
            out.add(list.get(i));
        }
        return out;
    }
    public static CompareableList subset(CompareableList list, int endIndex) throws ListIndexOutOfBoundsException {
        return subset(list, 0,endIndex);
    }
}
