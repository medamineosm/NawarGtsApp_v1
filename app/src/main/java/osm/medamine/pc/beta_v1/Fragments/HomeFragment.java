package osm.medamine.pc.beta_v1.Fragments;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import osm.medamine.pc.beta_v1.Activity.LoginActivity;
import osm.medamine.pc.beta_v1.Activity.MainActivity;
import osm.medamine.pc.beta_v1.Pojos.Position;
import osm.medamine.pc.beta_v1.Pojos.VehiculeAndroid;
import osm.medamine.pc.beta_v1.R;
import osm.medamine.pc.beta_v1.Services.GPSTracker;
import osm.medamine.pc.beta_v1.Services.LocationServices;

import static osm.medamine.pc.beta_v1.Metier.Manager.POST;
import static osm.medamine.pc.beta_v1.Metier.Manager.POST_LOCATION;

/**
 * Created by PC on 27/08/2015.
 */
public class HomeFragment extends Fragment {
    TextView tvIdentifiant,tvIntituler,tvMatricule,tvType,tvModel,tvGroupe,tvChauffeur;
    EditText edIdentifiant,edIntituler,edMatricule,edType,edModel,edGroupe,edChauffeur;
    Button SendLocationBtn;
    GPSTracker gps;
    Position pos;
    EditText edUrl;
    VehiculeAndroid Vand = null;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Vand = LoginActivity.Vand;

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        SendLocationBtn = (Button)rootView.findViewById(R.id.SendBtn);

        Init(rootView);
        setEditText();

        edUrl = (EditText)rootView.findViewById(R.id.edUrl);
        SendLocationBtn.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                gps = new GPSTracker(getActivity());

                //check if GPS enabled
                if (gps.canGetLocation()) {
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    //Position pos = new Position("amine",gps.getLatitude()+"",gps.getLongitude()+"");
                    Thread thread = new Thread(new Runnable(){
                        @Override
                        public void run() {
                            try {
                                //Your code goes here
                                new LocationServices();
                                // call AsynTask to perform network operation on separate thread
                                new HttpAsyncTask().execute(edUrl.getText().toString());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }else{
                    gps.showSettingAlert();
                }
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            pos = new Position();
            pos.setIdentifiant("1");
            pos.setLatitude(gps.getLatitude() + "");
            pos.setLongitude(gps.getLongitude() + "");
            //Toast.makeText(getApplicationContext(),pos.toString(),Toast.LENGTH_LONG).show();
            return POST_LOCATION(urls[0], pos);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getActivity() , "Data Sent!", Toast.LENGTH_LONG).show();
            Toast.makeText(getActivity(), pos.toString(), Toast.LENGTH_LONG).show();
            Log.d("position ======== ", pos.toString());

        }
    }

    private void Init(View rootView)
    {
        tvIdentifiant = (TextView)rootView.findViewById(R.id.tvIdentifiant);
        tvIntituler = (TextView)rootView.findViewById(R.id.tvIntituler);
        tvMatricule = (TextView)rootView.findViewById(R.id.tvMatricule);
        tvType = (TextView)rootView.findViewById(R.id.tvType);
        tvModel = (TextView)rootView.findViewById(R.id.tvModele);
        tvGroupe = (TextView)rootView.findViewById(R.id.tvGroupe);
        tvChauffeur = (TextView)rootView.findViewById(R.id.tvChauffeur);

        edIdentifiant = (EditText)rootView.findViewById(R.id.edIdentifiant);
        edIntituler = (EditText)rootView.findViewById(R.id.edIntituler);
        edMatricule = (EditText)rootView.findViewById(R.id.edMatricule);
        edType = (EditText)rootView.findViewById(R.id.edType);
        edModel = (EditText)rootView.findViewById(R.id.edModel);
        edGroupe = (EditText)rootView.findViewById(R.id.edGroupe);
        edChauffeur = (EditText)rootView.findViewById(R.id.edChauffeur);
    }

    private void setEditText()
    {
        edIdentifiant.setText(Vand.getId_vehicule()+"");
        edIntituler.setText(Vand.getIntitule());
        edMatricule.setText(Vand.getMatricule());
        edType.setText(Vand.getType());
        edModel.setText(Vand.getModele());
        edGroupe.setText(Vand.getGroupe());
        edChauffeur.setText(Vand.getChauffeur());
    }
}