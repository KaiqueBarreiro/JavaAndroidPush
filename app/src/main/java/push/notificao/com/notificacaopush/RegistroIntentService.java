package push.notificao.com.notificacaopush;


import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by Kaique Barreiro on 21/06/2018.
 */

public class RegistroIntentService {

    private String token;

    public void onTokenRefresh() {
        //recebe o token do firebase, que será salvo no psw para receber push notifications
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.i("", "Seu token é: " + refreshedToken);
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token) {
        //aqui você pode trablhar para enviar o token para um servidor, para gravar em banco ou para otificar outro dispositivo através de um servidor
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
