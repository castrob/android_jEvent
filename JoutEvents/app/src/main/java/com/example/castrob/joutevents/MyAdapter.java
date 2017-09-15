package com.example.castrob.joutevents;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by castro on 9/14/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<Invitee> inviteeList;
    private Context context;

    public MyAdapter(List<Invitee> inviteeList, Context context){
        this.inviteeList = inviteeList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.invitee_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Invitee invitee = inviteeList.get(position);
        holder.textViewNameInvitee.setText((invitee.getName()));
        holder.textViewContactInvitee.setText((invitee.getContact()));
        holder.textViewEmailInvitee.setText((invitee.getEmail()));
    }

    @Override
    public int getItemCount() {
        return inviteeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewNameInvitee;
        public TextView textViewContactInvitee;
        public TextView textViewEmailInvitee;

        public ViewHolder(View itemView){
            super(itemView);

            textViewNameInvitee = (TextView) itemView.findViewById(R.id.tv_fullname);
            textViewContactInvitee = (TextView) itemView.findViewById(R.id.tv_fonenumber);
            textViewEmailInvitee = (TextView) itemView.findViewById(R.id.tv_email);
        }
    }
}
