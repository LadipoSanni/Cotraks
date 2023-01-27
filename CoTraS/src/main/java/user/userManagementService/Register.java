package user.userManagementService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import user.model.Gender;
import user.model.UserType;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Register {
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;
        private String password;
        private Gender gender;
        private String confirmPassword;
        private UserType staffType;


}
