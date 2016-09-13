package no.mesan.lunsjliste.resource;

import no.mesan.lunsjliste.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "/api/lunchlist", produces = MediaType.APPLICATION_JSON_VALUE)
public class LunchListResource {
    private static final Logger LOG = LoggerFactory.getLogger(LunchListResource.class);

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody User user, @RequestParam String date) {
        LOG.info("date: " + date);
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);

        LOG.info("localDateTime: " + localDate.toString());
        return ResponseEntity.ok().build();
    }
}
