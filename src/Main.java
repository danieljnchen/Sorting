public class Main {
    public static void main(String[] args) {
        try {
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
        }
    }
    public static void printStatus(List<String> list) {
        System.out.println("Length: " + list.getLength());
        printStringList(list);

    }
    public static void printStringList(List<String> list) {
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        for(int i=0; i<list.getLength(); ++i) {
            try {
                System.out.println(list.get(i));
            } catch(ListIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }
}
