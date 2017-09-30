package com.example.castrob.joutevents;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by castro on 9/14/17.
 */

public class InviteeAdapter extends RecyclerView.Adapter<InviteeAdapter.ViewHolder> {

    private List<Invitee> inviteeList;
    private Context context;
    private Event event;

    public List<Invitee> getInviteeList() {
        return inviteeList;
    }

    public void setInviteeList(List<Invitee> inviteeList) {
        this.inviteeList = inviteeList;
    }

    public InviteeAdapter(List<Invitee> inviteeList, Event event ,Context context){
        this.event = event;
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


    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        public TextView textViewNameInvitee;
        public TextView textViewContactInvitee;
        public TextView textViewEmailInvitee;
        public Button buttonRemoveInvitee;
        public Button buttonSendMessage;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewNameInvitee = itemView.findViewById(R.id.tv_fullname);
            textViewContactInvitee = itemView.findViewById(R.id.tv_fonenumber);
            textViewEmailInvitee = itemView.findViewById(R.id.tv_email);
            buttonRemoveInvitee = itemView.findViewById(R.id.btn_removeInvitee);
            buttonSendMessage = itemView.findViewById(R.id.btn_sendmessage);

            buttonRemoveInvitee.setOnClickListener(this);
            buttonSendMessage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_removeInvitee:
                    inviteeList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    break;
                case R.id.btn_sendmessage:
                    try {
                        Intent sendIntent = new Intent("android.intent.action.MAIN");
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.setType("text/plain");
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "Olá você foi convidado por:" + event.getOrganizer().getName() +
                                " para o Evento: " + event.getEventName() + "que acontecerá no dia/horário: " + event.getDateBegin());
                        sendIntent.setPackage("com.whatsapp");
                        context.startActivity(sendIntent);
                    } catch(Exception e) {
                        Toast.makeText(context, "Error/n" + e.toString(), Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }
}
