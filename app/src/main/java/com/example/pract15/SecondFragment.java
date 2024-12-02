package com.example.pract15;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private int visitCount = 0;
    private MenuItem menuItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
        return view;
    }

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(getActivity(), v);
        popupMenu.inflate(R.menu.popup_menu);
        menuItem = popupMenu.getMenu().findItem(R.id.visit_count);
        menuItem.setTitle("Посещений: " + visitCount);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.increment_visit_count) {
                    visitCount++;
                    menuItem.setTitle("Посещений: " + visitCount);
                } else if (item.getItemId() == R.id.reset_visit_count) {
                    visitCount = 0;
                    menuItem.setTitle("Посещений: " + visitCount);
                }
                return true;
            }
        });
        popupMenu.show();
    }
}