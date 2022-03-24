package com.ecn.guidefa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompanyListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompanyListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public CompanyListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompanyListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CompanyListFragment newInstance(String param1, String param2) {
        CompanyListFragment fragment = new CompanyListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_company_list, container, false);

        View rootView = inflater.inflate(R.layout.fragment_company_list, container, false);
        RelativeLayout myLayout = (RelativeLayout) rootView.findViewById(R.id.mainLayout);
        showCompanies(myLayout);

        return rootView;
    }

    private void showCompanies(RelativeLayout linearLayout) {
        for(int i=0; i < companyList.length; i++) {
            String company_name = companyList[i][0];

            Button button = new Button(getContext());
            button.setText(company_name);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CompanyDetailsFragment detailsFragment = new CompanyDetailsFragment();
                    getFragmentManager().beginTransaction().replace(R.id.container, detailsFragment).commit();
                }
            });

            RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
            buttonParams.addRule(RelativeLayout.CENTER_VERTICAL);

            linearLayout.addView(button, buttonParams);
        }
    }

    private String[][] companyList = {
        {"Groupe","Rubrique"},
        {"Bee Engineering","Energie et Energies Renouvelables"},
        {"ALTEN","Audit et Conseil"},
        {"Ateliers Louis Vuitton","Industrie"},
        {"CGG","Industrie"},
        {"Oresys","Audit et Conseil"},
        {"Vinci","BTP & génie civil"},
        {"Micropole","Informatique & ESN"},
        {"HEC Paris ","Formation Complémentaire"},
        {"Klee Group","Informatique & ESN"},
        {"SEGULA Technologies","Industrie"},
        {"GROUPE ATLANTIC","Energie et Energies Renouvelables"},
        {"ISAE-SUPAERO","Formation Complémentaire"},
        {"Groupe SPIE","Industrie"},
        {"Entreprise CHARIER","BTP & génie civil"},
        {"Mazars","Audit et Conseil"},
        {"Capgemini","Informatique & ESN"},
        {"IKOS Consulting","Industrie"},
        {"ESCP Business School","Formation Complémentaire"},
        {"NGE","BTP & génie civil"},
        {"AUDENCIA","Formation Complémentaire"},
        {"Groupe CGI inc.","Audit et Conseil"},
        {"Smile","Informatique & ESN"},
        {"VINCI Construction France","BTP & génie civil"},
        {"Groupe Bouygues","Services et commerces"},
        {"Groupe ANGEVIN","BTP & génie civil"},
        {"KPMG France","Audit et Conseil"},
        {"Saipem","Energie et Energies Renouvelables"},
        {"Wavestone SA","Audit et Conseil"},
        {"Eiffage","BTP & génie civil"},
        {"Theodo","Informatique & ESN"},
        {"Groupe ESSEC","Formation Complémentaire"},
        {"Axione","Informatique & ESN"},
        {"PwC","Audit et Conseil"},
        {"Airbus","Aéronautique et Naval"},
        {"Technicatome","Energie et Energies Renouvelables"},
        {"NAVAL GROUP","Aéronautique et Naval"},
        {"Doctolib","Services et commerces"},
        {"MARINE NATIONALE","Aéronautique et Naval"},
        {"APAVE","Audit et Conseil"},
        {"Eiffage Route","BTP & génie civil"},
        {"RTE","Energie et Energies Renouvelables"},
        {"DEDALUS","Services et commerces"},
        {"FAYAT","BTP & génie civil"},
        {"EIFFAGE CONSTRUCTION","BTP & génie civil"},
        {"INFOTEL CONSEIL","Informatique & ESN"},
        {"SOLUTEC","Informatique & ESN"},
        {"Bouygues Construction","BTP & génie civil"},
        {"Groupe BRIAND","BTP & génie civil"},
        {"VINCI","Energie et Energies Renouvelables"},
        {"COLAS","BTP & génie civil"},
        {"GROUPE ETPO","BTP & génie civil"},
        {"Subsea 7","Aéronautique et Naval"},
        {"ARTELIA","BTP & génie civil"},
        {"In Situ Architecture, Culture et Ville","Architecture"}
    };
}