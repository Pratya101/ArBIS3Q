package bis.kkc.rmuti.hongmoonmang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PlaceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        Place place= (Place) getIntent().getSerializableExtra("place_key");

        TextView title = findViewById(R.id.title);
        ImageView cover = findViewById(R.id.cover);

        title.setText(place.getName());
        Glide.with(this).load(place.getThumbnail()).into(cover);
    }
}
