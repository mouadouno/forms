

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.google.gson.reflect.TypeToken;

import entities.Personnel;
import entities.Projet;

/**
 * Servlet implementation class testServlet
 */
public class testServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet2() {
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
				rt.delete("http://localhost:8080/Projet/deleteProjet/"+request.getParameter("id"));
			}
			else if(action.equals("edit") || action.equals("view"))
			{
				ResponseEntity<Projet> s = rt.getForEntity("http://localhost:8080/Projet/getProjet/"+request.getParameter("id"), Projet.class);
				 
				 request.setAttribute("model", s.getBody());
			}
		}
		
		ResponseEntity<Projet[]> s = rt.getForEntity("http://localhost:8080/Projet/getAllProjet", Projet[].class);
		ResponseEntity<Personnel[]> sPersonnel = rt.getForEntity("http://localhost:8080/Personnel/getAllPersonnel", Personnel[].class);
		
		request.setAttribute("personnel", sPersonnel.getBody());
		
		request.setAttribute("projects", s.getBody());
		
		request.getRequestDispatcher("test2.jsp").forward(request, response);
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
				
				Projet P = new Projet();
				
			 if(request.getParameter("id") != "")
			 {
				 int id= Integer.parseInt(request.getParameter("id"));
				 P.setIdProjet(id);
				 
				 ResponseEntity<Projet> sProjet = restTemplate.getForEntity("http://localhost:8080/Projet/getProjet/"+id, Projet.class);
				 P.setPersonnel(sProjet.getBody().getPersonnel());
			 }
			 
	         String nom= request.getParameter("nom");
	         String date_debut=  request.getParameter("date_debut");
	         String date_fin=  request.getParameter("date_fin");

	         P.setNom(nom);

	         ResponseEntity<Personnel> s = restTemplate.getForEntity("http://localhost:8080/Personnel/getPersonnel/"+request.getParameter("responsable"), Personnel.class);
	         
	         P.setDate_debut(convert.stringtoDate(date_debut));
			 P.setDate_fin(convert.stringtoDate(date_fin));
         
	         P.setResponsable(s.getBody());
	         
	
		     HttpEntity<Projet> httpEntity = new HttpEntity<Projet> (P, httpHeaders);
		     
		 	 restTemplate.postForObject("http://localhost:8080/Projet/addProjet", httpEntity, Projet.class);
			}
		}
		//request.setAttribute("mod", json);
	 	this.doGet(request, response);
	
	}

}
