import java.util.Arrays;
public class NumberSystem {
    private static final char[] digits = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static String convert(String num, int base, int targetBase){
        String out = "";
        char[] baseChars = new char[base];
        for(int i = 0; i<base;i++){
            baseChars[i]=digits[i];
        }
        char[] targetBaseChars = new char[targetBase];
        for(int i = 0; i<targetBase;i++){
            targetBaseChars[i]=digits[i];
        }
        int numBase10 = convertToBase10(num,base);
        int length;

        return out;
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
