package test.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import test.presenter.feature1.Feature1Presenter;

class Feature1ListViewHelper {

    private final ArrayAdapter<String> adapter;

    Feature1ListViewHelper(ListView listView, Feature1Presenter presenter) {
        adapter = new ArrayAdapter<>(listView.getContext(), android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new MyOnItemClickListener(presenter));
    }

    void addData(String data) {
        adapter.add(data);
        adapter.notifyDataSetChanged();
    }


    private class MyOnItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        private final Feature1Presenter presenter;

        public MyOnItemClickListener(Feature1Presenter presenter) {

            this.presenter = presenter;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            presenter.onDataSelected(adapter.getItem(position));
        }
    }
}
