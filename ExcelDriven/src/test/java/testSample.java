import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		dataDriven d = new dataDriven();
		ArrayList<String> data = d.getData("Add profile");
		
		for(int i=0;i<data.size();i++) {
			System.out.println(data.get(i));
		}
	}
}
