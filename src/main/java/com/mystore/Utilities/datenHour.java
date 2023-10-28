package com.mystore.Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class datenHour {
    public static void getDate() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaHoraFormateada = ahora.format(formatter);

        System.out.println(fechaHoraFormateada);
    }
}
