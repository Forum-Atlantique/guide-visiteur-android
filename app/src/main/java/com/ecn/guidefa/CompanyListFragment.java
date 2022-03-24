package com.ecn.guidefa;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompanyListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompanyListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private EditText searchBar;
    private String[][] dynamicList;


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
        dynamicList = companyList.clone();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_company_list, container, false);

        //Search
        searchBar = rootView .findViewById(R.id.searchBar);
        searchBar.addTextChangedListener(new TextWatcher() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String search = charSequence.toString().toLowerCase();
                Stream<String[]> stream = (Stream<String[]>) Stream.of(companyList);
                dynamicList = (String[][]) stream.filter(cmp -> cmp[0].toLowerCase().contains(search)).toArray(String[][]::new);
                adapter = new CompanyListAdapter(dynamicList);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // Recycler View
        recyclerView = (RecyclerView) rootView.findViewById(R.id.company_list_view);
        layoutManager = new GridLayoutManager(rootView.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        // retrieve data
        adapter = new CompanyListAdapter(dynamicList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }


    final private String[][] companyList = {
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