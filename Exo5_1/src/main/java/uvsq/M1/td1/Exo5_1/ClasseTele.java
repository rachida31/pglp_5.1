package uvsq.M1.td1.Exo5_1;


public class ClasseTele {
	
	private Telephone type;
	private String num;
	
	public ClasseTele(Telephone type,String num)
	{
		this.num=num;
		this.type=type;
	}
	
	public Telephone getType() {
		return type;
	}
	
	public String getNum() {
		return num;
	}


}
