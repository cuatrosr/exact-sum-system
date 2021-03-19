import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int numx;
    private static int numy;

    public static void main(String[] args) throws IOException {
        String num1 = br.readLine();
        do {
        	if (!num1.equals("")) {
                int num = Integer.parseInt(num1);
                String numStr = br.readLine();
                String[] arrNumStr = numStr.split(" ");
                int[] arrNum = arrToInt(arrNumStr, num);
                int money = Integer.parseInt(br.readLine());
                setNums(arrNum, money);
                bw.write("Peter should buy books whose prices are " + numx + " and " + numy + ".\n\n");
			}
        	num1 = br.readLine();
        }while (num1 != null);
        br.close();
        bw.close();
    }

    public static void setNums(int[] arrNum, int money) {
    	Arrays.sort(arrNum);
        ArrayList<Integer> auxNums = new ArrayList<>();
        int i = 0;
        int j = arrNum.length - 1;
        int monAux = money;
        int pos = -1;
        for (int x = 0; x < arrNum.length; x++) {
        	while (i<=j && pos < 0) {
        		int m = (i+j)/2;
        		if (arrNum[m] + arrNum[x] == money && m != x) {
					auxNums.add(arrNum[m]);
					auxNums.add(arrNum[x]);
					pos = m;
				} else if (arrNum[m] + arrNum[x] >= money) {
					j = m - 1;
				} else {
					i = m + 1;
				}
        	}
        	pos = -1;
        	i = 0;
        	j = arrNum.length - 1;
        }
        
        for (int k = 0; k < auxNums.size(); k += 2) {
			if (Math.abs(auxNums.get(k) - auxNums.get(k+1)) < monAux) {
				monAux = auxNums.get(k) - auxNums.get(k+1);
				numx = auxNums.get(k + 1);
		        numy = auxNums.get(k);
			}
		}
    }

    public static int[] arrToInt(String[] arrNumStr, int num) {
        int[] numArr = new int[num];
        for (int i = 0; i < num; i++) {
            numArr[i] = Integer.parseInt(arrNumStr[i]);
        }
        return numArr;
    }
}
