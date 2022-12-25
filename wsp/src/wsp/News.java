package wsp ;

import java.io.Serializable;

public class News implements Serializable 
{
	public String title;
	public String content;
	
	public News(){
		super();
	}
	public News(String title,String content){
		this.title = title;
		this.content = content;
	}
	
	public String toString() {
		return this.title +"\n\n" + this.content;
	}
}

