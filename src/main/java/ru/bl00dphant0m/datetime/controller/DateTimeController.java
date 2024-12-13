package ru.bl00dphant0m.datetime.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bl00dphant0m.datetime.service.DateTimeService;

@RestController
@RequestMapping("/api/date-time")
@RequiredArgsConstructor
public class DateTimeController {

    private final DateTimeService dateTimeService;

    @GetMapping("/{region}/{city}")
    public ResponseEntity<String> getDateTime(@PathVariable String region, @PathVariable String city) {
        try {
            String massage = dateTimeService.getDateAndTime(region, city);
            return ResponseEntity.ok(massage);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
