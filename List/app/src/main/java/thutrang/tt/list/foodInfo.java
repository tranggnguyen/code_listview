package thutrang.tt.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import thutrang.tt.list.databinding.ActivityFoodInfoBinding;

public class foodInfo extends AppCompatActivity {

    ActivityFoodInfoBinding binding;
    TextView back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        back= (TextView)findViewById(R.id.back) ;
        back.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backman = new Intent(foodInfo.this,MainActivity.class);
                startActivity(backman);
            }
        });
        Intent intent = this.getIntent();
        if (intent !=null){
            String title = intent.getStringExtra("title");
            String content = intent.getStringExtra("content");
            String money = intent.getStringExtra("money");
            int imageid = intent.getIntExtra("imageid",R.drawable.apple);

            binding.title.setText(title);
            binding.content.setText(content);
            binding.money.setText(money);
            binding.img.setImageResource(imageid);
        }
    }
}