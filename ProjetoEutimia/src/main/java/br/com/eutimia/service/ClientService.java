package main.java.br.com.eutimia.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import main.java.br.com.eutimia.model.ClientDB;


/**
 * 
 * @author 
 *
 */
public interface ClientService {

	public List<ClientDB> getAllClients();
	
	public List<ClientDB> getClientByName(String name);
	
	public boolean insertClient(ClientDB clientDB);
	
	public boolean updateClient(ClientDB clientDB);
	
	public boolean deleteClient(ClientDB clientDB);
	
	public boolean deleteClientsByNumber(ArrayList<BigDecimal> cliNumbers);
}
