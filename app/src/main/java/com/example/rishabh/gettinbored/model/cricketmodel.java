package com.example.rishabh.gettinbored.model;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Created by RISHABH on 07-07-2017.
 */

public class cricketmodel {
    ArrayList<matches> matches;

    public cricketmodel(ArrayList<com.example.rishabh.gettinbored.model.matches> matches) {
        this.matches = matches;
    }

    public ArrayList<com.example.rishabh.gettinbored.model.matches> getMatches() {
        return matches;
    }
}
