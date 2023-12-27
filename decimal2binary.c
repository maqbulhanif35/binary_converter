#include <stdio.h>
#include <stdlib.h>
int binary[12];
int binary2[122];
int input;int bits;
int  getI(){
	printf("%s","Enter number to convert: ");
	scanf("%d",&input);
	return input;
}
int status;
int start=0;int end=3;
void reverse(int array[], int start, int end) 
{ 
    while (start < end) 
    { 
        int hold = array[start];  
        array[start] = array[end]; 
        array[end] = hold; 
        start++; 
        end--; 
    }  
}
void printArray(int array[]){
	for (int i = 0; i < bits; ++i)
	{
		printf("%d",binary[i] );
	}
}
int main(int argc, char const *argv[])
{
	getI();
	int i=0;
	while(input>0){
		//check if remainder is divisible by 2, if it is store it in binary[]
		if (input%2==0)
		{
			binary[i]=0;
		}else{
			binary[i]=1;
		}
		input=input/2;
		i+=1;
		bits+=1;
	}
	//reverse the array  >>
	reverse(binary,0,bits-1);
	printArray(binary);
	//<<
	return 0;
}