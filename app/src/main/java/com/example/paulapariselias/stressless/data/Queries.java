package com.example.paulapariselias.stressless.data;

import com.example.paulapariselias.stressless.models.Pending;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulapariselias on 16-08-17.
 */

public class Queries {

    public List<Pending> pendings(){

        List<Pending> pendings = new ArrayList<>();

        List<Pending> pendingList = Pending.find(Pending.class,"done = 0");
        if(pendingList !=null && pendingList.size() > 0){
            pendings.addAll(pendingList);
        }
        return pendings;
    }
}
