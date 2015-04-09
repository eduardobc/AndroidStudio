package g4a.quadratin.mx.quadratin;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by eduardo on 4/9/15.
 */
public class drawer_fragment extends Fragment {

    public static final String ARG_ARTICLES_NUMBER = "articles_number";

    public drawer_fragment() {
        // Constructor vacío obligatorio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_1, container, false);
        int i = getArguments().getInt(ARG_ARTICLES_NUMBER);
        String article = getResources().getStringArray(R.array.Tags)[i];

        getActivity().setTitle(article);
        TextView headline = (TextView)rootView.findViewById(R.id.textView);
        headline.append(" "+article);

        return rootView;
    }

    public void changeContentFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, drawer_fragment.this).commit();
    }
}
