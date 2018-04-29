public class Main {
    public static void main(String[] args) {
        /*try {
            String[] initialStrings = {"Hi!", "hello :)"};
            List<String> strings = new List<>(initialStrings);
            printStatus(strings);
            strings.insert("bye", 0);
            printStatus(strings);
            strings.remove(2);
            printStatus(strings);
            strings.add("3");
            printStatus(strings);
            System.out.println(strings.find("Hi!"));
            System.out.println(strings.get(2));
        } catch(ListIndexOutOfBoundsException e) {
            e.printStackTrace();
        }*/
        /*String[] initialStrings = {"Hi!", "A", "hello :)"};
        CompareableString[] list = new CompareableString[initialStrings.length];
        for (int i = 0; i < initialStrings.length; ++i) {
            list[i] = new CompareableString(initialStrings[i]);
        }
        CompareableList<CompareableString> strings = new CompareableList<>(list);
        printStatus(strings);
        strings.add(new CompareableString("Bye!"));
        printStatus(strings);
        strings = CompareableList.mergeSort(strings);
        printStatus(strings);*/
        /*int[] test = {1,5,-2,3,8};
        for(int i : test) {
            System.out.println(i);
        }
        test = mergeSort(test);
        for(int i : test) {
            System.out.println(i);
        }*/
        /*for(int i=0; i<50; ++i) {
            System.out.println(RandomString.generateString(3,5));
        }*/
    }
    public static int[] mergeSort(int[] list) {
        if(list.length <= 1) {
            return list;
        } else {
            return merge(mergeSort(intSubset(list,0,list.length/2)),mergeSort(intSubset(list,list.length/2,list.length)));
        }
    }
    public static int[] intSubset(int[] list, int beginIndex, int endIndex) throws ArrayIndexOutOfBoundsException {
        if(beginIndex<0 || endIndex > list.length || beginIndex>endIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[] out = new int[endIndex-beginIndex];
        for(int i=0; i<endIndex-beginIndex; ++i) {
            out[i] = list[beginIndex+i];
        }
        return out;
    }
    public static int[] merge(int[] list1, int[] list2) {
        int i1 = 0;
        int i2 = 0;
        int[] out = new int[list1.length+list2.length];
        while(i1<list1.length || i2<list2.length) {
            if(i1 == list1.length) {
                out[i1+i2] = list2[i2];
                ++i2;
            } else if(i2 == list2.length) {
                out[i1+i2] = list1[i1];
                ++i1;
            } else {
                if(list1[i1] > list2[i2]) {
                    out[i1+i2] = list2[i2];
                    ++i2;
                } else {
                    out[i1+i2] = list1[i1];
                    ++i1;
                }
            }
        }
        return out;
    }
    public static void printStatus(CompareableList<CompareableString> list) {
        //System.out.println("Length: " + list.getLength());
        printStringList(list);

    }
    public static void printStringList(CompareableList<CompareableString> list) {
        if(list.getLength() == 0) {
            return;
        }
        //System.out.println("First: " + ((ListElement) list.getFirst()).getElement());
        //System.out.println("Last: " + ((ListElement) list.getLast()).getElement());
        for(int i=0; i<list.getLength(); ++i) {
            try {
                System.out.println(((ListElement) list.get(i)).getElement());
            } catch(ListIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }
}
