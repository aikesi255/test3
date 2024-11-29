package com.example.test3_4;

import android.os.Bundle;

import com.example.test3_4.R;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.ActionMode;
import android.view.MenuInflater;


import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> items;
    private boolean[] selectedItems;
    private ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        items = new ArrayList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        selectedItems = new boolean[items.size()];
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, items);
        listView.setAdapter(adapter);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu_context, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                if (item.getItemId() == R.id.menu_delete) {
                    deleteSelectedItems();
                    mode.finish();
                    return true;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                actionMode = null;
                for (int i = 0; i < selectedItems.length; i++) {
                    selectedItems[i] = false;
                    listView.setItemChecked(i, false);
                }
            }

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                selectedItems[position] = checked;
                updateActionModeTitle(mode);
            }

            private void updateActionModeTitle(ActionMode mode) {
                int count = 0;
                for (boolean selected : selectedItems) {
                    if (selected) {
                        count++;
                    }
                }
                mode.setTitle(count + " 个被选中");
            }
        });
    }

    private void deleteSelectedItems() {
        for (int i = selectedItems.length - 1; i >= 0; i--) {
            if (selectedItems[i]) {
                items.remove(i);
                adapter.remove(items.get(i));
            }
        }
    }
}