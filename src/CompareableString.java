public class CompareableString extends ListElement<String> implements Compare {
    public CompareableString(String s) {
        super(s);
    }
    public CompareableString(String s, CompareableString prev, CompareableString next) {
        super(s, prev, next);
    }

    public double compare(Compare a) {
        return this.getElement().compareTo(((CompareableString) a).getElement());
    }
}
