package co.com.solati.micovinoc.models;

import com.google.gson.JsonObject;

import java.util.List;

public class casoDePruebaModel {

    public static JsonObject ConstruirJSON(List<String> titulos, List<String> datos){
        JsonObject object = new JsonObject();
        JsonObject lodeadentro = new JsonObject();
        for (int i=0;i<titulos.size();i++){
            object.addProperty(titulos.get(i),datos.get(i));
        }
        lodeadentro.addProperty("prueba","miramos q pasa");
        lodeadentro.addProperty("agregamos otra cosa","otra cosa");
        object.add("lodeadentro", lodeadentro);
        return object;
    }
}
