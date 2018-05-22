package sg.edu.rp.c346.c390app1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment {

TextView textView;
    public OverviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        textView = (TextView) view.findViewById(R.id.tvAbout);

        textView.setText("C390 Portfolio Development module helps you prepare a showcase of what you have learnt in Republic Poly Diploma in Mobile Software Development and the work you had created.\n" +
                "\n" +
                "This is a 2-semester module and you would be taking it in your year 2 sem 2 and year 3 sem 1.\n" +
                "\n" +
                "Every student would be assigned a supervisor to provide guidance and mentoring.\n" +
                "\n" +
                "Each student must put up at least 4 projects but you should aim for more for a more favorable portfolio to showcase to your prospective employers and the world. Projects are individual work.\n" +
                "\n" +
                "A good time management advice is complete at least 3 projects in year 2 sem 2 so that you can better focus in engaging your Final Year Project starting year 3 sem 1.\n" +
                "\n" +
                "You would be graded on both the process and the final deliverable of the projects.\n" +
                "Specifically,\n" +
                "\n" +
                "Create a blog site for portfolio\n" +
                "Create a WordPress account\n" +
                "On your own blog site, create a blog post for every project. You must have one blog post for each project.\n" +
                "Each post should be updated with a proposal, storyboard and competitive analysis of the project.\n" +
                "Take a look at your seniors’ work at Exemplary Portfolios. These portfolios serve as a guide and but you are encouraged to surpass them.\n" +
                "Competitive Analysis should have the following\n" +
                "2 competitors at least\n" +
                "Competitors product name and URL to their apps/website\n" +
                "Competitors’ features and gaps\n" +
                "SWOT\n" +
                "It would be good to have your friends critique your work so you improve upon it.\n" +
                " \n" +
                "\n" +
                "The process and deliverable are graded on 4 components with their weight as below.\n" +
                "Technical – 30%\n" +
                "Concept and Approach – 30%\n" +
                "Creativity and Uniqueness – 30%\n" +
                "Presentation – 10%");
        textView.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }

}
