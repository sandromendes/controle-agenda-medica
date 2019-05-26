package main.java.br.com.eutimia.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.br.com.eutimia.model.ClientDB;
import main.java.br.com.eutimia.model.PlanoSaudeDB;
import main.java.br.com.eutimia.model.autenticacao.UsuarioDB;
import main.java.br.com.eutimia.service.ClientService;
import main.java.br.com.eutimia.service.MedicoService;
import main.java.br.com.eutimia.service.PacienteService;
import main.java.br.com.eutimia.service.PlanoSaudeService;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

@Controller
public class MainController {

	@Autowired
	ClientService aClientService;	
	
	@Autowired
	PacienteService aPacienteService;
	
	@Autowired
	PlanoSaudeService aPlanoSaudeService;
	
	@Autowired
	MedicoService aMedicoService;
	
	/*
	@ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "main/notfound";
    }*/
	
	@RequestMapping(value="/main/bootstrapSpringGrid")
	public ModelAndView bootstrapSpringGrid(){
		return new ModelAndView("/main/bootstrapSpringGrid");
	}
	
	@RequestMapping(value="/main/plano/home")
	public ModelAndView homePlanoSaude(){
		return new ModelAndView("/main/plano/home");
	}
	
    @RequestMapping(value = "/main/plano/formulario", method = RequestMethod.GET)
    public ModelAndView adicionarPlano(ModelAndView model) {
        PlanoSaudeDB planoSaudeDB = new PlanoSaudeDB();
        model.addObject(PlanoSaudeDB.ID_OBJETO, planoSaudeDB);
        model.setViewName("/main/plano/formulario");
        return model;
    }
    
    @RequestMapping(value = "/main/plano/{id}/editar", method = RequestMethod.GET)
    public ModelAndView editarPlano(HttpServletRequest request, 
    		HttpServletResponse response) {
        int planoSaudeId = Integer.parseInt(request.getParameter("planoSaudeId"));
        PlanoSaudeDB planoSaudeDB = this.aPlanoSaudeService.buscarPorId(planoSaudeId);
        ModelAndView model = new ModelAndView("/main/plano/formulario");
        model.addObject("planoSaude", planoSaudeDB);
 
        return model;
    }
 
    @RequestMapping(value = "/main/plano/salvar", method = RequestMethod.POST)
    public ModelAndView gravarPlano(HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @ModelAttribute PlanoSaudeDB planoSaudeDB) {
        if (planoSaudeDB.getaPlanoSaudeId() == null) {
        	UsuarioDB usuario = (UsuarioDB) request.getSession().getAttribute(UsuarioDB._USUARIO_AUTENTICADO);
        	if(usuario.getaUsuarioUUID() != null){
        		planoSaudeDB.setaAudUsuarioInclusao(usuario.getaUsuarioUUID());
        		planoSaudeDB.setaAudUsuarioAlteracao(usuario.getaUsuarioUUID());
        	}
        	this.aPlanoSaudeService.inserir(planoSaudeDB);
        } else {
        	this.aPlanoSaudeService.atualizar(planoSaudeDB);
        }
        return new ModelAndView("redirect:/main/plano/formulario");
    }
 
    @RequestMapping(value = "/main/plano/excluir", method = RequestMethod.GET)
    public ModelAndView removerPlano(HttpServletRequest request) {
        int planoSaudeId = Integer.parseInt(request.getParameter("planoSaudeId"));
        ArrayList<Integer> colecaoId = new ArrayList<Integer>();
        colecaoId.add(planoSaudeId);
        this.aPlanoSaudeService.removerPorId(colecaoId);
        return new ModelAndView("redirect:/homePlanoSaude");
    }
    
    @RequestMapping(value="/main/plano/listarTodos", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView listarTodosPlanos(HttpServletRequest req, HttpServletResponse resp){
		List<PlanoSaudeDB> listaPlanos = aPlanoSaudeService.buscarTodos();	
		Gson gson = new Gson();
		String listaPlanosString = gson.toJson(listaPlanos, new TypeToken<ArrayList<PlanoSaudeDB>>() {}.getType());
		JSONArray listPlanosJSON = new JSONArray(listaPlanosString);
		
        ModelAndView model = new ModelAndView("/main/plano/home");
        model.addObject("planos", listPlanosJSON);
		
		return model;
	}
	
	@RequestMapping(value="/getAllClients", method=RequestMethod.POST)
	@ResponseBody
	public List<ClientDB> getAllClients(HttpServletRequest req, HttpServletResponse resp){
		List<ClientDB> listClientDB = aClientService.getAllClients();
		return listClientDB;
	}
	
	@RequestMapping(value="/insertClient", method=RequestMethod.POST)
	@ResponseBody
	public boolean insertClient(HttpServletRequest req, HttpServletResponse resp ) throws ParseException{
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		String name = req.getParameter("name") == null ? "": req.getParameter("name");
		String lastname = req.getParameter("lastname") == null ? "" : req.getParameter("lastname");
		String dateBirth = req.getParameter("dateBirth") == null ? "": req.getParameter("dateBirth");
		String register = req.getParameter("register") == null ? "": req.getParameter("register");
		
		ClientDB clientDB = new ClientDB();
		clientDB.setCliName(name);
		clientDB.setCliLastname(lastname);
		clientDB.setCliDatebirth(dateFormat.parse(dateBirth));
		clientDB.setCliRegister(register);
		
		boolean bok = aClientService.insertClient(clientDB);
		return bok;
	}
	
	@RequestMapping(value="/deleteClient", method=RequestMethod.POST)
	@ResponseBody
	public boolean deleteClient( HttpServletRequest req, HttpServletResponse resp ) throws ParseException{
		
		String checked = req.getParameter("checked") == null ? "": req.getParameter("checked");
		ArrayList<BigDecimal> decArray = new ArrayList<BigDecimal>();
		for( String s : checked.split(",") ){
			decArray.add( new BigDecimal(s) );
		}
		
		boolean bok = aClientService.deleteClientsByNumber(decArray);
		return bok;
	}
}
