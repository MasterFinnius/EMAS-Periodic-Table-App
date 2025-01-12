package com.pta.joshhamwee.periodictablemain;

import java.util.ArrayList;
import java.util.List;

public class CurrentElement {
    String atomicNumber, name, atomicSymbol, atomicMass, crystalStructure;
    String shellOccK, shellOccL, shellOccM, shellOccN, shellOccO, shellOccP, shellOccQ;
    String valencyCommon, valencies, meltingPoint, boilingPoint, density, ionicRadius;
    String kBeta, kAlpha, lGamma23, lGamma1, lBeta4, lBeta3, lBeta2, lBeta1, lAlpha;
    String mGamma, mBeta, mAlpha;
    Integer id;
    List<String> data = new ArrayList<>();


    public CurrentElement(Integer id, DatabaseAccess db) {
        if (id == R.id.H) this.name = "Hydrogen";
        else if (id == R.id.He) this.name = "Helium";
        else if (id == R.id.Li) this.name = "Lithium";
        else this.name = "Other";
        dataGetting(db);
        dataSetting();
    }

    private void dataGetting(DatabaseAccess db){
        if(this.name == "Other") this.name = "Carbon";
        db.open();
        this.data = db.getElementData(this.name);
        db.close();
    }

    private void dataSetting(){
        this.atomicNumber = data.get(0);
        this.name = data.get(1);
        this.atomicSymbol = data.get(2);
        this.atomicMass = data.get(3);
        this.crystalStructure = data.get(4);
        this.shellOccK = data.get(5);
        this.shellOccL = data.get(6);
        this.shellOccM = data.get(7);
        this.shellOccN = data.get(8);
        this.shellOccO = data.get(9);
        this.shellOccP = data.get(10);
        this.shellOccQ = data.get(11);
        this.valencyCommon = data.get(12);
        this.valencies = data.get(13);
        this.meltingPoint = data.get(14);
        this.boilingPoint = data.get(15);
        this.density = data.get(16);
        this.ionicRadius = data.get(17);
        this.kBeta = data.get(18);
        this.kAlpha = data.get(19);
        this.lGamma23 = data.get(20);
        this.lGamma1 = data.get(21);
        this.lBeta4 = data.get(22);
        this.lBeta3 = data.get(23);
        this.lBeta2 = data.get(24);
        this.lBeta1 = data.get(25);
        this.lAlpha = data.get(26);
        this.mGamma = data.get(27);
        this.mBeta = data.get(28);
        this.mAlpha = data.get(29);
    }
}
