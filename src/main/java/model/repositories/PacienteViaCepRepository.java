package model.repositories;

import com.google.gson.Gson;
import model.entities.EnderecoViaCep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PacienteViaCepRepository {

    public static EnderecoViaCep findEndereco(String cep) {
        if(cep.length()!=8) {
            return null;
        }
        try {
            URL url = new URL("https://viacep.com.br/ws/"+cep+"/json");
            HttpURLConnection conect = (HttpURLConnection) url.openConnection();
            conect.setRequestMethod("GET");
            BufferedReader data = new BufferedReader(new InputStreamReader(conect.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while((inputLine = data.readLine())!=null) {
                response.append(inputLine);
            }
            data.close();
            Gson gson = new Gson();
            return gson.fromJson(response.toString(), EnderecoViaCep.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
