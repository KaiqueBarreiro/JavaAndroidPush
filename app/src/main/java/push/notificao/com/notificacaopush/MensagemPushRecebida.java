package push.notificao.com.notificacaopush;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MensagemPushRecebida extends AppCompatActivity {

    private TextView txtTitulo;
    private TextView txtMensagem;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.recebe_push);
        Intent intent = getIntent();
        bundle = intent.getExtras();
        String title = bundle.getString("Titulo");
        String msg = bundle.getString("Mensagem");
        txtTitulo = findViewById(R.id.textTitle);
        txtTitulo.setText(title);
        txtMensagem = findViewById(R.id.txtMsg);
        txtMensagem.setText(msg);
    }
}
