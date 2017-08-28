package com.integradorFinal.demo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.integradorFinal.demo.models.DaoItem;
import com.integradorFinal.demo.models.DaoOrden;
import com.integradorFinal.demo.models.DaoPropietario;
import com.integradorFinal.demo.models.DaoRepuesto;
import com.integradorFinal.demo.models.DaoUsuario;
import com.integradorFinal.demo.models.Item;
import com.integradorFinal.demo.models.Orden;
import com.integradorFinal.demo.models.Propietario;
import com.integradorFinal.demo.models.Repuesto;
import com.integradorFinal.demo.models.Usuario;
import com.integradorFinal.demo.services.Paso;

@Controller
@SessionAttributes({"usuariologueado","carrito"})
public class MainController {
	
	@Autowired
	DaoPropietario daoPropietario;
	
	@Autowired
	DaoOrden daoOrden;
	
	@Autowired
	DaoItem daoItem;
	
	@Autowired
	DaoRepuesto daoRepuesto;
	
	@Autowired
	DaoUsuario daoUsuario;

	public MainController() {
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		String str = "";
		model.addAttribute("error", str);
		return "login";
	}
	
	@RequestMapping(value = "/loggeo", method = RequestMethod.POST)
	public String loggeo(Model model,
			@RequestParam String nombre,
			@RequestParam String password) {

	String str = "";
	
	List<Usuario> busquedaNombre = daoUsuario.findByuser(nombre);
	if(busquedaNombre.size()==0){
		str = "Usuario no existia y fue creado existosamente";
		Usuario user2 = new Usuario(nombre,password);
		daoUsuario.save(user2);
	} else {
		Usuario userExistente = busquedaNombre.get(0);
		if(userExistente.getPass().equals(password)){
			String strMensaje = "";
			
			model.addAttribute("usuariologueado", userExistente);
			model.addAttribute("carrito", new ArrayList<Paso>());
			
			model.addAttribute("error", strMensaje);
			model.addAttribute("todasLasOrdenes", daoOrden.findAll());
			return "homepage";
		} else {
			str = "Contraseña incorrecta";
		}
	}
	model.addAttribute("error", str);
		return "login";
	}
	
	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public String homepage(Model model) {
		String strMensaje = "";
		model.addAttribute("error", strMensaje);
		model.addAttribute("todasLasOrdenes", daoOrden.findAll());
		return "homepage";
	}
	
	@RequestMapping(value = "/crearorden", method = RequestMethod.POST)
	public String crearOrden(Model model, @RequestParam String nombreCliente,
			@ModelAttribute("usuariologueado") Usuario usuario,
			@RequestParam String patenteStr,
			@RequestParam String marcaStr,
			@RequestParam String fallaStr) {
		String strMensaje = "";		
		List<Propietario> busquedaNombre = daoPropietario.findByapellidoYNombre(nombreCliente);
		if(busquedaNombre.size()==0){
			strMensaje = "Cliente no existe";
		} else {
			Propietario clienteExistente = busquedaNombre.get(0);
			java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
			Orden ord = new Orden(clienteExistente, Integer.parseInt(patenteStr), marcaStr,sqlDate,fallaStr);
			ord.setUsuario(usuario);
			daoOrden.save(ord);
			} 
		model.addAttribute("error", strMensaje);
		model.addAttribute("todasLasOrdenes", daoOrden.findAll());
		return "homepage";
	}
	@RequestMapping(value = "/registrarcliente", method = RequestMethod.POST)
	public String registrarCliente(Model model) {

		model.addAttribute("nuevo", new Propietario());
		return "registrarCliente";
	}
	
	@RequestMapping(value = "/clienteregistrado", method = RequestMethod.POST)
	public String clienteRegistrado(Model model, @ModelAttribute Propietario propietario)
	{

		daoPropietario.save(propietario);
		
		String strMensaje = "";
		model.addAttribute("error", strMensaje);
		model.addAttribute("todasLasOrdenes", daoOrden.findAll());
		return "homepage";
	}
	
	@RequestMapping(value = "/imprimirorden", method = RequestMethod.GET)
	public String imprimirOrden(Model model, @RequestParam Long id){
	
		model.addAttribute("orden", daoOrden.findOne(id));
		return "imprimirOrden";
	}
	
	@RequestMapping(value = "/editarorden", method = RequestMethod.GET)
	public String editarOrden(Model model, @RequestParam Long id,
			@ModelAttribute("carrito") ArrayList<Paso> todosLosPasos){

	
		model.addAttribute("repuestos", daoRepuesto.findAll());
		model.addAttribute("orden", daoOrden.findOne(id));
		return "editarOrden";
	}
	
	@RequestMapping(value="/itemagregado", method=RequestMethod.POST)
	public String itemagregado(Model model, @ModelAttribute Orden orden,
			@ModelAttribute("carrito") ArrayList<Paso> todosLosPasos,
			@RequestParam long idrep,
			@RequestParam int cantidad,
			@RequestParam int minutos){
				
		Orden ordenaux = daoOrden.findOne(orden.getIdOrden());
		
		Paso pas = new Paso(daoRepuesto.findOne(idrep), cantidad, minutos , ordenaux);

		todosLosPasos.add(pas);
		
		model.addAttribute("todosLosPasos", todosLosPasos);
		model.addAttribute("repuestos", daoRepuesto.findAll());
		model.addAttribute("orden", ordenaux);
		return "editarOrden";
	}
	
	@RequestMapping(value = "/pasarpasosalaorden", method = RequestMethod.POST)
	public String pasarPasosALaOrden(Model model, @ModelAttribute Orden orden,
			@ModelAttribute("carrito") ArrayList<Paso> todosLosPasos) {

		Orden ordenaux = daoOrden.findOne(orden.getIdOrden());
			
		for(Paso pasoo:todosLosPasos){
			
			Item it = new Item();
			it.setCantidad(pasoo.getCantidad());
			it.setOrden(pasoo.getOrden());
			it.setRepuesto(pasoo.getRepuesto());
			it.setTiempoEnInstalar(pasoo.getTiempoEnInstalar());
			daoOrden.save(ordenaux);
			daoItem.save(it);
		}
		
		todosLosPasos.clear();

		model.addAttribute("carrito", todosLosPasos);
		model.addAttribute("repuestos", daoRepuesto.findAll());
		model.addAttribute("orden", ordenaux);
		return "editarOrden";
	}

}