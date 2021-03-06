package com.mobileTicket.hello12306.model;

import android.support.annotation.Nullable;
import android.text.TextUtils;

public enum SeatType {
    YZ("硬座", "1".charAt(0)),
    RZ("软座", "2".charAt(0)),
    YW("硬卧", "3".charAt(0)),
    RW("软卧", "4".charAt(0)),
    GR("高软", "6".charAt(0)),
    EDZ("二等", 'O'),
    YDZ("一等", 'M'),
    TDZ("特等", 'P'),
    YDW("一等卧", 'I'),
    EDW("二等卧", 'J'),
    WZ("无座", 'W');

    private String name;
    private char sign;

    SeatType(String name, char sign) {
        this.name = name;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public char getSign() {
        return sign;
    }

    public static SeatType parse(@Nullable String type) {
        if (type != null && type.length() > 0) {
            for (SeatType seatType : SeatType.values()) {
                if (seatType.sign == type.charAt(0)) {
                    return seatType;
                }
            }
        }
        return SeatType.YW;
    }

    public static String getSeatSignByName(String name) {
        return String.valueOf(getSeatTypeByName(name).sign);
    }

    public static SeatType getSeatTypeByName(String name) {
        for (SeatType seatType : SeatType.values()) {
            if (TextUtils.equals(name, seatType.name)) {
                return seatType;
            }
        }
        return SeatType.YW;
    }
}
