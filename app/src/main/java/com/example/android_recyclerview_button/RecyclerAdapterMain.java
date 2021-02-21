package com.example.android_recyclerview_button;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterMain extends RecyclerView.Adapter<RecyclerAdapterMain.ViewHolder> {

    private ArrayList<String> arrayList = new ArrayList<>();
    private Context context;


    public RecyclerAdapterMain(Context context, ArrayList<String> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_recyclerview_insidelayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(arrayList.get(position));
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.activity_main_recyclerview_insidelayout_textView);
            button = itemView.findViewById(R.id.activity_main_recyclerview_insidelayout_button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SharedPreferences.Editor editor = context.getSharedPreferences("PASSARTEXTOVIEW", Context.MODE_PRIVATE).edit();

                    String textoDaRow = textView.getText().toString();

                    editor.putString("STRINGROW", textoDaRow);
                    editor.commit();

                    context.startActivity(new Intent(context, ItemActivity.class));
                }
            });

        }

        public void bindView(String s) {
            textView.setText(s);
        }
    }
}
