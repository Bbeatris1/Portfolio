package siit.service;

import org.springframework.stereotype.Service;
import siit.model.Login;

import java.util.HashSet;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean validate(Login login) {
        Set<Character> userChars = characterSet(login.getUser().toLowerCase());
        Set<Character> passwordChars = characterSet(login.getPassword().toLowerCase());
        return userChars.equals(passwordChars);
    }

    private Set<Character> characterSet(String str) {
        Set<Character> result = new HashSet<>();
        for (int i=0; i<str.length(); ++i) {
            result.add(str.charAt(i));
        }
        return result;
    }
}
