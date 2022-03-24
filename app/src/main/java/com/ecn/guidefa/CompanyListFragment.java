package com.ecn.guidefa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompanyListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompanyListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    public CompanyListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CompanyListFragment.
     */
    public static CompanyListFragment newInstance() {
        CompanyListFragment fragment = new CompanyListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // place args
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_company_list, container, false);

        View rootView = inflater.inflate(R.layout.fragment_company_list, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.company_list_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a grid layout manager
        layoutManager = new GridLayoutManager(rootView.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        // retrieve data
        adapter = new CompanyListAdapter(companyList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }


    private String[][] companyList = {
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