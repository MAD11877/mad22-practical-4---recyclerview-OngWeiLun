package sg.edu.np.mad.p02.activity1;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<UserViewHolder> {

    ArrayList<MainActivity.User> data;

    public ListAdapter(ArrayList<MainActivity.User> userList){
        data = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(
            ViewGroup parent,
            int viewType
    ){
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_block,
                        parent,
                        false);
        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder(
            @NonNull UserViewHolder holder,
            int position
    ){
        MainActivity.User s = data.get(position);
        holder.description.setText(s.description);
        holder.username.setText(s.name);

    }

    @Override
    public int getItemCount(){
        return data.size();
    }
}
