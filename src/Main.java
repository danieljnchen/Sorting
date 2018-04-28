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
        String[] initialStrings = {"Hi!", "hello :)"};
        CompareableString[] list = new CompareableString[initialStrings.length];
        for (int i = 0; i < initialStrings.length; ++i) {
            list[i] = new CompareableString(initialStrings[i]);
        }
        CompareableList<CompareableString> strings = new CompareableList<CompareableString>(list);
        printStringList(strings);
        strings.mergeSort();
        printStringList(strings);
    }
    public static void printStatus(CompareableList<CompareableString> list) {
        System.out.println("Length: " + list.getLength());
        printStringList(list);

    }
    public static void printStringList(CompareableList<CompareableString> list) {
        System.out.println("First: " + ((ListElement) list.getFirst()).getElement());
        System.out.println("Last: " + ((ListElement) list.getLast()).getElement());
        for(int i=0; i<list.getLength(); ++i) {
            try {
                System.out.println(((ListElement) list.get(i)).getElement());
            } catch(ListIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }
}
