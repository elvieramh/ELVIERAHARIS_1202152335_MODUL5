package android.elviera.com.elvieraharis_202152335_modul5;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by elviera on 3/25/2018.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.holder> {
    //deklarasi variable
    private Context context;
    private List<AddData> list;
    int color;

    //konstruktor
    public Adapter(Context context, List<AddData> list, int color){
        this.context=context;
        this.list=list;
        this.color=color;
    }

    //menentukan viewholder recyclerview
    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {

        //membuat view baru
        View view = LayoutInflater.from(context).inflate(R.layout.list_cardview, parent, false);
        holder holder = new holder(view);
        return holder;
    }

    //menyetting nilai yang didapatkan pada viewholder
    @Override
    public void onBindViewHolder(holder holder, int position) {
        AddData data = list.get(position);
        holder.ToDo.setText(data.getTodo());
        holder.Description.setText(data.getDesc());
        holder.Priority.setText(data.getPrior());
        holder.cardView.setCardBackgroundColor(context.getResources().getColor(this.color));
    }

    //mendapatkan jumlah list
    @Override
    public int getItemCount() {
        return list.size();
    }

    //mendapatkan list dari adapter
    public AddData getData(int position){
        return list.get(position);
    }

    //untuk menghapus list pada todolist
    public void deleteData(int i){

        //remove item yang terpilih
        list.remove(i);

        //notifikasi item yang di remove
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, list.size());
    }

    class holder extends RecyclerView.ViewHolder{
        //deklarasi variable
        public TextView ToDo, Description, Priority;
        public CardView cardView;
        public holder(View itemView){
            super(itemView);

            //mengakses id textview pada layout dan juga cardview
            ToDo = itemView.findViewById(R.id.headline);
            Description = itemView.findViewById(R.id.explanation);
            Priority = itemView.findViewById(R.id.number);
            cardView = itemView.findViewById(R.id.cardlist);
        }
    }
}