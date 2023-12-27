//This program uses the successive division method to get the binary equivalent. 
//The While loop inside the main function is the main engine behind the program.
//The functions printArray,reverseArray and removeZeros are just there to help present the output better.
//As the name suggests the printArray function prints the final array. It takes an array as an argument and returns nothing.
//The reverseArray function is there to reverse the output of the while loop. This is because the binary is first produced backwards,
//eg 1101 would be 1011 so this function reverses it. It takes an array as an argument and returns an array.
//The removeZeros function is just to remove any insignificant 0s so as to make the output more readable, eg the 0s in 0011
//don't matter and can be removed.
import java.util.Arrays;   
import java.util.Scanner;  
public class Main {
    static int[] reverseArray(int []d){
      int [] r=new int [d.length];
      for (int z=0;z<d.length ;++z ) {
        r[z]=d[(d.length-1)-z];
      }
      return r;
    }
    static int[] refineInput(String d){
      //convert string to int and then put it into an array and return it
      String []n=d.split("[,]",0);
        int []out=new int[n.length];
      for (int z=0;z<n.length;++z ) {
        out[z]=Integer.parseInt(n[z]);
      }
      return out;

    }
    static int  checkBinary(int []t){
      int status=0;
      for (int z=0;z<t.length ;++z ) {
        
        if(t[z]!=0&&t[z]!=1){
          status=1;
        }
      }
      return status;
    }
    static void two(){
    System.out.printf("Enter the number to convert(Seperate the bits with commas): ");
    Scanner scanf=new Scanner(System.in);
    String t=scanf.nextLine();
    int []input=refineInput(t);
    int[] y=reverseArray(input);
    if(checkBinary(y)==1){
      System.out.println("Please Enter valid binary number");
      System.exit(0);
    };
    int output=0;
    for (int z=0;z<y.length ;++z ) {
      output=output+(((int)(Math.pow(2,z)))*y[z]);
    }
    System.out.println(output);
  }
    static void printArray(int []d){
      for (int z=0;z<d.length ;++z ) {
        System.out.printf(d[z]+"");
      }
    }
    static int[] removeZeros(int[]d){
      int counter=0;int z=0;
      while(d[z]!=1){
          counter+=1;
          z+=1;
      }
      int []slicedArray=Arrays.copyOfRange(d,counter,d.length);
      System.out.println("Size="+slicedArray.length+" bits");
      return slicedArray;
    }
    static void one(){
    System.out.printf("Enter number to convert: ");
    Scanner myObj = new Scanner(System.in);
    int input=myObj.nextInt();
    int [] output=new int[16];
    int y=0;
    while (input>0) {
      if (input%2==0) {
        output[y]=0;
      }
      if (input%2==1) {
        output[y]=1;
      }
      input=input/2;
      y=y+1;
    }
    int[] store=reverseArray(output);
    int []store0=removeZeros(store);
    printArray(store0);
    }
  public static void main(String [] args) {//and this is the main function
    System.out.printf("Select mode: \nDecimal to binary(1)\nBinary to decimal(2)\n>>");
    Scanner myObj = new Scanner(System.in);
    int input=myObj.nextInt();
    if(input==1){
      System.out.println("\033[H\033[2J");
      one();
    }
    if (input==2) {
      System.out.println("\033[H\033[2J");
      two();
    }
  }
}
//use successive division to find binary equivalent
