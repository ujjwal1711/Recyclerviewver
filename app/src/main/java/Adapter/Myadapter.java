package Adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recycler.recyclerviewver.Details;
import com.example.recycler.recyclerviewver.R;

import java.util.List;

import Model.ListItem;

/**
 * Created by UjjwalNUtsav on 31-12-2017.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private Context context;
    private List<ListItem> listItems;

    public Myadapter(Context context, List listitem)
    {
     this.context=context;
        this.listItems=listitem;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Myadapter.ViewHolder holder, int position) {
        ListItem item =listItems.get(position);
    holder.name.setText(item.getName());
    holder.description.setText(item.getDescription());

    }

    @Override
    public int getItemCount() {

        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView description;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name =(TextView) itemView.findViewById(R.id.title);
            description=(TextView) itemView.findViewById(R.id.description);
        }

        @Override
        public void onClick(View v) {
         int position = getAdapterPosition();
            ListItem item = listItems.get(position);
            Intent intent =new Intent(context, Details.class);
            intent.putExtra("name",item.getName());
            intent.putExtra("description",item.getDescription());
            context.startActivity(intent);
           // Toast.makeText(context,item.getName(),Toast.LENGTH_SHORT).show();
        }
    }
}
