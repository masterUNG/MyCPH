package appewtc.masterung.mycph;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by masterUNG on 4/27/2017 AD.
 */

public class MyAdapter extends BaseAdapter{

    private Context context;
    private String[] nameStrings, dateStrings, detailStrings;

    public MyAdapter(Context context,
                     String[] nameStrings,
                     String[] dateStrings,
                     String[] detailStrings) {
        this.context = context;
        this.nameStrings = nameStrings;
        this.dateStrings = dateStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return nameStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        TextView nameTextView = (TextView) view1.findViewById(R.id.txtName);
        TextView dateTextView = (TextView) view1.findViewById(R.id.txtDate);
        TextView detailTextView = (TextView) view1.findViewById(R.id.txtDetail);

        nameTextView.setText(nameStrings[i]);
        dateTextView.setText(dateStrings[i]);
        detailTextView.setText(detailStrings[i]);

        return view1;
    }
}   // Main Class
