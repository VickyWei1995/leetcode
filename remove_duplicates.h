#include <iostream>
#include <vector>

using namespace std;

//exec delete operation
class Solution_26 {
public:
	int removeDuplicates(vector<int>& nums) {
		if (nums.size() == 0)
			return 0;
		else
		{
			int pre = nums[0];
			//int now;
			vector<int>::iterator it;
			for (it = nums.begin() + 1; it != nums.end(); )
			{
				if (pre == (*it))
				{
					it = nums.erase(it);
				}
				else
				{
					pre = *it;
					++it;
				}
			}
			return nums.size();
		}
	}
};

//move the element that should be deleted to the end of the vactor
class Solution_26_2
{
public:
	int removeDuplicates(vector<int>& nums)
	{
		int sz = nums.size();
		if (sz == 0)
		{
			return 0;
		}
		else 
		{
			int i =1;
			int p = 0;
			for (; i < sz; ++i)
			{
				if (nums[i] != nums[p])
				{
					nums[++p] = nums[i];
				}
			}
			return p + 1;
		}
	}
};