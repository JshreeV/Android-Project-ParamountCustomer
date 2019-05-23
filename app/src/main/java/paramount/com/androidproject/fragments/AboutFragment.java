package paramount.com.androidproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import paramount.com.androidproject.R;
import paramount.com.androidproject.utils.DominoRegularTextView;


public class AboutFragment extends Fragment {

    DominoRegularTextView tv_about,tv_aboutpart2;

    Context mContext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_about, container, false);


        mContext = getActivity();


        tv_about = (DominoRegularTextView) view.findViewById(R.id.tv_about);
        tv_aboutpart2 = (DominoRegularTextView) view.findViewById(R.id.tv_aboutpart2);

        tv_about.setText(" Paramount Fine Foods began as one Middle Eastern Restaurant in Mississauga, Ontario  and is now the fastest growing Middle Eastern Food chain in Canada with over 60  restaurants. We flew in renowned international chefs to share the most authentic Lebanese recipes using the freshest and finest ingredients which have been passed down for generations to enjoy. With the aroma of freshly baked breads in our wood-burning ovens, charcoal BBQ meats and handmade sweets, Paramount Fine Foods provides guests a culinary experience that will not be forgotten. \n \n ");

        tv_aboutpart2.setText("“Many people believe that business success brings happiness, but they are mistaken.Happiness is more than a bank statement, an asset or the bottom line. Immerse your company with a team who you value as a second family. Success is wonderful but, success surrounded by family is Paramount.”" +
                "\nMohamad Fakih\n" +
                "CEO, Paramount Fine Foods");
        return view;

    }



}
