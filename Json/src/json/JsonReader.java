/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author dmolina
 */

public class JsonReader {

    public static void main(String[] args) throws FileNotFoundException, IOException  {
        JSONParser parser= new JSONParser();
        try {
        Object obj = parser.parse(new FileReader("document.json"));
                JSONObject objetoJson=(JSONObject)obj;
                System.out.println(objetoJson);
                String cedula=(String) objetoJson.get("cedula");
                
                System.out.println("La cédula de: "+objetoJson.get("Nombres")+" "+objetoJson.get("Apellidos")+" Es: "+cedula);
            } catch (ParseException ex) {
            Logger.getLogger(JsonReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
