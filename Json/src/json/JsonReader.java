/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

/**
 *
 * @author dmolina
 */
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class JsonReader {

    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader bf = new BufferedReader(new FileReader("ejemplojson.json"));
        miObjeto json= gson.fromJson(bf, miObjeto.class);
        
        System.out.println(json.getClass());
        System.out.println(json.toString());
    }
}
