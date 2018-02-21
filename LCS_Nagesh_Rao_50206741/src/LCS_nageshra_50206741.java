
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LCS_nageshra_50206741 {

	public static void main(String[] args) throws IOException {
		int j, i = 0, count = 0;
		File output = new File("output.txt");
		File input = new File("input.txt");
		FileReader fr = new FileReader(input);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
		String[] str = new String[10];
		String x = "";
		String line = "";
		while ((line = br.readLine()) != null) {
			str[i] = line;
			count++;
			i++;
		}
		br.close();
		int m = str[0].length();
		int n = str[1].length();
		int[][] opt = new int[m+2][n+2];
		String[][] pi = new String[m+2][n+2];
		for (j = 0; j <= n; j++) {
			opt[0][j] = 0;
			pi[0][j] = "bottom";
		}

		for (i = 1; i <= m; i++) {
			opt[i][0] = 0;
			pi[i][0] = "bottom";
			count = 0;
			for (j = 1; j <= n; j++) {
				if (str[0].charAt(i-1) == str[1].charAt(j-1)) {
					opt[i][j] = opt[i - 1][j - 1] + 1;
					pi[i][j] = "diag";
				} else if (opt[i][j - 1] >= opt[i - 1][j]) {
					opt[i][j] = opt[i][j - 1];
					pi[i][j] = "left";
				}

				else {
					opt[i][j] = opt[i - 1][j];
					pi[i][j] = "up";
				}

			}

		}
		i--;
		j--;	
		while (pi[i][j]!= "bottom" && j !=0) {
			if (pi[i][j] == "diag") {
				x += str[1].charAt(j-1);
				count++;
				i = i - 1;
				j = j - 1;

			} else if (pi[i][j] == "up") {
				i = i - 1;
			} else if (pi[i][j] == "left")
				j = j - 1;
			else
				j--;
		}
		String reverse = "";
		for ( i = x.length()- 1 ; i >= 0 ; i-- )
		     reverse  += x.charAt(i);
		String f="";
		f += count + "\n" + reverse;
		System.out.println(f);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
		bw.write(f);
		bw.close();

	}
}
