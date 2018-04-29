public class RandomString {
    public static String generateString(int minLength, int maxLength) {
        if(minLength>maxLength) {
            throw new IndexOutOfBoundsException();
        }
        int length = minLength + (int) (Math.random()*(maxLength-minLength));
        String out = "";
        for(int i=0; i<length; ++i) {
            char add = (char)('A' + Math.floor(Math.random()*51+.5d));
            if(add>90) {
                add += 6;
            }
            out = out+add;
        }
        return out;
    }
}
