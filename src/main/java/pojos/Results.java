package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Results {

    private String gender;

    private Login login;

    private Location location;

    private Name name;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    @NoArgsConstructor
    public static class Login {
        private String password;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    @NoArgsConstructor
    public static class Location {
        private String country;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    @NoArgsConstructor
    public static class Name {
        private String first;

        private String last;


        @Override
        public String toString() {
            return first + " " + last;
        }
    }

}
