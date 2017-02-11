package bu.chanhom.mananya.helpmeplease;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by masterUNG on 2/11/2017 AD.
 */

public class BlindAdapter extends BaseAdapter{

    private Context context;
    private String[] plateStrings;

    public BlindAdapter(Context context, String[] plateStrings) {
        this.context = context;
        this.plateStrings = plateStrings;
    }

    @Override
    public int getCount() {
        return plateStrings.length;
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
        View view1 = layoutInflater.inflate(R.layout.list_blind, viewGroup, false);

        TextView textView = (TextView) view1.findViewById(R.id.textView4);

        textView.setText(plateStrings[i]);

        return view1;
    }
}   // Main Class
