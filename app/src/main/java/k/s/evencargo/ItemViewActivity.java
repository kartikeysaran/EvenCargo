package k.s.evencargo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ItemViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText edit_name, edit_price;
    Button btn_submit;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);
        setUpItemAddLayout();
    }
    private void setUpItemAddLayout() {
        edit_name = findViewById(R.id.edittext_name);
        edit_price = findViewById(R.id.edittext_price);
        btn_submit = findViewById(R.id.btn_submit);
        recyclerView = findViewById(R.id.recyclerView);
        CustomAdapter.arrayListName = new ArrayList<>();
        CustomAdapter.arrayListPrice = new ArrayList<>();
        CustomAdapter.arrayListName.add("Cookie");
        CustomAdapter.arrayListPrice.add("$25");
        customAdapter = new CustomAdapter(CustomAdapter.arrayListName, CustomAdapter.arrayListPrice);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        btn_submit.setOnClickListener(v->{
            if(edit_name.getText().toString().length()>=1 && edit_price.getText().toString().length()>=1)
            CustomAdapter.arrayListName.add(edit_name.getText().toString());
            CustomAdapter.arrayListPrice.add(edit_price.getText().toString());
            customAdapter.notifyDataSetChanged();
            edit_price.setText("");
            edit_name.setText("");
        });
    }


}

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    public static ArrayList<String> arrayListName;
    public static ArrayList<String> arrayListPrice;


    public CustomAdapter(ArrayList<String> arrayListName, ArrayList<String> arrayListPrice) {
        this.arrayListName = arrayListName;
        this.arrayListPrice = arrayListPrice;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        holder.item_TV_Name.setText(arrayListName.get(position));
        holder.item_TV_price.setText(arrayListPrice.get(position));
    }

    public int getItemCount() {
        return arrayListName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_TV_Name, item_TV_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_TV_price = itemView.findViewById(R.id.item_tV_price);
            item_TV_Name = itemView.findViewById(R.id.item_tV_name);
        }
    }
}