package com.mirea.kt.android.kyrsovaya_yudakova;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FavoritesFragment extends Fragment {
    private RecyclerView recyclerView;
    private TermAdapter adapter;
    private List<Dictionary> favouritesList = new ArrayList<>();
    private MyAppSQLiteHelper sqLiteHelper;
    private FavoriteAdapter favoriteAdapter;

    public FavoritesFragment() {
        // Required empty public constructor
    }
    public void loadFavorites() {
        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
        List<Dictionary> favoritesList = new ArrayList<>();
        String selectQuery = "SELECT * FROM favorites";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                String term = cursor.getString(cursor.getColumnIndexOrThrow("term"));
                String definition = cursor.getString(cursor.getColumnIndexOrThrow("definition"));
                Dictionary favoriteTerm = new Dictionary(term, definition);
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                favoriteTerm.setId(id);
                favoritesList.add(favoriteTerm);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_favorites, container, false);
        // Получаем ссылки на RecyclerView и его LayoutManager
        RecyclerView recyclerView = v.findViewById(R.id.recyclerViewFav);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        List<Dictionary> favoritesList = new ArrayList<>(); // Здесь нужно получить избранные термины из SharedPreferences или базы данных
        FavoriteAdapter adapter = new FavoriteAdapter(getActivity(), favoritesList);
        recyclerView.setAdapter(adapter);

        // Загружаем избранные термины
        this.loadFavorites();



        return v;
    }





    }
