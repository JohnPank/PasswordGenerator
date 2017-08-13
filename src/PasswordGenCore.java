import java.util.Random;

/**
 * Created by JohnPank on 20.07.17
 */
class PasswordGenCore {
    private String base;

    public PasswordGenCore() {
        base = "";
    }

    public void addDigit(){
        base += "0123456789";
    }

    public void addUpperEn(){
        base += "QWERTYUIOPASDFGHJKLZXCVBNM";
    }

    public void addLowerEn(){
        base += "qwertyuiopasdfghjklzxcvbnm";
    }

    public void addUpperRus(){
        base += "ЁЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
    }

    public void addLowerRus(){
        base += "ёйцукенгшщзхъфывапролджэячсмитьбю";
    }

    public void addSpec(){
        base += "~@#$%^&*()/*-+<>;:=_";
    }

    public void reset(){
        base = "";
    }

    public double getCryptoIndex(int len){
        return len*(Math.log(base.length())/Math.log(2));
    }

    public String generateNext(int len){
        if(base.length() == 0)
            return "";

        String password = "";
        for (int i = 0; i < len; i++) {
            password += base.toCharArray()[new Random().nextInt(base.length())];
        }
        return password;
    }
}
