package user.userManagementService;


import exceptions.classs.CtsException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import staff.model.Staff;
import staff.repository.StaffRepository;
import superadmin.model.SuperAdmin;
import superadmin.repository.SuperAdminRepository;
import unitadmin.model.UnitAdmin;
import unitadmin.repository.UnitAdminRepository;
import user.model.User;
import user.model.UserType;

import java.util.Optional;
import static utils.ValidateEmail.isValidEmail;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private  final SuperAdminRepository superAdminRepository;
    private final UnitAdminRepository unitAdminRepository;
    private final StaffRepository staffRepository;

    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public String registerUser(Register registerRequest) throws CtsException {
        if (isValidEmail(registerRequest.getEmail())){
            if (registerRequest.getStaffType().equals(UserType.SUPERADMIN)){
                return registerSuperAdmin(registerRequest);
            }
            if (registerRequest.getStaffType().equals(UserType.UNITADMIN)){
                return registerUnitAdmin(registerRequest);
            }
            if (registerRequest.getStaffType().equals(UserType.STAFF)){
                return registerStaff(registerRequest);
            }
            throw new CtsException("Unauthorized");
        }
        throw new CtsException("This email is not valid");
    }

    private String registerSuperAdmin(Register registerRequest) throws CtsException {
        if (superAdminRepository.existsByEmail(registerRequest.getEmail())) throw new CtsException("SuperAdmin with the same details already exist!!!");
        if (registerRequest.getConfirmPassword().equals(registerRequest.getPassword())){
            SuperAdmin superAdmin = mapper.map(registerRequest, SuperAdmin.class);
            superAdmin.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            superAdminRepository.save(superAdmin);
            return superAdmin.getFirstName() + " your registration was successful";
        }
        throw new CtsException("Password does not match!!!");
    }

    private String registerUnitAdmin(Register registerRequest) throws CtsException {
        if (UnitAdminRepository.existsByEmail(registerRequest.getEmail())) throw new CtsException("UnitAdmin with the same details already exist!!!");
        if (registerRequest.getConfirmPassword().equals(registerRequest.getPassword())){
            UnitAdmin unitAdmin = mapper.map(registerRequest, UnitAdmin.class);
            unitAdmin.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            unitAdminRepository.save(unitAdmin);
            return unitAdmin.getFirstName() + " your registration was successful";
        }
        throw new CtsException("Password not valid!!!");
    }

    private String registerStaff(Register registerRequest) throws CtsException {
        if (staffRepository.existsByEmail(registerRequest.getEmail())) throw new CtsException("Staff with the same details already exist!!!");
        if (registerRequest.getConfirmPassword().equals(registerRequest.getPassword())){
            Staff newStaff = mapper.map(registerRequest, Staff.class);
            newStaff.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            staffRepository.save(newStaff);
            return newStaff.getFirstName() + " your registration was successful";
        }
        throw new CtsException("Password does not match!!!");
    }

    @Override
    public String login(Login loginRequest) throws CtsException {
        Optional<Staff> staff = staffRepository.findByEmail(loginRequest.getEmail());
        if (staff.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), staff.get().getPassword())) return "Welcome back " + staff.get().getFirstName();
        Optional<SuperAdmin> superAdmin = superAdminRepository.findByEmail(loginRequest.getEmail());
        if (superAdmin.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), superAdmin.get().getPassword())) return "Welcome back " + superAdmin.get().getFirstName();
        Optional<UnitAdmin> unitAdmin = unitAdminRepository.findByEmail(loginRequest.getEmail());
        if (unitAdmin.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), staff.orElseThrow().getPassword())) return "Welcome back " + unitAdmin.get().getFirstName();
        throw new CtsException("Invalid login details!!!");
    }
    @Override
    public User getUserByUsername(String email) {
        Optional<Staff> staff = staffRepository.findByEmail(email);
        if (staff.isPresent()) return staff.get();
        Optional<UnitAdmin> unitAdmin = unitAdminRepository.findByEmail(email);
        if (unitAdmin.isPresent()) return unitAdmin.get();
        Optional<SuperAdmin> superAdmin = superAdminRepository.findByEmail(email);
        if (superAdmin.isPresent()) return superAdmin.get();
        throw new UsernameNotFoundException("User not found");
    }
}

