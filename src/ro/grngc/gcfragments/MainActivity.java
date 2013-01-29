package ro.grngc.gcfragments;

import ro.grngc.gcfragments.MainFragment.UiListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class MainActivity extends FragmentActivity implements UiListener{
    @SuppressWarnings("unused")
	private MainFragment fragment;
	private AlertDialog emptyTaskDialog;
    @Override
    protected void onCreate(Bundle arg0) {
            super.onCreate(arg0);
            setContentView(R.layout.activity_main);
            fragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.main_fragment);
    }
    public void onButtonClicked(View view){
          // handle button clicked
    	emptyTaskDialog = new AlertDialog.Builder(this)
		.setTitle(R.string.simple_info)
		.setMessage(R.string.simple_message)
		.setPositiveButton(R.string.continue_frames, new AlertDialog.OnClickListener(){
			public void onClick(DialogInterface dialog, int which) {
				 openMoreFragments();
			}
		})
		.setNeutralButton(R.string.dismiss, new AlertDialog.OnClickListener(){
			public void onClick(DialogInterface dialog, int which) {
				emptyTaskDialog.cancel();
			}
		})
		.setNegativeButton(R.string.close, new AlertDialog.OnClickListener(){
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		}).create();
    	emptyTaskDialog.show();
    }
	protected void openMoreFragments() {
		 Intent intent = new Intent(this, NewsFragmentsActivity.class);
		 startActivity(intent);
	}
	@Override
	public void onButtonClicked() {
		// TODO Auto-generated method stub
		
	}
}
