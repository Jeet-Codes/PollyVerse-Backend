package org.example.pollyversebackend.Service.ServiceImp;


import org.example.pollyversebackend.Dto.LoginDto;
import org.example.pollyversebackend.Entity.Role;
import org.example.pollyversebackend.Entity.User;
import org.example.pollyversebackend.Mail.EmailSender;
import org.example.pollyversebackend.Repository.RoleRepo;
import org.example.pollyversebackend.Repository.UserRepo;
import org.example.pollyversebackend.Response.LoginResponse;
import org.example.pollyversebackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Value("${normal.role.id}")
    private String normalRoleId;
    @Autowired
    private RoleRepo roleRepository;
    @Autowired
    private UserRepo userRepository;
    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString().substring(0,4);
        user.setUserid(userId);
        Role role = roleRepository.findById(normalRoleId).get();
        user.getRoles().add(role);
        User save = userRepository.save(user);

//        String to="sandeep090304@gmail.com";
        String from="jeetcodes127.0.1@gmail.com";
//        String subject="Polly verse backend";
        String body="This is Your Login Credentials for our Website. " +
                "UserId :"+save.getEmail()+"\n"+
                "Password :"+save.getPassword()+"\n"+
                "Thank You For Registering..";
        EmailSender emailSender=new EmailSender();
        emailSender.sendEmail(from, save.getEmail(), "noreply@PollyVerse",body);
        return save;
    }
    @Override
    public LoginResponse loginstudent(LoginDto loginDto) {
        String msg="";
        User user = userRepository.findByEmail(loginDto.getEmail());
        if(user!=null)
        {
            String password=loginDto.getPassword();
            String password1 = user.getPassword();
            Boolean isPwdRight=password.equals(password1);
            if(isPwdRight){
                System.out.println(loginDto.getEmail());
                System.out.println(loginDto.getPassword());
                Optional<User> optionalUser = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), password1);
                System.out.println(optionalUser);
                if(optionalUser.isPresent()){
                    return new LoginResponse("login successfully",true,optionalUser);
                }
                else{
                    return new LoginResponse("login failed",false,null);
                }
            }
            else {
                return new LoginResponse("password not  mmatch",false,null);
            }
        }
        else {
            return new LoginResponse("email not match",false,null);
        }

    }

    @Override
    public User getUserByUsername(String username) {
        User find=userRepository.findByEmail(username);
        return find;

    }
}
