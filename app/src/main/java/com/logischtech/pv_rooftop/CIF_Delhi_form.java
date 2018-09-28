package com.logischtech.pv_rooftop;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.logischtech.pv_rooftop.Models.Discom_model;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_spinner_dropdown_item;

public class CIF_Delhi_form extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner cc, customer, tra;
    List<String> items, customer_caterory, tsf;
    // EditText name , email , phone , pin , totalroofarea , captcha ;
    int count;
    ArrayList<String> user_name;
    String name, email, phone, pin, totalroofarea, captcha, discom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cif__delhi_form);
//        name = (EditText)findViewById(R.id.name);
//        email = (EditText)findViewById(R.id.email);
//        phone = (EditText)findViewById(R.id.phone);
//        pin = (EditText)findViewById(R.id.pin);
//        totalroofarea = (EditText)findViewById(R.id.tra);
//        captcha = (EditText)findViewById(R.id.captcha);
        Button btn_submit = (Button) findViewById(R.id.submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String flag = "true";
                name = ((EditText) findViewById(R.id.name)).getText().toString();
                email = ((EditText) findViewById(R.id.email)).getText().toString();
                phone = ((EditText) findViewById(R.id.phone)).getText().toString();
                pin = ((EditText) findViewById(R.id.pin)).getText().toString();
                totalroofarea = ((EditText) findViewById(R.id.tra)).getText().toString();
                captcha = ((EditText) findViewById(R.id.captcha)).getText().toString();

                //  discom = ((Spinner) findViewById(R.id.cc)).getTransitionName()


                new HttpSubmit().execute(flag);
            }
        });


        cc = (Spinner) findViewById(R.id.cc);
        customer = (Spinner) findViewById(R.id.contumer);
        tra = (Spinner) findViewById(R.id.tsf);


        customer_caterory = new ArrayList<String>() {{

            add("Select");
            add("Domestic");
            add("Social Sector");
            add("Institution");


        }};
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(CIF_Delhi_form.this, simple_spinner_dropdown_item, customer_caterory);
        dataAdapter2.setDropDownViewResource(simple_spinner_dropdown_item);
        customer.setAdapter(dataAdapter2);


        tsf = new ArrayList<String>() {{

            add("Select");
            add("Square Meter");
            add("Square Feet");


        }};
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<>(CIF_Delhi_form.this, simple_spinner_dropdown_item, tsf);
        dataAdapter1.setDropDownViewResource(simple_spinner_dropdown_item);
        tra.setAdapter(dataAdapter1);


        String stateId = "1";
        new HttpDiscomList().execute(stateId);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private class HttpDiscomList extends AsyncTask<Object, Object, List<Discom_model>> {
        private ProgressDialog progress = new ProgressDialog(CIF_Delhi_form.this);

        @Override
        protected List<Discom_model> doInBackground(Object... params) {

            Object stateId = params[0];
            String url = "http://174.138.120.61/api/discom?stateId=" + stateId;
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.setErrorHandler(new CustomResponseErrorHandler());
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            CIF_Model apiResponse = restTemplate.getForObject(url, CIF_Model.class);

            try {

                List<Discom_model> result = apiResponse.getData();
                return result;


            } catch (Exception ex) {

            }


            return null;
        }

        @Override
        protected void onPreExecute() {
            //   getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            this.progress.setMessage("Loading Results");
//            progress.setCancelable(true);
//            progress.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                @Override
//                public void onCancel(DialogInterface dlg) {
//                    HttpRequestTask.this.cancel(true);
//                }
//            });


            this.progress.show();
        }

        @Override
        protected void onPostExecute(final List<Discom_model> discom_model) {

            super.onPostExecute(discom_model);

            if (progress.isShowing()) {
                progress.dismiss();
            }
            count = discom_model.size();

            items = new ArrayList<String>() {{

                add("Select");
                for (int i = 0; i < count; i++) {
                    add(discom_model.get(i).getUser().getName().toString());

                }


            }};


            ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(CIF_Delhi_form.this, simple_spinner_dropdown_item, items);
            dataAdapter.setDropDownViewResource(simple_spinner_dropdown_item);
            cc.setAdapter(dataAdapter);


            // }


        }


    }

    private class CustomResponseErrorHandler implements ResponseErrorHandler {
        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            return false;
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {

        }
    }

    private class HttpSubmit extends AsyncTask<Object, Object, ResponseEntity<String>> {
        private ProgressDialog progress = new ProgressDialog(CIF_Delhi_form.this);


        @Override
        protected ResponseEntity<String> doInBackground(Object... params) {

            try {
                Object flag = params[0];

                String url = "http://174.138.120.61/api/enquiries?flag=" + flag;
                RestTemplate restTemplate = new RestTemplate();

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

                MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
                map.add("name", name.toString());
                map.add("email", email.toString());
                map.add("phone", phone.toString());
                map.add("pincode", pin.toString());
                map.add("roofTopArea", totalroofarea.toString()+"Square Meter");
                map.add("stateId", "1");
                map.add("discomId", "1");
                map.add("consumerCategory", "Domestic");


                HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

                ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
                return response;

            } catch (Exception ex) {

                this.progress.setMessage("");



            }


            return null;
        }

        @Override
        protected void onPreExecute() {
            //   getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            this.progress.setMessage("Loading Results");
//            progress.setCancelable(true);
//            progress.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                @Override
//                public void onCancel(DialogInterface dlg) {
//                    HttpRequestTask.this.cancel(true);
//                }
//            });


            this.progress.show();
        }

        @Override
        protected void onPostExecute(final ResponseEntity<String> response) {

            super.onPostExecute(response);

            if (progress.isShowing()) {
                progress.dismiss();
            }

        }
    }
}