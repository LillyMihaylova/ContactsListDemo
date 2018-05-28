package com.example.demo.contactsapp.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demo.contactsapp.R;
import com.example.demo.contactsapp.models.Contact;

import java.util.ArrayList;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    private Context context;
    private ArrayList<Contact> contacts;
    private ContactsViewHolder.OnItemClickListener listener;

    public ContactsAdapter(Context context, ArrayList<Contact> contacts,
                           ContactsViewHolder.OnItemClickListener listener) {
        this.context = context;
        this.contacts = contacts;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_layout, parent, false);

        return new ContactsViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, final int position) {
        holder.txtName.setText(contacts.get(position).getName());
        holder.txtEmail.setText(contacts.get(position).getEmail());
        holder.txtPhone.setText(contacts.get(position).getPhoneNumber());
        holder.imgUserFace.setImageDrawable(context.getDrawable(R.drawable.contact_icon));

        holder.grpContactItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(contacts.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactsViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtPhone;
        private TextView txtEmail;
        private ImageView imgUserFace;
        private LinearLayout grpContactItem;

        public ContactsViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtPhone = itemView.findViewById(R.id.txt_phone);
            txtEmail = itemView.findViewById(R.id.txt_email);
            grpContactItem = itemView.findViewById(R.id.grp_contact_item);
            imgUserFace = itemView.findViewById(R.id.img_user_face);

        }

        public interface OnItemClickListener {
            void onItemClicked(Contact contact);
        }
    }
}
