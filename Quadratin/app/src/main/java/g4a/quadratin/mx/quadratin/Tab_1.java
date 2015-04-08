package g4a.quadratin.mx.quadratin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by eduardo on 4/8/15.
 */
public class Tab_1 extends Fragment {

    private String tab_title = "-";

    public void tab_edit_content(String title) {
        tab_title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_1,container,false);
        ((TextView) view.findViewById(R.id.textView) ).setText(tab_title);

        return view;
    }
}
