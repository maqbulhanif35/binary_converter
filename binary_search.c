#include <stdio.h>
#include <stdlib.h>
int main()
{
	int array[10000];
	for (int i = 0; i < 10000; ++i)
	{
		array[i]=i;
	}
	int first,middle,last;
	int size=(sizeof(array))/sizeof(array[0]);
	first=0;
	middle=size/2;
	last=size;
	int target=43994;
	while(first<=last){
		if (array[middle]==target)
		{
			printf("%d\n",array[middle] );
			break;
		}
		else if (array[middle]>target)
		{
			last=middle-1;
			middle=(first+last)/2;
		}
		else if (array[middle]<target)
		{
			first=middle+1;
			middle=(first+last)/2;
		}
	}
	return 0;
}