#include <iostream>
#include <string>
#include <map>

using namespace std;

class solution_13
{
public:
	int romanToInt(string s)
	{
		map<char, int> map_roman_int;
		map_roman_int[char('I')] = 1;
		map_roman_int[char('V')] = 5;
		map_roman_int[char('X')] = 10;
		map_roman_int[char('L')] = 50;
		map_roman_int[char('C')] = 100;
		map_roman_int[char('D')] = 500;
		map_roman_int[char('M')] = 1000;
		int i, pre =0;
		int result = 0;
		map<char, int >::iterator it;
		
		for (i = s.length() - 1; i >= 0; --i)
		{
			it = map_roman_int.find(s[i]);
			result += (it->second < pre ? (-1) : (1)) * it->second;
			pre = it->second;
		}
		return result;
	}
};
