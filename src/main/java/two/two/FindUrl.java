package two.two;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindUrl {
    public static void main(String[] strings) {
        FindUrl findUrl = new FindUrl();
        findUrl.findAllUrl("rhrthr https://stepik.org edtrhert r113223@12 https://wererwg.ru erwg3rg@123009https\n" +
                "rhrthr http://sfrgeee.org/ewfef/wqewrg\n" +
                "5476y65yyyyyh$%&$\n" +
                "https://makedreamprofits.ru/?utm_source=ewqee&utm_medium=qew");
    }
    private void findAllUrl(String text) {
        String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile("\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }


}
