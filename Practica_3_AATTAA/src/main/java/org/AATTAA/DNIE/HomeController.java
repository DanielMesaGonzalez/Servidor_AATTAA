package org.AATTAA.DNIE;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.AATTAA.DNIE.UsuarioDAOInterface;
import org.AATTAA.DNIE.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UsuarioDAOInterface dao;
	private ObtenerDatos od=new ObtenerDatos();
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "index";
	}
	
	@RequestMapping(value = "/CompruebaBBDD", method = RequestMethod.POST)
	public String sesion(HttpServletRequest request, @RequestParam("nombre") String usuario,@RequestParam("nif") String nif,HttpServletRequest req,Locale locale, Model model) {
		HttpSession sesion = request.getSession();
		Usuario db= new Usuario();
		
		if (dao.BuscarUsuario(nif)==null) {
			return "Noexiste";
		
			}else { 
				Usuario user=dao.BuscarUsuario(nif);
		       sesion.setAttribute("nusuario", user);
		       request.setAttribute("nusuario", user);

				
				return "Existe";
			}
	}
	
	@RequestMapping(value = "/Registro", method = RequestMethod.POST)
	public String registropost(HttpServletRequest request,Locale locale, Model model) {
		HttpSession sesion = request.getSession();


	    Usuario user=od.LeerNIF();
	    if (dao.BuscarUsuario(user.getNif())==null) {
	    	dao.InsertaUsuario(user);
		    sesion.setAttribute("nusuario", user);
		    request.setAttribute("nusuario", user);	    
		       String nickname=user.getNombre().substring(0,1)+ user.getApellido1()+user.getApellido2().substring(0,1);
			   model.addAttribute("nick", "Tu nickname será:"+nickname);
		    return "Existe";	
	    }
	   
	    else  model.addAttribute("yaExiste", "Ese usuario ya está registrado, puedes logearte con tus datos"); 
	    return "index";
	    
	}
		

}