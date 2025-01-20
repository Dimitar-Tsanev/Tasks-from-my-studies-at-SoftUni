package smartwallet.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import smartwallet.user.model.Country;
import smartwallet.user.service.UserService;
import smartwallet.web.dto.RegisterRequest;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    @GetMapping("/register")
    public ModelAndView register () {

        ModelAndView modelAndView = new ModelAndView ( "register" );
        modelAndView.addObject ( "registerRequest", new RegisterRequest ( null, null, null ) );
        modelAndView.addObject ( "countries", Country.values () );

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerRequest ( @Valid RegisterRequest registerRequest, BindingResult result ) {

        if ( result.hasErrors ( ) ) {
            ModelAndView modelAndView = new ModelAndView ( "register" );
            modelAndView.addObject ( "countries", Country.values () );

            return modelAndView;
        }

        userService.register ( registerRequest );

        return new ModelAndView ( "redirect:/login" );
    }
}
