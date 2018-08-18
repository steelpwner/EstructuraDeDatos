/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.util.Stack;


public class Json {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
     Gson gson= new Gson();
     miObjeto objetoNuevo= new miObjeto();
     String jsonText= gson.toJson(objetoNuevo);
     System.out.println(jsonText);
     try {
     FileWriter fw=new FileWriter("ejemplojson.json");
     fw.write(jsonText);
     fw.close();
         System.out.println("FUE COMPLETO");
     } catch (Exception e) {
      throw new Exception("NO SE PUDO GUARDAR");
     }
     
    }
  
    
}
