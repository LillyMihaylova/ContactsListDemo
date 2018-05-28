package com.example.demo.contactsapp.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.demo.contactsapp.R;
import com.example.demo.contactsapp.models.Contact;
import com.example.demo.contactsapp.ui.adapters.ContactsAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        ContactsAdapter.ContactsViewHolder.OnItemClickListener {

    private ArrayList<Contact> contacts;
    private Contact contact;
    private RecyclerView recyclerView;
    private ContactsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = new ArrayList<>();
        contact = new Contact();
        buildList();

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContactsAdapter(this, contacts, this);
        recyclerView.setAdapter(adapter);
    }

    private void buildList() {
        for (int i = 0; i < 100; i++) {
            contact = new Contact("Pesho" + i,
                    i + "5562145214", "pesho" + i + "@mail.com");
            contacts.add(contact);
        }

    }

    @Override
    public void onItemClicked(Contact contact) {
        Toast.makeText(this, contact.getName()
                        + " " + contact.getEmail() + " " + contact.getPhoneNumber(),
                Toast.LENGTH_SHORT).show();
    }
}
