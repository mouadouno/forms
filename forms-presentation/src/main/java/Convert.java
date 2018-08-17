import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONException;

public class Convert {
	
	public Date stringtoDate(String dateString) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date date = new java.util.Date();
		 try {
				date = df.parse(dateString);
			  } catch (JSONException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
		 return new java.sql.Date(date.getTime());
	}
}
