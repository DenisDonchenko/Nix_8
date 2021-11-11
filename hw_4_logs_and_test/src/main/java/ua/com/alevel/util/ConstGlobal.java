package ua.com.alevel.util;

import java.time.format.DateTimeFormatter;

public final class ConstGlobal {

    public static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    public static final DateTimeFormatter yearFormatter =DateTimeFormatter.ofPattern("yyyy");
}
