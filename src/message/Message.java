package message;

public class Message {

	public String src;
	public int seq_Num ;
	public Boolean duplicate;
	public String dest;
	public String kind;
	public Object data;
	
	public Message(String dest, String kind, Object data) {
		this.dest = dest;
		this.kind = kind;
		this.data = data;
	}
	
	//Setters
	public void setSrc(String src) {
		this.src = src;
	}

	public void setSeq_Num(int seq_num) {
		this.seq_Num = seq_num;
	}

	public void setDuplicate(Boolean duplicate) {
		this.duplicate = duplicate;
	}

	
	
}
