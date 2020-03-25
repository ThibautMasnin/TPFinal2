package masnin.thibaut.tpfinal.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;

import masnin.thibaut.tpfinal.MainActivity;
import masnin.thibaut.tpfinal.Model.Pays;
import masnin.thibaut.tpfinal.R;

public class PaysAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Pays> countryList = null;

    public PaysAdapter(Context aContext) {
        super();

        context=aContext;
        inflater=LayoutInflater.from(context);

        countryList=new ArrayList<Pays>();
        countryList.add(new Pays("https://restcountries.eu/data/afg.svg", "Afghanistan", "Asia", "Southern Asia"));
        countryList.add(new Pays("https://restcountries.eu/data/ala.svg", "Åland Islands", "Europe", "Northern Europe"));
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int n) {
        return countryList.get(n);
    }

    @Override
    public long getItemId(int n) {
        return n;
    }

    @Override
    public View getView(int n, View convertView, ViewGroup parent) {
        View layoutItem;

        if(convertView == null) {
            layoutItem = (RelativeLayout) inflater.inflate(R.layout.country_layout, parent, false);
        }
        else {
            layoutItem = (RelativeLayout) convertView;
        }

        ImageView image = (ImageView) layoutItem.findViewById(R.id.image);
        Uri uri = Uri.parse("https://restcountries.eu/data/"+this.countryList.get(n).getFlag()+".svg");
        GlideToVectorYou.justLoadImage(MainActivity.class, uri, image)

        TextView title = (TextView) layoutItem.findViewById(R.id.title);
        title.setText(this.countryList.get(n).getName());

        TextView description = (TextView) layoutItem.findViewById(R.id.description);
        description.setText("Continent : " + this.countryList.get(n).getRegion() + "\n" + "Sous-continent : " + this.countryList.get(n).getSubregion());

        return layoutItem;
    }
}
