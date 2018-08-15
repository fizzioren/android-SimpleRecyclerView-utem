package my.edu.utem.simplerecyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        CustomAdapter adapter=new CustomAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    //step untuk buat table
    //findviewbyid untuk row
    //lebih kpd layout utk repated row
    public class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView wordTextView;
        //inflater ialah untuk buka table dalam layout ni
        public CustomViewHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.custom_row,parent,false));
            wordTextView =itemView.findViewById(R.id.wordTextView);
        }
    }
    //adapter untuk link UI dan data
    //ada 3 constructor
    //custom_row akan declare kat sini
    public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder>{

            public final String[] restaurantNames;
            public CustomAdapter(Context context){
            Resources resources = context.getResources();
            restaurantNames=resources.getStringArray(R.array.restaurant_name);
    }
        @NonNull
        @Override
        //nak buka table
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new CustomViewHolder(LayoutInflater.from(viewGroup.getContext()),viewGroup);

        }

        //nak tunjuk apa dalam row
        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
            customViewHolder.wordTextView.setText(restaurantNames[i]);
        }
        // berapa kali nak repeat
        @Override
        public int getItemCount() {
            return restaurantNames.length;
        }
    }
}
