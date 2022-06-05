package com.example.multigaming;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.stream.Stream;

public class SearchActivity extends Fragment {
    Activity context;
    Button exit;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<ElementModel> element;
    Searchadapter adapter;
    private Searchadapter.RecycleViewClickListener listener;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        View root =  inflater.inflate(R.layout.search_activity, container, false);
        recyclerView = root.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        element = new ArrayList<>();
        element.add(new ElementModel(R.drawable.image1,"Quiz"));
        element.add(new ElementModel(R.drawable.image2,"Tictactoe"));
        element.add(new ElementModel(R.drawable.image11,"Calculator"));
        element.add(new ElementModel(R.drawable.image12,"Snake"));

//        initData();
//        initRecycleview();
        setOnClickListener();
        recyclerView.setAdapter(new Searchadapter(element, listener));
        return root;
    }

    private void setOnClickListener() {
        listener = new Searchadapter.RecycleViewClickListener() {
            @Override
            public void onclick(View v, int position) {
                ElementModel s = element.get(position);
                String s1 = s.getgame();
                if(s1.equals("Quiz")){
                    Intent intent = new Intent( context,Quiz_Activity.class);
                    startActivity(intent);
                }
                else if(s1.equals("Tictaktoe")){
                    Intent intent = new Intent( context,TikTakTokActivity.class);
                    startActivity(intent);
                }
                else if(s1.equals("Calculator")){
                    Intent intent = new Intent( context,CalculatorActivity.class);
                    startActivity(intent);
                }
                else if(s1.equals("Snake")){
                    Intent intent = new Intent( context,SettingActivity.class);
                    startActivity(intent);
                }
            }
        };

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.exampl_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("query",query );
                return false;
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onQueryTextChange(String newText) {
           //  adapter.getFilter();
                Log.d("search",newText );
                String s1 = "Quiz";
                String s2 = "Tictactoe";
                String s3 = "Calculator";
                String s4 = "Snake";
                element.removeAll(element);
               if (s1.contains(newText)){
                   element.add(new ElementModel(R.drawable.image1,"Quiz"));
//                   element.add(new ElementModel(R.drawable.image2,"Tictactoe"));
//                   element.add(new ElementModel(R.drawable.image11,"Calculator"));
//                   element.add(new ElementModel(R.drawable.image12,"Snake"));
//
//                   recyclerView.setAdapter(new Searchadapter(element, listener));

               }
              if (s2.contains(newText)){
                   element.add(new ElementModel(R.drawable.image2,"Tictactoe"));
//                   element.add(new ElementModel(R.drawable.image11,"Calculator"));
//                   element.add(new ElementModel(R.drawable.image12,"Snake"));
//
//                   recyclerView.setAdapter(new Searchadapter(element, listener));

               }
                if (s3.contains(newText)){
                    element.add(new ElementModel(R.drawable.image11,"Calculator"));
                }
                if (s4.contains(newText)){
                    element.add(new ElementModel(R.drawable.image12,"Snake"));
                }
//                if (newText.contains("")){
//                    element.add(new ElementModel(R.drawable.image1,"Quiz"));
//                   element.add(new ElementModel(R.drawable.image2,"Tictactoe"));
//                   element.add(new ElementModel(R.drawable.image11,"Calculator"));
//                   element.add(new ElementModel(R.drawable.image12,"Snake"));
//
//                }


                return false;
            }
        });

        super.onCreateOptionsMenu(menu,inflater);

    }
}
