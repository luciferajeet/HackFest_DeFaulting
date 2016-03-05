package People;

import java.io.Serializable;

public class Profile implements Serializable{
	public static final char WHITE = 'w';
	public static final char BROWN = 'b';
	public static final char BLACK = 'k';
	String name;
	int age;
	float height;
	boolean status;
	long hash;//for efficient searching
	char skin;
	int gender;
	String notes;
	public Profile(){
		name = "N/A";
		age = 0;
		height = 0;
		hash = -1;
		skin = 'u';
		status = false;
		notes = "N/A";
		gender = 0;
	}
	public void setAll(String name,float height,int age,String IDM,char skin,int gender){
		this.name = name.toUpperCase();
		this.height = height;
		this.age = age;
		this.notes = IDM;
		long calcHash = 0;
		long factor = 2;
		this.gender = gender;
		int i=0;
		while(i<name.length()){
			calcHash+=(factor*((int)(name.charAt(i))));
			factor*=2;
			i++;
		}
		this.hash = calcHash;
		this.skin = skin;
	}
	public void setStatus(boolean status){
		this.status = status;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setGender(int gender){
		this.gender = gender;
	}
	public void setSkin(char c){
		this.skin = c;
	}
	public void setHeight(float height){
		this.height = height;
	}
	public void setNotes(String notes){
		this.notes = notes;
	}
	public boolean getStatus(){
		return status;
	}
	public int getAge(){
		return age;
	}
	public String getName(){
		return name;
	}
	public char getSkin(){
		return skin;
	}
	public float getHeight(){
		return height;
	}
	public int getGender(){
		return gender;
	}
	public void calcHashCode(){
		long calcHash = 0;
		long factor = 2;
		int i=0;
		String lname = name.toUpperCase(); 
		while(i<lname.length()){
			calcHash+=(factor*((int)(lname.charAt(i))));
			factor*=2;
			i++;
		}
		this.hash = calcHash;
	}
	public void print(){
		System.out.println(name+" "+age+" "+height+" "+gender+" "+notes);
	}
}
