package uffs.cowapp.place;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import uffs.cowapp.R;
import uffs.cowapp.utils.JSONParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlaceCadActivity extends Activity  {

    // Progress Dialog
    private ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();

    EditText inputId;
    EditText inputNome;
    EditText inputDescricao;
    EditText inputCidade;
    EditText inputUf;
    EditText inputLatitude;
    EditText inputLongitude;
    EditText inputTamanho;
    EditText inputCapacidade;
    EditText inputIdTipo;

    // url to create new place
    private static String url_create_place = "http://cowapp2020.herokuapp.com/ambientes/";

    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_ERROR = "detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_cad);

        //inputId               =(EditText) findViewById(R.id.);
        inputNome = (EditText) findViewById(R.id.activity_place_cad_edtNome);
        inputDescricao = (EditText) findViewById(R.id.activity_place_cad_edtDescricao);
        inputCidade = (EditText) findViewById(R.id.activity_place_cad_edtCidade);
        inputUf = (EditText) findViewById(R.id.activity_place_cad_edtUF);
        //inputLatitude           =(EditText) findViewById(R.id.);
        //inputLongitude          =(EditText) findViewById(R.id.);
        inputTamanho = (EditText) findViewById(R.id.activity_place_cad_edtTamanho);
        inputCapacidade = (EditText) findViewById(R.id.activity_place_cad_edtCapacidade);
        //inputIdTipo             =(EditText) findViewById(R.id.);

        Button btnSalvar = (Button) findViewById(R.id.activity_place_cad_btnSalvar);
        Button btnExcluir = (Button) findViewById(R.id.activity_place_cad_btnExcluir);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // creating new place in background thread
                new CreateNewPlace().execute();
            }
        });
    }

    class CreateNewPlace extends AsyncTask<String, String, String > {
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(PlaceCadActivity.this);
            pDialog.setMessage("Criando ambiente...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * Creating product
         * */

        protected String doInBackground(String... args) {
            if(android.os.Debug.isDebuggerConnected())
                android.os.Debug.waitForDebugger();
            String nome = inputNome.getText().toString();
            String descricao = inputDescricao.getText().toString();
            String cidade = inputCidade.getText().toString();
            String uf = inputUf.getText().toString();
            String tamanho = inputTamanho.getText().toString();
            String capacidade = inputCapacidade.getText().toString();
            if(android.os.Debug.isDebuggerConnected())
                android.os.Debug.waitForDebugger();
            // Building Parameters

            List<Pair<String, String>> params = new ArrayList<>();
            params.add(new Pair<>("nome", nome));
            params.add(new Pair<>("descricao", descricao));
            params.add(new Pair<>("cidade", cidade));
            params.add(new Pair<>("uf", uf));
            params.add(new Pair<>("tamanho", tamanho));
            params.add(new Pair<>("capacidade", capacidade));


/*            Schema::create('places', function (Blueprint $table) {
                $table->bigIncrements('id');
                $table->unsignedBigInteger('id_place_type');
                $table->unsignedBigInteger('id_user');
                $table->string('name');
                $table->string('description');
                $table->string('city');
                $table->string('uf');
                $table->float('latitude')->nullable();
                $table->float('longitude')->nullable();
                $table->integer('size')->nullable();
                $table->integer('capacity');
                $table->timestamps();
                $table->foreign('id_place_type')->references('id')->on('place_types');
                $table->foreign('id_user')->references('id')->on('users');
            });
*/


            // getting JSON Object
            // Note that create product url accepts POST method
            HashMap<String,String> map = new HashMap<>();
            for (Pair<String, String> itemMap : params){
                map.put(itemMap.first,itemMap.second);
                System.out.println("ACDFV " + itemMap.first + itemMap.second );
            }

            JSONObject json = jsonParser.makeHttpRequest(url_create_place,
                    "POST", map);
            // check log cat fro response
            try {
            //    Log.d("Create Response", json.toString());
            }catch (NullPointerException e){
                e.printStackTrace();
                Context contexto = getApplicationContext();
                String texto = "Serviço indisponível";
                int duracao = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(contexto, texto,duracao);
                toast.show();
            }catch (Exception e){
                e.printStackTrace();
                Context contexto = getApplicationContext();
                String texto = "Serviço indisponível";
                int duracao = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(contexto, texto,duracao);
                toast.show();
            }
            // check for success tag
            try {
                int success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    // successfully created product
                    //Intent i = new Intent(getApplicationContext(), PlaceCadListActivity.class);
                    //startActivity(i);
                    // closing this screen
                    //finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            pDialog.dismiss();

        }
    }
}
