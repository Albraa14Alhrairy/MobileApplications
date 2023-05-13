package RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.alhrairyalbraa.tasksscheduling.R;

import java.util.List;

import DatabaseHandler.Tasks;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<Tasks> tasks;

    public MyAdapter(Context context, List<Tasks> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        Tasks task = tasks.get(position);
        holder.id.setText("Id : " + String.valueOf(task.getId()));
        holder.name.setText("Name : " + task.getName());
        holder.desc.setText("Description : " + task.getDesc());
        holder.start.setText("Start Time : " + task.getStart());
        holder.end.setText("End Time : " + task.getEnd());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, desc, start, end;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.i);
            name = itemView.findViewById(R.id.n);
            desc = itemView.findViewById(R.id.d);
            start = itemView.findViewById(R.id.s);
            end = itemView.findViewById(R.id.e);
        }
    }
}
