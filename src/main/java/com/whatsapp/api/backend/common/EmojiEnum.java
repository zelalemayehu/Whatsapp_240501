package com.whatsapp.api.backend.common;

public enum EmojiEnum {

    THUMBUP("\uD83D\uDC4D"),
    LOVE("\u2764"),
    CRYING("\uD83D\uDE22"),
    SUPRISED("\uD83D\uDE28");

    private String unicode;

    EmojiEnum(String unicode) {
        this.unicode = unicode;
    }

    public String getUnicode() {
        return unicode;
    }
}
