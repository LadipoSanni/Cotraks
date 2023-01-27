package user.userManagementService;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Login{
    private String email;
    private String password;
}

