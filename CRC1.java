import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;


public class CRC1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of data bits : ");
        int n = sc.nextInt();
        
        System.out.println("Enter the length of divisor bits : ");
        int d = sc.nextInt();


        System.out.println("Enter the data bits : ");
        int data[] = new int[n+d-1];

        for(int i = 0; i < n; i++) {
                data[i] = sc.nextInt();
        }

        for (int i = n; i < n + d - 1; i++) {
            data[i] = 0;
        }

        System.out.println("Enter the divisor bits : ");
        int divisor[] = new int[d];

        for(int i = 0; i < d; i++) {
            divisor[i] = sc.nextInt();
        }

        for(int i = 0; i < divisor.length; i++) {
            System.out.print(divisor[i]);
        }

        System.out.println();


        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }

        System.out.println();

        int tempData[] = Arrays.copyOf(data, data.length);

        //LOGIC TO DO XOR DIVISION
        for(int i = 0; i < data.length-divisor.length+1; i++) {
            if(tempData[i] != 0){
                for(int j = 0; j < divisor.length; j++) {
                    tempData[i+j] = tempData[i+j] ^ divisor[j];
                }
            }
        }

      

        int newCRCDataBits[] = Arrays.copyOf(data, data.length);
        //appending the crc bits to the end of the data bits
        for(int i = n; i < tempData.length; i++) {
            newCRCDataBits[i] = tempData[i];
        }

        System.out.print("DATA WITH CRC BITS : ");
        for(int i = 0; i < tempData.length; i++) {
            System.out.print(newCRCDataBits[i]);
        }

        System.out.println();

        for(int i = 0; i < newCRCDataBits.length - divisor.length+1; i++){
            if(newCRCDataBits[i] != 0) {
                for(int j = 0; j < divisor.length; j++) {
                    newCRCDataBits[j+i] = newCRCDataBits[j+i] ^ divisor[j];
                }
                
            }
        }

        System.out.print("ON DIVING THE CRC APPENDED DATA BITS WITH DIVISOR : ");

        for(int i = 0; i < newCRCDataBits.length; i++){
            System.out.print(newCRCDataBits[i]);
        }
    }
}

//OUTPUT

// Enter the length of data bits : 
// 6
// Enter the length of divisor bits : 
// 4
// Enter the data bits : 
// 1 0 0 1 0 0
// Enter the divisor bits : 
// 1 1 0 1
// 1101
// 100100000
// DATA WITH CRC BITS : 100100001
// ON DIVING THE CRC APPENDED DATA BITS WITH DIVISOR : 000000000