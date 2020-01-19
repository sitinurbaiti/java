package datastockbarang.com;

import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 
public class MainActivity extends Activity {
    /** Called when the activity is first created. */
       EditText aa,bb,cc,dd;
       Button sim;
     
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aa=(EditText)findViewById(R.id.ekdbrg);
        bb=(EditText)findViewById(R.id.enmbrg);
        cc=(EditText)findViewById(R.id.esatuan);
        dd=(EditText)findViewById(R.id.ejumlah);
        sim=(Button)findViewById(R.id.simpan);
        sim.setOnClickListener(new OnClickListener() {
                   
 
                     public void onClick(View v) {
                           // TODO Auto-generated method stub
                           ArrayList<NameValuePair> postparameter=new ArrayList<NameValuePair>();
                           postparameter.add(new BasicNameValuePair("kodebarang", aa.getText().toString()));
                           postparameter.add(new BasicNameValuePair("namabarang", bb.getText().toString()));
                           postparameter.add(new BasicNameValuePair("satuan", cc.getText().toString()));
                           postparameter.add(new BasicNameValuePair("jumlah", dd.getText().toString()));
                           String respon=null;
                           try{
                                  respon=CustomHttpClient.executeHttpPost("http://10.0.2.2/android/koneksi.php",postparameter);
                                  String res=respon.toString();
                                  res=res.trim();
                                  res=res.replaceAll("\\s", "");
                                  if(res.equals("1"))
                                         Toast.makeText(getApplicationContext(),"Data Sudah Tersimpan" , Toast.LENGTH_LONG).show();
                                  else
                                         Toast.makeText(getApplicationContext(),"Data Sudah Tersimpan Ke Server" , Toast.LENGTH_LONG).show();
                           }catch(Exception e){
                                  Toast.makeText(getApplicationContext(), "Error :"+ e.toString(), Toast.LENGTH_LONG).show();
                           }
                         
                     }
              }
        );
       
    }
}
