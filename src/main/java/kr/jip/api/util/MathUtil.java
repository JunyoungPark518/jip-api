package kr.jip.api.util;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class MathUtil {

    // max 범위에서 랜덤값 계산
    // return Double
    public static Double getDoubleRandomValue(Integer max){
        return Math.random() * max;
    }

    // max 범위에서 랜덤값 계산
    // return Integer
    public static Integer getIntegerRandomValue(Integer max){
        return Integer.parseInt(String.valueOf(Math.round(getDoubleRandomValue(max))));
    }

    // value의 값을 받아 point만큼 자리수로 표현
    // return Double
    public static Double toFixed(Double value, Integer point){
        return Double.parseDouble(String.format("%."+point+"f", value));
    }

    // Double의 값을 받아 Integer로 변환
    // return Integer
    public static Integer getInteger(Double value){
        return Integer.parseInt(String.valueOf(value).split("\\.")[0]);
    }

    // value를 fill만큼의 자리수로 0을 채워서 반환
    // return String
    public static String fillZero(Integer value, Integer fill){
        return String.format("%0" + fill + "d", value);
    }

    // value의 세자리마다 Comma(,)를 붙여 반환
    // return String
    public static String setComma(Object value){
        return new DecimalFormat("###,###").format(value);
    }

    /**
     * 확률 생성 함수
     * @param count 시도횟수
     * @param ratio 실제 확률
     * @param caller 호출 클래스(로그 확인용)
     * @return
     */
    public static Double generateRatio(long count, double ratio, Class caller){
        AtomicLong matchCount = new AtomicLong();
        AtomicLong tryCount = new AtomicLong();

        LongStream.rangeClosed(1, count).parallel().forEach(i -> {
            tryCount.incrementAndGet();
            if(new Random().nextDouble() <= ratio){
                matchCount.incrementAndGet();
            }
        });

        if(caller != null){
            System.out.println("호출 Class >> "  + caller.toString());
        }

        System.out.println(String.format("당첨 횟수/시도횟수 => %d / %d (비율:%f per) / 실제 DB 확률 => " + ratio,
                matchCount.get(),
                count,
                (double)matchCount.get()/(double)tryCount.get()
                )
        );

        return (double)matchCount.get()/(double)tryCount.get();
    }

    public static boolean getSuccess(Double ratio){
        return new Random().nextDouble() < ratio;
    }

    public static int ceilDiv(int x, int y) {
        return Math.floorDiv(x, y) + (x % y == 0 ? 0 : 1);
    }
}
