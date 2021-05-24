package zh.yen.novaeducation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class RequestPage extends AppCompatActivity {
    ImageView back;
    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_request_page );

        back = findViewById ( R.id.image_Back);

        back.setOnClickListener ( new View.OnClickListener () {
            @Override
            public
            void onClick(View v) {
                Intent i = new Intent (RequestPage.this,UniversityPage.class);
                startActivity ( i );
            }
        } );
    }
}