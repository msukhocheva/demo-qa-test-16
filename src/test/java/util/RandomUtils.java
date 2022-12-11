package util;



import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {


    public static String randomString(int len){
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    public static String randomEmail(int len){
        return randomString(len)+"@gmail.ru";
    }
    public static Long randomNumber(long min, long max){
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static int randomInt(int min, int max){
        Random rand =new Random();
        return rand.nextInt((max-min)+1)+min;
    }

    public static String randomListItem(){
        String[] names = {"a", "b","a", "b"};
//        List ..
//        Map HashMap ..
        int index = randomInt(0,4);
        return names[index];
    }
}
