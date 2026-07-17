package user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OrderUser {
    private String firstName;
    private String lastName;
    private String zipCode;
}