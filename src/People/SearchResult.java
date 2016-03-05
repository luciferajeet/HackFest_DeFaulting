package People;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SearchResult {
	JFrame frame;
	public SearchResult(ArrayList<Profile> results) {
		frame = new JFrame();
		String titles[]={"Name","Gender","Age","Height","Skin Color","Notes"};
		Object data[][] = new Object[results.size()][6];
		for(int i=0;i<results.size();i++){
			data[i][0] = results.get(i).name;
			if(results.get(i).gender!=0)
				data[i][1] = (results.get(i).gender==1?"MALE":"FEMALE");
			else{
				data[i][1] = ("N/A");
			}
			if(results.get(i).age!=0){
				data[i][2] = Integer.toString(results.get(i).age);
			}else{
				data[i][2] = "N/A";
			}
			if(results.get(i).height!=0){
				data[i][3] = Float.toString(results.get(i).height);
			}else{
				data[i][3] = "N/A";
			}
			if(results.get(i).skin!='u'){
				if(results.get(i).skin=='w')
					data[i][4] = "WHITE";
				else if(results.get(i).skin=='b')
					data[i][4] = "BROWN";
				else
					data[i][4] = "BLACK";
			}else{
				data[i][4] = "N/A";
			}
			if(!results.get(i).notes.equals("")){
				data[i][5] = results.get(i).notes;
			}else{
				data[i][5] = "N/A";
			}
		}
		JTable table = new JTable(data,titles);
		//table.setBounds(0,0,50,50);
		JScrollPane jsp = new JScrollPane(table);
		frame.add(jsp);
		frame.setSize(700,400);
		frame.setTitle("Search Results");
		frame.setVisible(true);
	}
}
