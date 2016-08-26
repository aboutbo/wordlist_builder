import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Wordlist{	
	public static void main(String[] args){	
		System.out.println("The number of parameters(n):");
		int n = 0;
		ArrayList<String> parameter = new ArrayList<String>();
		ArrayList<String> passwd = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.nextLine();
		String tmp;
		for(int i = 1;i <= n;i++){
			System.out.printf("NO.%d\n",i);
			tmp = in.nextLine();
			parameter.add(tmp);
		}
		int size = parameter.size();
		String[] Parameter = (String [])parameter.toArray(new String[size]);
		/*for(String p1 : Parameter){
			for(String p2 : Parameter){
				passwd.add(p1 + p2);
				passwd.add(p2 + p1);
			}
		}*/
		String p1,p2;
		for(int j = 0;j < size;j++){
			passwd.add(Parameter[j]);
			p1 = Parameter[j];
			for(int k = 0;k < size;k++){
				p2 = Parameter[k];
				passwd.add(p1 + p2);
				//if(j != k){
					//passwd.add(p2 + p1);
				//}
			}
		}
		try{
			OutputStream f = new FileOutputStream("/home/xb/文档/wordlist/person.txt");
			PrintStream p = new PrintStream(f);
			int size1 = passwd.size();
			for(int l = 0;l < size1;l++){
				p.printf("%s\n",passwd.get(l));
				System.out.printf("%s\n",passwd.get(l));
			}
		}
		catch(FileNotFoundException e){
			System.out.println("file not found");
		}
		in.close();
	}
}
