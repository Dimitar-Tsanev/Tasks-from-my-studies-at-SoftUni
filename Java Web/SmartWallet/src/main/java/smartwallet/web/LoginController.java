package smartwallet.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import smartwallet.shared.exception.DomainException;
import smartwallet.user.model.User;
import smartwallet.user.service.UserService;
import smartwallet.web.dto.LoginRequest;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public ModelAndView getLoginPage () {

        ModelAndView modelAndView = new ModelAndView ( "login" );
        modelAndView.addObject ( "loginRequest", new LoginRequest ( null, null ) );

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login ( @Valid LoginRequest loginRequest, BindingResult result) {

        if ( result.hasErrors ( ) ) {
            return new ModelAndView ( "login" );
        }

        try {
            User loggedUser = userService.login ( loginRequest );

            return new ModelAndView ( "redirect:/user/home" );

        } catch (DomainException e) {
            result.addError ( new ObjectError ( "loginError", e.getMessage () ) );

            return new ModelAndView ( "login" );
        }
    }
}
