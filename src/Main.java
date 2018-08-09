import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class Main {

	public final static String TOKEN = "INSERIR SEU TOKEN DO DISPOSITIVO AQUI";
	public final static String KEY_SERVIDOR = "INSERIR A CHAVE DO SERVIDOR FIREBASE AQUI";
	public final static String LINK_SEND = "https://fcm.googleapis.com/fcm/send";

	public static void main(String[] args) {
		new Main().enviarPushAplicativo("Titulo Da notificação", "Corpo da notificação", TOKEN);
	}

	public void enviarPushAplicativo(String titulo, String texto, String tokenUsario) {
		JSONObject json = new JSONObject();
		try {
			json.put("to", tokenUsario);
			JSONObject data = new JSONObject();
			data.put("body", texto);
			data.put("title", titulo);
			json.put("data", data);
			URL url;
			try {
				url = new URL(LINK_SEND);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("Authorization", "key=" + KEY_SERVIDOR);
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(json.toString().getBytes("UTF-8"));
				outputStream.close();
				conn.getInputStream();
				System.out.println("Celular notificado via Push Notification:");
			} catch (MalformedURLException ex) {
				System.out.println("Classe: PushSendNotification - Erro ao formatar JSON. " + ex.toString());
				ex.printStackTrace();
			} catch (IOException e) {
				System.out.println("Classe: PushSendNotification - Erro ao enviar Push ao android. " + e.toString());
				e.printStackTrace();
			}
		} catch (JSONException e) {
			System.out.println("Ocorreu erro no JSON - " + e.toString());
			e.printStackTrace();
		}
	}
}
