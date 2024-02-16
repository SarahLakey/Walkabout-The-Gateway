//package org.launchcode.walkabout.data.service;
//
//import org.launchcode.walkabout.data.RoleRepository;
//import org.launchcode.walkabout.data.UserRepository;
//import org.launchcode.walkabout.models.Role;
//import org.launchcode.walkabout.models.User;
//import org.launchcode.walkabout.models.dto.RegistrationFormDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private UserRepository userRepository;
//    private RoleRepository roleRepository;
//
//    public UserServiceImpl(UserRepository userRepository) {
//        super();
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public User save(RegistrationFormDTO registrationFormDTO) {
//        User user = new User(registrationFormDTO.getFirstName(), registrationFormDTO.getLastName(),
//                    registrationFormDTO.getVerifyPassword(), Arrays.asList(new Role("ROLE_USER")));
//
//        return userRepository.save(user);
//    }
//}
