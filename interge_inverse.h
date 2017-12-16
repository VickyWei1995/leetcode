#include <vector>
#include <iostream>
#include <string>
#include <math.h>

using namespace std;

class solution_7
{
public:
	int reverse(int x) 
	{
		vector<int> nums;
		vector<int>::iterator it;
		long y = 0;
		int i, flag=0;
		int tmp = x;
		for (i=9; i>= 0; --i)
		{
			y = tmp / int(pow(10, i));
			nums.push_back(y);
			tmp = tmp - (y) * pow(10, i);
			cout << pow(10, i) << "\n";
			if ( (y!=0) && (flag==0) )
			{
				flag = i;
			}
			cout << "num: " << y << "\n";
			cout << "input: " << tmp << "\n";
		}

		//cout << nums.size() << "\n";
		it = nums.end();
		y = 0;
		for (i = flag; i >= 0; --i)
		{
			--it;
			y += pow(10, i) * (*it);
		}
		return y < INT_MIN || y > INT_MAX ? 0 : y;
	}
};
