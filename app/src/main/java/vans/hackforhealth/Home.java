package vans.hackforhealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private StaggeredGridLayoutManager _sGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        _sGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(_sGridLayoutManager);

        List<Profile> sList = getListItemData();

        Adapter rcAdapter = new Adapter(
                Home.this, sList);
        recyclerView.setAdapter(rcAdapter);
    }

    private List<Profile> getListItemData()
    {
        List<Profile> listViewItems = new ArrayList<Profile>();
        listViewItems.add(new Profile("1984", "George Orwell"));
        listViewItems.add(new Profile("Pride and Prejudice", "Jane Austen"));
        listViewItems.add(new Profile("One Hundred Years of Solitude", "Gabriel Garcia Marquez"));
        listViewItems.add(new Profile("The Book Thief", "Markus Zusak"));
        listViewItems.add(new Profile("The Hunger Games", "Suzanne Collins"));
        listViewItems.add(new Profile("The Hitchhiker's Guide to the Galaxy", "Douglas Adams"));
        listViewItems.add(new Profile("The Theory Of Everything", "Dr Stephen Hawking"));

        return listViewItems;
    }
}
