package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.util.regex.Pattern;

/**
 * Klasse für eine Postleitzahl
 */
@Embeddable
@Getter
@Setter
public class Postleitzahl {

    private final String Plz;

    public Postleitzahl()
    {
        Plz = "00000";
    }

    public Postleitzahl(String plz){

        if(!isValid(plz)){
            throw new IllegalArgumentException("Invalid zip code");
        }

        Plz = plz;
    }

    private boolean isValid(String plz){
        Pattern pattern = Pattern.compile("[0-9]{5}", Pattern.CASE_INSENSITIVE);

        if (plz == null){
            return false;
        }
        else {
            return pattern.matcher(plz).find();
        }
    }
}
