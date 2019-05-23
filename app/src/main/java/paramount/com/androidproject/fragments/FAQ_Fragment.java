package paramount.com.androidproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import paramount.com.androidproject.R;
import paramount.com.androidproject.utils.DominoRegularTextView;


public class FAQ_Fragment extends Fragment {

    DominoRegularTextView ques1,ques2,ques3,ques4,ques5,ques6,ques7,ques8,ques9,ques10;
    DominoRegularTextView ans1,ans2,ans3,ans4,ans5,ans6,ans7,ans8,ans9,ans10;




    Context mContext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_faq_, container, false);

        ques1 = (DominoRegularTextView) view.findViewById(R.id.ques1);
        ques2 = (DominoRegularTextView) view.findViewById(R.id.ques2);
        ques3 = (DominoRegularTextView) view.findViewById(R.id.ques3);
        ques4 = (DominoRegularTextView) view.findViewById(R.id.ques4);
        ques5 = (DominoRegularTextView) view.findViewById(R.id.ques5);
        ques6 = (DominoRegularTextView) view.findViewById(R.id.ques6);
        ques7 = (DominoRegularTextView) view.findViewById(R.id.ques7);
        ques8 = (DominoRegularTextView) view.findViewById(R.id.ques8);
        ques9 = (DominoRegularTextView) view.findViewById(R.id.ques9);
        ques10 = (DominoRegularTextView) view.findViewById(R.id.ques10);

        ans1 = (DominoRegularTextView) view.findViewById(R.id.ans1);
        ans2 = (DominoRegularTextView) view.findViewById(R.id.ans2);
        ans3 = (DominoRegularTextView) view.findViewById(R.id.ans3);
        ans4 = (DominoRegularTextView) view.findViewById(R.id.ans4);
        ans5 = (DominoRegularTextView) view.findViewById(R.id.ans5);
        ans6 = (DominoRegularTextView) view.findViewById(R.id.ans6);
        ans7 = (DominoRegularTextView) view.findViewById(R.id.ans7);
        ans8 = (DominoRegularTextView) view.findViewById(R.id.ans8);
        ans9 = (DominoRegularTextView) view.findViewById(R.id.ans9);
        ans10 = (DominoRegularTextView) view.findViewById(R.id.ans10);

        ques1.setText("Question: How can secure the catering date/time?");
        ans1.setText("Answer: Providing a 24-36 hour notice of catering order saves-your-date along with the time you would like to pick-up or have delivered (site specific).");

        ques2.setText("Question: Can we create our own menu?");
        ans2.setText("Answer: Our menu is designed to suit your needs. You have the choice of a selection of catering");

        ques3.setText("Question: How do I place my order?");
        ans3.setText("Answer: You can either place your order through our website www.paramountfinefoods.com and submit a catering inquiry form or call your nearest Paramount location directly. We are more than\n" +
                "happy to walk you through the process and answer any questions you may have.");

        ques4.setText("Question: How do I get a per person price?");
        ans4.setText("Answer: We can divide the total order into the amount of people to give you the price per person.");

        ques5.setText("Question: I noticed that the Beef Shawarma Package comes with a Fattoush Salad. Can I substitute it for a Tabbouleh?");
        ans5.setText("Answer: Unfortunately, we don’t accept substitutions, however, you can build your own package by following the 6 steps, starting with your choice of salad.");

        ques6.setText("Question: Is soup available on the catering menu?");
        ans6.setText("Answer: Although, our soup is not listed on the catering menu, we do have it available through our regular menu (ALC = a la carte)");

        ques7.setText("Question: Is the catering order delivered or do I have to pick it up?");
        ans7.setText("Answer: Unfortunately, we typically do not deliver and our stand procedure for catering orders is pick up only however please contact the restaurant directly and see if they can accommodate your request.");

        ques8.setText("Question: Is the catering menu Halal?");
        ans8.setText("Answer: Yes, Paramount prides itself in serving all Halal certified products and HMA approved items.");

        ques9.setText("Question: Are cutlery and plates included in the catering order?");
        ans9.setText("Answer: Paramount provides sufficient take out cutlery and napkins with every order. Plates are not provided to the guest");

        ques10.setText("Question: What if I am dissatisfied with my catering order?");
        ans10.setText("Answer: If you are dissatisfied with your order please contact the restaurant immediately or\n" +
                "contact info@paramountfinefoods.com . Our staff will be more than happy to help you out.");

        mContext = getActivity();

        return view;

    }
}
