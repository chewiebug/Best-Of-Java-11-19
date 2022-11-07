package b_slides;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
record Person(
    @JsonProperty("first_name") String firstName,
    @JsonProperty("last_name") String lastName,
    String address,
    //LocalDate birthday,
    Date birthday,
    List<String> achievements) {
}
