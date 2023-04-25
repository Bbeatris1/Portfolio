package siit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import siit.model.Login;
import siit.service.LoginService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView display(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return new ModelAndView("redirect:/customers");
        } else {
            return new ModelAndView("login");
        }
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute Login login, HttpSession session) {
        if (loginService.validate(login)) {
            session.setAttribute("user", login.getUser());
            return new ModelAndView("redirect:/customers");
        } else {
            Map<String, Object> model = new HashMap<>();
            model.put("error", "Invalid user and/or password");
            return new ModelAndView("login", model);
        }
    }

    @RequestMapping(path = "/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/login");
    }

}
