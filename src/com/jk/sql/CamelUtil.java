package jk.sql;

public class CamelUtil {

    //카멜표기 -
    public static String camelCase(String name){
        if(name.indexOf('_')<0 && Character.isLowerCase(name.charAt(0))){
            return name;
        }
        StringBuilder result = new StringBuilder();
        int len = name.length();
        boolean nextUpper = false;
        char code;
        for(int i=0;i<len;i++){
            code = name.charAt(i);
            if(code =='_') {
                nextUpper = true;
            }else{
                if(nextUpper){
                    result.append(Character.toUpperCase(code));
                    nextUpper = false;
                }else {
                    result.append(Character.toLowerCase(code));
                }
            }
        }
        return result.toString();
    }
}
