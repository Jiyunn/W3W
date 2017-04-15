package kr.happy.myarmy;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.happy.myarmy.Recyclerview.ItemResumenInfo;
import kr.happy.myarmy.Recyclerview.TestAdapter;

/**
 * Created by JY on 2017-04-15.
 */

public class InfoEditFragment extends Fragment {

    @Nullable @BindView(R.id.rv_info)
    RecyclerView mRecyclerview;

    @Nullable @BindString(R.string.name)  String name;
    @Nullable @BindString(R.string.birth)  String birth;
    @Nullable @BindString(R.string.wantjob)  String wantJob;
    @Nullable @BindString(R.string.specialnote)  String specialNote;
    @Nullable @BindString(R.string.certificate)  String certificate;
    @Nullable @BindString(R.string.education)  String edu;
    @Nullable @BindString(R.string.living)  String living;
    @Nullable @BindString(R.string.etccareer) String etcCareer;
    @Nullable @BindString(R.string.phone)  String phone;

    private TestAdapter adapter;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<ItemResumenInfo> dataSet;
    private String[] itemName; //항목 이름들

    public InfoEditFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.infoedit, container, false);
        ButterKnife.bind(this, view);

        setData();

        mRecyclerview.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); //세로로 뿌리기
        mRecyclerview.setLayoutManager(mLayoutManager);

        adapter = new TestAdapter(getActivity(), dataSet, R.layout.infoedit); //어댑터 등록
        mRecyclerview.setAdapter(adapter);

        mRecyclerview.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

    public void setData() {

        dataSet = new ArrayList<ItemResumenInfo>();
        itemName = new String[]{name, birth, wantJob, specialNote, certificate, edu, living, etcCareer, phone};

        for (int i = 0; i < itemName.length; i++) { //임시 실험데이터
            dataSet.add(new ItemResumenInfo(itemName[i], String.valueOf(i)));
            Log.d("jy", itemName[i] + " /" +String.valueOf(i));
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
