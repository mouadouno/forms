

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import entities.Personnel;
import entities.Projet;

/**
 * Servlet implementation class testServlet
 */
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SimpleClientHttpRequestFactory clientHttpReq = new SimpleClientHttpRequestFactory();
		RestTemplate rt = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		Convert convert = new Convert();
		//new HttpEntity<List<Projet>>(header)
		//ResponseEntity<List<Projet>> s = rt.exchange("http://localhost:8080/Projet/getAllProjet", HttpMethod.GET, null, new ParameterizedTypeReference<List<Projet>>() {});
		String action = request.getParameter("action");
		
		if(action != null)
		{
			if(action.equals("delete"))
			{
				rt.delete("http://localhost:8080/Personnel/deletePersonnel/"+request.getParameter("id"));
			}
			else if(action.equals("edit"))
			{
				ResponseEntity<Personnel> s = rt.getForEntity("http://localhost:8080/Personnel/getPersonnel/"+request.getParameter("id"), Personnel.class);
				
				 
				 request.setAttribute("model", s.getBody());
			}
		}
		
		ResponseEntity<Personnel[]> s = rt.getForEntity("http://localhost:8080/Personnel/getAllPersonnel", Personnel[].class);
		ResponseEntity<Projet[]> sProjet = rt.getForEntity("http://localhost:8080/Projet/getAllProjet", Projet[].class);
	
		request.setAttribute("projets", sProjet.getBody());
		
		request.setAttribute("personnels", s.getBody());
		
		request.getRequestDispatcher("test.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		Convert convert = new Convert();
		
		String action = request.getParameter("action");
		
		String mode = "ajout";
		request.setAttribute("mode", mode);
		
		if(action != null)
		{
			if(action.equals("post"))
			{
				
			Personnel P = new Personnel();
			
			//get New projet
		    ResponseEntity<Projet> sProjetNew = restTemplate.getForEntity("http://localhost:8080/Projet/getProjet/"+request.getParameter("projet"), Projet.class);
		    HttpEntity<Projet> httpEntitypOld = null;
		    
			 if(request.getParameter("id") != "")
			 {
				 int id= Integer.parseInt(request.getParameter("id"));
				 P.setIdPersonnel(id);
				 
				 //get Old projet
				 ResponseEntity<Projet> sProjetOld = restTemplate.getForEntity("http://localhost:8080/Projet/getProjetbyPerso/"+request.getParameter("id"), Projet.class);
				 
				 if(sProjetNew.getBody().getIdProjet() != sProjetOld.getBody().getIdProjet())
			     {
			    	 Iterator<Personnel> i = sProjetOld.getBody().getPersonnel().iterator();
			    	 while(i.hasNext())
			    	 {
			    		 Personnel temp = i.next();
			    		 if(temp.getIdPersonnel() == P.getIdPersonnel())
			    		 {
			    			 i.remove();
			    		 }
			    	 }
			    	 sProjetNew.getBody().getPersonnel().add(P);
			     }
				 
				 httpEntitypOld = new HttpEntity<Projet> (sProjetOld.getBody(), httpHeaders);
				 
			 }
	         String nom= request.getParameter("nom");
	         String prenom= request.getParameter("prenom");
	         String refog= request.getParameter("refog");
	         String statut= request.getParameter("statut");
	         String date=  request.getParameter("date");
	         
	         P.setNom(nom);
	         P.setPrenom(prenom);
	         P.setRefog(refog);
	         P.setStatut(statut);
	         
			 P.setDate_integration(convert.stringtoDate(date));
	
		     HttpEntity<Personnel> httpEntity = new HttpEntity<Personnel> (P, httpHeaders);		     
		     
		     if(httpEntitypOld != null)
		     {
		    	 restTemplate.postForObject("http://localhost:8080/Projet/addProjet", httpEntitypOld, Projet.class);
		     }	 	 
		     
		     if(request.getParameter("id") == "")
		     {
		    	 sProjetNew.getBody().getPersonnel().add(P);
		     }
		     
		     HttpEntity<Projet> httpEntitypNew = new HttpEntity<Projet> (sProjetNew.getBody(), httpHeaders);
		 	 restTemplate.postForObject("http://localhost:8080/Projet/addProjet", httpEntitypNew, Projet.class);
		 	 
		 	 
		 	 if(httpEntitypOld != null)
		 	 {
		 		 restTemplate.postForObject("http://localhost:8080/Personnel/addPersonnel", httpEntity, Personnel.class);
		 	 }
			}
			
		}
		//request.setAttribute("mod", json);
	 	this.doGet(request, response);
	
	}

}
