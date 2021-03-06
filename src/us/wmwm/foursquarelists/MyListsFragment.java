package us.wmwm.foursquarelists;

import java.util.concurrent.Future;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MyListsFragment extends Fragment {

	ListView list;
	
	Future<?> loadListsFuture;
	
	FoursquareApi foursquareApi;
	
	public void setFoursquareApi(FoursquareApi foursquareApi) {
		this.foursquareApi = foursquareApi;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Threads.getExecutor().submit(loadLists);
	}
	
	Runnable loadLists = new Runnable() {
		public void run() {
			try {
				FoursquareList l = foursquareApi.getLists();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_my_lists,container,false);
		list = (ListView) view.findViewById(R.id.list);
		return view;
	}
	
}
