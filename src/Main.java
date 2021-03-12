import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int numx;
    private static int numy;

    public static void main(String[] args) throws IOException {
        String num1;
        do {
        		num1 = br.readLine();
                int num = Integer.parseInt(num1);
                String numStr = br.readLine();
                String[] arrNumStr = numStr.split(" ");
                int[] arrNum = arrToInt(arrNumStr, num);
                int money = Integer.parseInt(br.readLine());

                setNums(arrNum, money);
                bw.write("Peter should buy books whose prices are " + numx + " and " + numy + ".\n");
                num1 = br.readLine();
        }while (num1 != null);
        br.close();
        bw.close();
    }

    public static void setNums(int[] arrNum, int money) {
        ArrayList<Integer> auxNums = new ArrayList<>();
        for (int i = 0; i < arrNum.length - 1; i++) {
            for (int j = i + 1; j < arrNum.length; j++) {
                if (arrNum[i] + arrNum[j] == money) {
                    auxNums.add(arrNum[i]);
                    auxNums.add(arrNum[j]);
                }
            }
        }
        int auxDif = -1;
        int auxIndex = -1;
        for (int i = 0; i < auxNums.size(); i += 2) {
            for (int j = 1; j < auxNums.size(); j += 2) {
                if (auxNums.get(i) < auxNums.get(j)) {
                    int auxSort = auxNums.get(i);
                    auxNums.set(i, auxNums.get(j));
                    auxNums.set(j, auxSort);
                }
                int aux = auxNums.get(i) - auxNums.get(j);
                if (aux < auxDif || auxDif == -1) {
                    auxDif = aux;
                    auxIndex = i;
                }
            }
        }
        numx = auxNums.get(auxIndex + 1);
        numy = auxNums.get(auxIndex);
    }

    public static int[] arrToInt(String[] arrNumStr, int num) {
        int[] numArr = new int[num];
        for (int i = 0; i < num; i++) {
            numArr[i] = Integer.parseInt(arrNumStr[i]);
        }
        return numArr;
    }
}
