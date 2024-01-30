public class NumberSystem {
    private static final String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
    public static String convert(String num, int base, int targetBase){
        String out = "";
        //for negative numbers
        if(num.charAt(0)=='-'){
            num = num.substring(1);
            out+="-";
        }
        int numBase10;
        if(base!=10) {
            numBase10 = convertToBase10(num, base);
        }
        else if(base == 1){
            numBase10 = convertFromBase1(num);
        }
        else{
            numBase10 = Integer.parseInt(num);
        }
        int length=0;
        if(targetBase == 1){
            return(convertToBase1(numBase10));
        }
        for(int i = 0;!(Math.pow(targetBase,i)>numBase10);i++){
            length = i;
        }
        while(numBase10>=0 && length>=0){
            out+=String.valueOf(digits.charAt(numBase10/(int)Math.pow(targetBase,length)));
            numBase10-=digits.indexOf(out.substring(out.length()-1))*(int)Math.pow(targetBase,length);
            length--;
        }

        return out;
    }
    public static String[] convertToArray(String num, int base, int targetBase){
            return convert(num, base, targetBase).split("");
    }
    public static String convert(String num, int targetBase){
        return convert(num, 10, targetBase);
    }
    private static int convertToBase10(String num, int base){
        String rNum = "";
        for(int i = 0; i<num.length();i++){
            rNum = num.charAt(i)+rNum;
        }
        int out = 0;
        for(int i = rNum.length()-1; i>=0;i--){
            char digit = rNum.charAt(i);
            for(int b = 0; b<digits.length();b++){
                if(digits.charAt(b)==digit){
                    out+=b*Math.pow(base,i);
                    break;
                }
            }
        }
        return out;
    }
    private static String convertToBase1(int num){
        String out = "";
        for(int i = 0; i<num;i++){
            out+="1";
        }
        return out;
    }
    private static int convertFromBase1(String num){
        return num.length();
    }
    public static boolean valid(String num, int base){
        if(base == 1){
            for(int i = 0 ; i<num.length() ; i++){
                if(num.charAt(i)!='1'){
                    return false;
                }
            }
        }
        else {
            for (int i = 0; i < num.length(); i++) {
                if (!digits.substring(0, base).contains(String.valueOf(num.charAt(i)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
