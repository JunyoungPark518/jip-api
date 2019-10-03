package kr.jip.api.util;

import io.micrometer.core.instrument.util.StringUtils;
import kr.jip.api.v1.card.Card;

public class MaskUtil {

    public static String getCardMaskingFormat(Card card) {
        String mask = card.getCardNo();
        if(StringUtils.isBlank(mask)) return "";
        int[] indices = {12, 8, 4};
        for(int i : indices) {
            if(i != 0) {
                String temp = mask.substring(i);
                mask = mask.replaceAll(temp, "-" + temp);
            }
        }
        return mask;
    }

}
