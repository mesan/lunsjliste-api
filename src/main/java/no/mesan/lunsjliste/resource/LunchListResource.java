package no.mesan.lunsjliste.resource;

import no.mesan.lunsjliste.model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/lunchlist", produces = MediaType.APPLICATION_JSON_VALUE)
public class LunchListResource {

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody User user) {
        return ResponseEntity.ok().build();
    }
}
