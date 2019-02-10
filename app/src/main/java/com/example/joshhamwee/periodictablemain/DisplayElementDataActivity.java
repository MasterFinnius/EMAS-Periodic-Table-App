package com.example.joshhamwee.periodictablemain;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.content.ContextCompat;

import java.nio.channels.NotYetBoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;


public class DisplayElementDataActivity extends AppCompatActivity {

    Toolbar toolbar;
    //NavigationView navigationView;
    //Lists of different elements to determine colours
    private static final Set<Integer> AlkMetals = new HashSet<>(Arrays.asList(new Integer[]{1,3,11,19,37,55,87}));
    private static final Set<Integer> AlkEMetals = new HashSet<>(Arrays.asList(new Integer []{4,12,20,38,56,88}));
    private static final Set<Integer> TranMetals = new HashSet<>(Arrays.asList(new Integer []{21,22,23,24,25,26,27,28,29,30,
    39,40,41,42,43,45,46,47,48,72,73,74,75,76,77,78,79,80}));
    private static final Set<Integer> Metaloids = new HashSet<>(Arrays.asList(new Integer []{13,31,32,49,50,51,81,82,83,84}));
    private static final Set<Integer> NonMetals = new HashSet<>(Arrays.asList(new Integer []{5,6,7,8,9,14,15,16,17,33,34,35,52,53,85}));
    private static final Set<Integer> NobleGases = new HashSet<>(Arrays.asList(new Integer []{2,10,18,36,54,86}));
    //redundant --> may find another use later remove if not
   // private static final Set<Integer> HeavyEl = new HashSet<>(Arrays.asList(new Integer []{57,58,59}))


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_element_data);

        //Sets up the toolbar on this activity
        setUpToolbar();

        //Get the ID Data that was passed from main activity or search activity
        Bundle dataFromMain = getIntent().getExtras();
        Integer atomicNumber = dataFromMain.getInt("ElementID");                  //get passed atomic number
        Integer elementSize = dataFromMain.getInt("ElementIDSearch");   //gets passed atomic number
        if(elementSize != 0){
            atomicNumber = elementSize;
        }

        //create a new database instance
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);

        //Create an element object that relates to the specific ID
        CurrentElement currentElement = new CurrentElement(atomicNumber, databaseAccess);

        TextView ElementName = findViewById(R.id.ElementName);
        ElementName.setText(currentElement.name);
        displayKeVValues(currentElement);

        //Underlining the headers
        TextView KLMHeader = findViewById(R.id.KLM_Energies_Header);
        SpannableString KLM = new SpannableString("KLM Energies:");
        KLM.setSpan(new UnderlineSpan(),0,KLM.length(),0);
        KLMHeader.setText(KLM);

        TextView AbsorptionHeader = findViewById(R.id.Absorbsion_Edges_Header);
        SpannableString Absorption = new SpannableString("Absorption Edges:");
        Absorption.setSpan(new UnderlineSpan(),0,Absorption.length(),0);
        AbsorptionHeader.setText(Absorption);

        //should probably define a separate function to set up colour-- too much repetition
        if(AlkMetals.contains(atomicNumber)) {
            ElementName.setTextColor(ContextCompat.getColor(this, R.color.pastelPink));
        }
        else if(AlkEMetals.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelOrange));
        }
        else if(TranMetals.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelYellow));
        }
        else if(Metaloids.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelBlue));
        }
        else if(NonMetals.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelPurple));
        }
        else if(NobleGases.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelGrey));
        }
        else{
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelGreen));
        }
    }

    private void displayKeVValues(CurrentElement currentElement){
        //Create textViews to display chosen elements information
        TextView AtomicNumber = findViewById(R.id.AtomicNumber);
        AtomicNumber.setText(currentElement.atomicNumber);
        TextView AtomicSymbol = findViewById(R.id.AtomicSymbol);
        AtomicSymbol.setText(currentElement.atomicSymbol);
        TextView AtomicMass = findViewById(R.id.AtomicMass);
        AtomicMass.setText(currentElement.atomicMass);
        TextView CrystalStruct = findViewById(R.id.CrystalStruct);
        CrystalStruct.setText(currentElement.crystalStructure);
        TextView ShellK = findViewById(R.id.ShellOccK);
        ShellK.setText(currentElement.shellOccK);
        TextView ShellL = findViewById(R.id.ShellOccL);
        ShellL.setText(currentElement.shellOccL);
        TextView ShellM = findViewById(R.id.ShellOccM);
        ShellM.setText(currentElement.shellOccM);
        TextView ShellN = findViewById(R.id.ShellOccN);
        ShellN.setText(currentElement.shellOccN);
        TextView ShellO = findViewById(R.id.ShellOccO);
        ShellO.setText(currentElement.shellOccO);
        TextView ShellP = findViewById(R.id.ShellOccP);
        ShellP.setText(currentElement.shellOccP);
        TextView ShellQ = findViewById(R.id.ShellOccQ);
        ShellQ.setText(currentElement.shellOccQ);
        TextView ValencyCommon = findViewById(R.id.ValencyCommon);
        ValencyCommon.setText(currentElement.valencyCommon);
        TextView Valencies = findViewById(R.id.Valencies);
        Valencies.setText(currentElement.valencies);
        TextView MeltingPoint = findViewById(R.id.MeltingPoint);
        MeltingPoint.setText(currentElement.meltingPoint);
        TextView BoilingPoint = findViewById(R.id.BoilingPoint);
        BoilingPoint.setText(currentElement.boilingPoint);
        TextView Density = findViewById(R.id.Density);
        Density.setText(currentElement.density);
        TextView IonicRadius = findViewById(R.id.IonicRadius);
        IonicRadius.setText(currentElement.ionicRadius);
        TextView KBeta = findViewById(R.id.KBeta);
        KBeta.setText(currentElement.kBeta);
        TextView KAlpha = findViewById(R.id.KAlpha);
        KAlpha.setText(currentElement.kAlpha);
        TextView LGamma23 = findViewById(R.id.LGamma23);
        LGamma23.setText(currentElement.lGamma23);
        TextView LGamma1 = findViewById(R.id.LGamma1);
        LGamma1.setText(currentElement.lGamma1);
        TextView LBeta4 = findViewById(R.id.LBeta4);
        LBeta4.setText(currentElement.lBeta4);
        TextView LBeta3 = findViewById(R.id.LBeta3);
        LBeta3.setText(currentElement.lBeta3);
        TextView LBeta2 = findViewById(R.id.LBeta2);
        LBeta2.setText(currentElement.lBeta2);
        TextView LBeta1 = findViewById(R.id.LBeta1);
        LBeta1.setText( currentElement.lBeta1);
        TextView LAlpha = findViewById(R.id.LAlpha);
        LAlpha.setText(currentElement.lAlpha);
        TextView MGamma = findViewById(R.id.MGamma);
        MGamma.setText(currentElement.mGamma);
        TextView MBeta = findViewById(R.id.MBeta);
        MBeta.setText( currentElement.mBeta);
        TextView MAlpha = findViewById(R.id.MAlpha);
        MAlpha.setText(currentElement.mAlpha);
        TextView KEdge = findViewById(R.id.KEdge);
        KEdge.setText(currentElement.kEdge);
        TextView L3Edge = findViewById(R.id.L3Edge);
        L3Edge.setText(currentElement.l3Edge);
        TextView L2Edge = findViewById(R.id.L2Edge);
        L2Edge.setText(currentElement.l2Edge);
        TextView L1Edge = findViewById(R.id.L1Edge);
        L1Edge.setText(currentElement.l1Edge);
        TextView M5Edge = findViewById(R.id.M5Edge);
        M5Edge.setText(currentElement.m5Edge);
        TextView M4Edge = findViewById(R.id.M4Edge);
        M4Edge.setText(currentElement.m4Edge);
        TextView M3Edge = findViewById(R.id.M3Edge);
        M3Edge.setText(currentElement.m3Edge);
        TextView M2Edge = findViewById(R.id.M2Edge);
        M2Edge.setText(currentElement.m2Edge);
        TextView M1Edge = findViewById(R.id.M1Edge);
        M1Edge.setText(currentElement.m1Edge);
    }

    /********** this is repeated code, probs should find a way around it. hehh..... ***/


    private void setUpToolbar() {
        //Find the toolbar by the specific id
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            if (getSupportActionBar()!=null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private void setCamecaValues(String crystal, CurrentElement element){
        List<String> newData = new ArrayList<>();
        for (int i = 18; i < 30; i++){
            float n = Float.parseFloat(element.data.get(i));
            newData.add(String.valueOf(500*changeUnitsJOEL("H-type", crystal, n)));
        }
        updateEnergyValues(newData);
    }


    private double changeUnitsJOEL(String spectrometer, String crystal, double energy){
        double R = 0, two_d = 0, E = 0;
        if (spectrometer.equals("XCE") || spectrometer.equals("FCE")) R = 140;
        else if (spectrometer.equals("H-type")) R = 100;

        if (crystal.equals("PET")) two_d = 8.74;
        else if (crystal.equals("TAP")) two_d = 25.75;
        else if (crystal.equals("QTZ1011")) two_d = 6.686;
        else if (crystal.equals("LIF200")) two_d = 4.0267;
        else if (crystal.equals("LIF220")) two_d = 2.848;

        //N IS FIXED AS 1 !!!!
        double l_value = (24.792 * R) / (two_d * energy);
        return l_value;
    }

    private void setLValue(CurrentElement element, String spectrometer, String crystal){
        List<String> newData = new ArrayList<>();
        for (int i = 18; i < 30; i++){
            float n = Float.parseFloat(element.data.get(i));
            newData.add(String.valueOf(changeUnitsJOEL(spectrometer, crystal, n)));
        }
        updateEnergyValues(newData);
    }


    private void updateEnergyValues(List<String> newData){
        TextView KBeta = findViewById(R.id.KBeta);
        KBeta.setText(newData.get(0));
        TextView KAlpha = findViewById(R.id.KAlpha);
        KAlpha.setText(newData.get(1));
        TextView LGamma23 = findViewById(R.id.LGamma23);
        LGamma23.setText(newData.get(2));
        TextView LGamma1 = findViewById(R.id.LGamma1);
        LGamma1.setText(newData.get(3));
        TextView LBeta4 = findViewById(R.id.LBeta4);
        LBeta4.setText(newData.get(4));
        TextView LBeta3 = findViewById(R.id.LBeta3);
        LBeta3.setText(newData.get(5));
        TextView LBeta2 = findViewById(R.id.LBeta2);
        LBeta2.setText(newData.get(6));
        TextView LBeta1 = findViewById(R.id.LBeta1);
        LBeta1.setText(newData.get(7));
        TextView LAlpha = findViewById(R.id.LAlpha);
        LAlpha.setText(newData.get(8));
        TextView MGamma = findViewById(R.id.MGamma);
        MGamma.setText(newData.get(9));
        TextView MBeta = findViewById(R.id.MBeta);
        MBeta.setText(newData.get(10));
        TextView MAlpha = findViewById(R.id.MAlpha);
        MAlpha.setText(newData.get(11));
    }
    //function to reset data to KeV on display done by calling function that initially displays the data onscreen


}
