package no.mesan.lunsjliste.resource;

import com.google.firebase.database.*;
import no.mesan.lunsjliste.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/lunchlist", produces = MediaType.APPLICATION_JSON_VALUE)
public class LunchListResource {
    private static final Logger LOG = LoggerFactory.getLogger(LunchListResource.class);

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody User user, @RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        String path = "/" + localDate.getYear() + "/" + localDate.getMonthValue() + "/" + localDate.getDayOfMonth();

        DatabaseReference ref = FirebaseDatabase
                .getInstance()
                .getReference(path);

        Map<String, Object> map = new HashMap<>();
        map.put(user.getUsername(), true);
        ref.updateChildren(map);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Object> year = (HashMap<String, Object>) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return ResponseEntity.ok().build();
    }
}
