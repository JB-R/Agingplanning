package tounzcompagny.agingplanning.Main;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.sql.Date;
import java.util.ArrayList;

import tounzcompagny.agingplanning.DataBase.DatabaseHandler;
import tounzcompagny.agingplanning.UI.AdapterStudy;
import tounzcompagny.agingplanning.UI.AdapterTitle;
import tounzcompagny.agingplanning.R;
import tounzcompagny.agingplanning.Objects.State;
import tounzcompagny.agingplanning.Objects.Study;
import tounzcompagny.agingplanning.UI.PopForm;
import tounzcompagny.agingplanning.DataBase.DatabaseHandler;

public class PlanningActivity extends AppCompatActivity {

    public static final String[] stringGridTitle = {"N° d'étude", "Nom du client", "Nb d'éch", "Date d'entrée", "Nb jours\nentrée", "Nb jours\nsortie", "Date de sortie", "N° d'étuve", "Test", "Statut"};
    private ArrayList<String> listGridTitle;
    private GridView gridTitle;
    private GridView gridStudy;
    private ArrayList<Study> arrayStudy;
    private Study study1 = new Study("MEA17 259", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.TERMINER);
    private Study study2 = new Study("MEA17 260", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.TERMINER);
    private Study study3 = new Study("MEA17 261", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.TERMINER);
    private Study study4 = new Study("MEA17 262", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.TERMINER);
    private Study study5 = new Study("MEA17 263", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.EN_ATTENTE);
    private Study study6 = new Study("MEA17 264", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.EN_ATTENTE);
    private Study study7 = new Study("MEA17 265", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.FIN);
    private Study study8 = new Study("MEA17 266", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.FIN);
    private Study study9 = new Study("MEA17 267", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.EN_COURS);
    private Study study10 = new Study("MEA17 268", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.EN_COURS);
    private Study study11 = new Study("MEA17 269", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.EN_COURS);
    private Study study12 = new Study("MEA17 270", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.EN_COURS);
    private Study study13 = new Study("MEA17 271", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.EN_COURS);
    private Study study14 = new Study("MEA17 272", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.EN_COURS);
    private Study study15 = new Study("MEA17 273", "Riom JB", 8, new Date(117, 5, 30), 0, 5, new Date(117, 6, 5), 1326, "BSC", State.EN_COURS);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        gridTitle = (GridView) findViewById(R.id.grid_title);
        gridStudy = (GridView) findViewById(R.id.grid_study);
        gridTitle.setNumColumns(stringGridTitle.length); // num of columns on physical table

        listGridTitle = new ArrayList<>(); // String table to ArrayList<String> for adapter
        for (int i = 0; i <= (stringGridTitle.length - 1); i++) {
            listGridTitle.add(i, stringGridTitle[i]);
        }

        AdapterTitle adapterTitle = new AdapterTitle(this, R.id.grid_title_TextView, listGridTitle);
        gridTitle.setAdapter(adapterTitle);

        arrayStudy = new ArrayList<>();
        arrayStudy.add(study1);
        arrayStudy.add(study2);
        arrayStudy.add(study3);
        arrayStudy.add(study4);
        arrayStudy.add(study5);
        arrayStudy.add(study6);
        arrayStudy.add(study7);
        arrayStudy.add(study8);
        arrayStudy.add(study9);
        arrayStudy.add(study10);
        arrayStudy.add(study11);
        arrayStudy.add(study12);
        arrayStudy.add(study13);
        arrayStudy.add(study14);
        arrayStudy.add(study15);

        gridStudy.setAdapter(new AdapterStudy(this, arrayStudy));

        ImageButton buttonNew = (ImageButton) findViewById(R.id.button_new);
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlanningActivity.this, PopForm.class));
            }
        });

        DatabaseHandler dataBase = new DatabaseHandler(this);
        /*
        dataBase.addStudy(study1);
        dataBase.addStudy(study2);
        dataBase.addStudy(study3);
        dataBase.addStudy(study4);
        dataBase.addStudy(study5);
        dataBase.addStudy(study6);
        dataBase.addStudy(study7);
        dataBase.addStudy(study8);
        dataBase.addStudy(study9);
        dataBase.addStudy(study10);
        dataBase.addStudy(study11);
        dataBase.addStudy(study12);
        dataBase.addStudy(study13);
        dataBase.addStudy(study14);
        dataBase.addStudy(study15);
        */

        //read database

        dataBase.deleteAllData();

        int nbLineDB = dataBase.getCountData();


    }
}
