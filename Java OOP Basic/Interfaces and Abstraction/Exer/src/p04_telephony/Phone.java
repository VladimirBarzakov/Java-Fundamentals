package p04_telephony;

public class Phone implements Callable, InternetConnectable {

    public void Phone(){}

    @Override
    public String call(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))){
                return "Invalid number!";
            }
        }
        return String.format("Calling... %s",number);
    }

    @Override
    public  String visit(String url) {
        for (int i = 0; i < url.length(); i++) {
            if (Character.isDigit(url.charAt(i))){
                return "Invalid URL!";
            }
        }
        return String.format("Browsing: %s!",url);
    }
}
