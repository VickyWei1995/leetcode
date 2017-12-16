#include <vector>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) 
	{
		//sort(nums.begin(), nums.end());
		vector<int> nums_samll;
		vector<int> nums_big;
		vector<int>::iterator it = nums.begin();
		vector<int>::iterator it2;
		vector<int> index;
		for (;it != nums.end(); ++it)
		{
			if (*it <= target / 2)
			{
				nums_samll.push_back(*it);
				cout << "small " << *it;
			}
			else {
					nums_big.push_back(*it);
					cout << "big " << *it;
			}
		}
		for (it = nums_samll.begin(); it != nums_samll.end(); ++it)
		{
			
			if ( (it2 = find(nums_big.begin(), nums_big.end(), target - *it)) != nums_big.end() )
			{
				break;
			}
		}

		//deal with the same elements
		if (it == nums_samll.end())
		{
			if (target % 2 == 0)
			{
				it2 = find(nums_samll.begin(), nums_samll.end(), target / 2);
				it = it2;
			}
		}
		for (int i = 0; i < nums.size(); ++i)
		{
				if ( (nums[i] == *it) || (nums[i] == *it2) )
				{
					index.push_back(i);
				}
				if (index.size() == 2)
				{
					break;
				}
		}
			
		return index;
	}
};

class Solution2
{
public:
	vector<int> twoSum(vector<int> &numbers, int target) {
		// Note: The Solution object is instantiated only once and is reused by each test case.  
		vector<int> num = numbers;
		std::sort(num.begin(), num.end());

		int length = numbers.size();
		int left = 0;
		int right = length - 1;
		int sum = 0;

		vector<int> index;

		while (left < right)
		{
			sum = num[left] + num[right];

			if (sum == target)
			{
				for (int i = 0; i < length; ++i)
				{
					if (numbers[i] == num[left])
					{
						index.push_back(i + 1);
					}
					else if (numbers[i] == num[right])
					{
						index.push_back(i + 1);
					}
					if (index.size() == 2)
					{
						break;
					}
				}
				break;
			}
			else if (sum > target)
			{
				--right;
			}
			else
			{
				++left;
			}
		}

		return index;
	}
};
