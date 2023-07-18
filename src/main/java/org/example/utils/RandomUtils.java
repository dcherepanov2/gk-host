package org.example.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.UUID;
public class RandomUtils {
    private static final float boundFloat = 99.9F;
    private static final SecureRandom secureRandom = new SecureRandom();
    private RandomUtils(){}
    public static Integer generateRandomInteger(){
        return Math.abs(secureRandom.nextInt());
    }
    public static Integer generateRoundedRandomInteger(int round){
        return Math.abs(secureRandom.nextInt(round));
    }
    public static Float generateRoundedRandomFloat(Integer round){//TODO: допилить метод, не всегда работает так как мне нужно
        float min = 10.0F;
        float value = min + Math.abs(secureRandom.nextFloat()) * (boundFloat - min);
        BigDecimal bd = new BigDecimal(Float.toString(value));
        bd = bd.setScale(round, RoundingMode.HALF_UP);
        return bd.floatValue();
    }
    public static String generateRandomString(String startString){
        UUID uuid = UUID.randomUUID();
        String slug = startString + "-" + uuid + "-" + secureRandom.nextLong();
        return slug.length() > 255 ? slug.substring(0,255): slug;
    }
    public static Integer generateNegativeRandomInteger(){
        return -Math.abs(secureRandom.nextInt());
    }
    public static Integer generateNegativeRoundedRandomInteger(int round){
        return -Math.abs(secureRandom.nextInt(round));
    }
}
