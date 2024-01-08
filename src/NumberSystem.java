import java.lang.annotation.Target;
import java.util.Arrays;
public class NumberSystem {
    private static final char[] digits = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','+','/'};
    private static final String digitsStr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
    public static String convert(String num, int base, int targetBase){
        String out = "";
        int numBase10;
        if(base!=10) {
            numBase10 = convertToBase10(num, base);
        }
        else{
            numBase10 = Integer.parseInt(num);
        }
        int length=0;
        for(int i = 0;!(Math.pow(targetBase,i)>numBase10);i++){
            length = i+1;
        }
        while(numBase10>=0 && length>=0){
            out+=String.valueOf(digits[numBase10/(int)Math.pow(targetBase,length)]);
            numBase10-=digitsStr.indexOf(out.substring(out.length()-1))*(int)Math.pow(targetBase,length);
            length--;
        }

        return out.substring(1);
    }
    private static int convertToBase10(String num, int base){
        String rNum = "";
        for(int i = 0; i<num.length();i++){
            rNum = num.charAt(i)+rNum;
        }
        int out = 0;
        for(int i = rNum.length()-1; i>=0;i--){
            char digit = rNum.charAt(i);
            for(int b = 0; b<digits.length;b++){
                if(digits[b]==digit){
                    out+=b*Math.pow(base,i);
                    break;
                }
            }
        }
        return out;
    }
}
