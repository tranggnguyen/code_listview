package thutrang.tt.list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import thutrang.tt.list.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    TextView add,remove;
    String[] fruitList ={"apple","banana","strawberry","orange","melon"};
    int fruitImages []= new int[]{R.drawable.apple, R.drawable.banana, R.drawable.dau, R.drawable.orange, R.drawable.melon};
    String[] content ={"Tuơi ngon","Giàu vitamin","Ngon bổ rẻ","Cam tươi","Chín mọng ,nhiều nước"};
    String[] money = {"40$","20$","60$","50$","30$"};
    ListView lv;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        ArrayList<food> foodArrayList = new ArrayList<>();
        for(int i = 0 ; i< fruitList.length; i++ ){
            food fd = new food(fruitList[i],content[i], money[i], fruitImages[i],"","");
            foodArrayList.add(fd);
        }
        ArrayList<food> foods = new ArrayList<>();
        for(int i = 0 ; i< fruitList.length; i++ ){
            food fd = new food(fruitList[i],content[i], money[i], fruitImages[i],"","");
            foodArrayList.remove(fd);
        }
        ListAdapter listAdapter = new ListAdapter(MainActivity.this,foodArrayList);
        binding.lv.setAdapter(listAdapter);
        binding.lv.setClickable(true);
        binding.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent kk =new Intent(MainActivity.this,foodInfo.class);
                kk.putExtra("title",fruitList[position]);
                kk.putExtra("content",content[position]);
                kk.putExtra("money",money[position]);
                kk.putExtra("imageid",fruitImages[position]);
                startActivity(kk);
            }
        });
        
    }
}