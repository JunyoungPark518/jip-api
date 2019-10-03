package kr.jip.api.v1.bank;

import java.util.Arrays;

public enum EBankAccountStyle {
    카카오뱅크(4,6),
    신한은행(3,6),
    우리은행(3,6),
    국민은행(3,6,11),
    대구은행(3,6),
    에스케이증권(3,6),
    한화투자증권(3,6),
    KEB하나은행(3,9),
    기타(0)
    ;

    int i1, i2, i3;
    EBankAccountStyle(int i1){
        this.i1 = i1;
    }

    EBankAccountStyle(int i1, int i2){
        this.i1 = i1;
        this.i2 = i2;
    }

    EBankAccountStyle(int i1, int i2, int i3){
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
    }

    public static String getBankMaskingFormat(Bank bank) {
        EBankAccountStyle e = Arrays.stream(EBankAccountStyle.values())
                .peek(b -> System.out.println(b))
                .filter(b -> bank.getName().equals(b.name()))
                .findFirst()
                .orElse(기타);

        String mask = bank.getAccount();
        if(e.i1 == 0)
            return mask;

        int[] indices = {e.i3, e.i2, e.i1};
        for(int i : indices) {
            if(i != 0) {
                String temp = mask.substring(i);
                mask = mask.replaceAll(temp, "-" + temp);
            }
        }
        return mask;
    }
}
