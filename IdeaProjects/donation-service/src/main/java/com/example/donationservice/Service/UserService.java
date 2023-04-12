package com.example.donationservice.Service;

import com.example.donationservice.Dto.UserRequest;
import com.example.donationservice.Entity.User;
import com.example.donationservice.Exception.EmailNullException;
import com.example.donationservice.Exception.EmailOverlapException;
import com.example.donationservice.Exception.ErrorCode;
import com.example.donationservice.Exception.PasswordNullException;
import com.example.donationservice.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired // 내 콩
    private UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // 회원가입하는거 !
    // void가 되면 반환값이 없으니까 반환을 못하는데..
    // 그러면 이제 id를 알려줄 수 없고.. 그러니까 id만 반환하는거니까 정수형중에 대따 큰 long 박기

    public Long register(UserRequest req) {


        String email = req.getEmail();
        String name = req.getName();
        String password = req.getPassword();


        User user = new User(null, email, name, password);

        Optional<User> aleadyUser = userRepository.findByEmail(user.getEmail());
        if (aleadyUser.isPresent()) {
            throw new EmailOverlapException("이메일 중복!", ErrorCode.EMAIL_DUPLICATION);

        } else {
            User saveUser = userRepository.save(user);

            return saveUser.getId();
        }
    }

    // 조건문 사용해야......
    public String login(UserRequest req, HttpSession session) {



        String email = req.getEmail();
        String password = req.getPassword();

        User loginUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNullException(ErrorCode.EMAIL_NULL));

        if (!loginUser.getPassword().equals(password)){
            throw new PasswordNullException(ErrorCode.PASSWORD_NULL);
        }


        session.setAttribute("user", loginUser);
        return loginUser.getName();


    }

}


