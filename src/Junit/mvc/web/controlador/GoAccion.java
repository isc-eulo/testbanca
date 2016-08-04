package Junit.mvc.web.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoAccion {
	@RequestMapping(value="/go")
	public String go(){
		return "";
	}
}
