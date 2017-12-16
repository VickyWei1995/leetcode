#pragma once
#include <iostream>
#include <list>
#include <map>

using namespace std;

class Solution {
public:
	bool isValid(string s) {
		list<char> valid_test;
		int i = 0;
		map<char, char> map_char_char;
		map_char_char[char(')')] = '(';
		map_char_char[char('}')] = '{';
		map_char_char[char(']')] = '[';
		while (i < s.length())
		{
			if (s[i] == '(' || s[i] == '{' || s[i] == '[')
			{
				valid_test.push_back(s[i]);
			}
			else
			{
				if (s[i] == ')' || s[i] == '}' || s[i] == ']')
				{
					if (valid_test.size()>0 && valid_test.back()==map_char_char[s[i]] )
					{
						valid_test.pop_back();
						cout << s[i] << "\n";  
					}
					else
					{
						break; //not match
					}
				}
				else
				{
					cout << "invalid input char." << "\n";
					break;
				}
			}
			++i;
		}
		cout << i << "\n";
		cout << valid_test.size();

		return (i == s.length() && valid_test.size() == 0) ? true : false;
	}
};