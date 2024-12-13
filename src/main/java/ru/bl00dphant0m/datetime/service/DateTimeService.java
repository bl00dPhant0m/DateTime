package ru.bl00dphant0m.datetime.service;

import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateTimeService {
    public String getDateAndTime(String region, String city) {
        String zone = region + "/" + city;
        try {
            ZoneId zoneId = ZoneId.of(zone);
            ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm z");
            return "Дата и время в " + zone + ": " + zonedDateTime.format(formatter);
        }catch (Exception e) {
            throw new IllegalArgumentException("Ошибка: некорректный регион или город (" + zone + ")");
        }
    }
}
