# 127 Word Ladder

https://leetcode.com/problems/word-ladder/

## 思路

给定一个beginWord，一个endWord，一个Word数组。利用Word数组中的元素构造一条beginWord到endWord的路径，路径之间的任意2个单词只有一个字母不相同；

BFS，我们设置一个Queue，先把beginWord加进去，作为第一层。然后对第一层的Word进行遍历，对于每个Word修改其中的一个字符，如果修改后可以在word数组中找到单词，将该单词入队，并且从数组中删除；第一层遍历结束后，就会得到第二层的word。遍历每层的时候，需要判断当前层中是否有endWord，如果有的话，说明找到了最短路径，返回层数。

## CPP

```cpp
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        if (beginWord == endWord) {
			return 1;
		}

		int n = beginWord.size();
		if (n < 1 || n != endWord.size()) {
			return 0;
		}

		unordered_set<string> dict;
		for (int i = 0; i < wordList.size(); i++) {
			dict.insert(wordList[i]);
		}

		queue<string> Q;
		Q.push(beginWord);
		dict.erase(beginWord);
		int length = 2;

		while (!Q.empty()) {
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				string word = Q.front(); Q.pop();
				for (int i = 0; i < n; i++) {
					char oldChar = word[i];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == oldChar) continue;
						word[i] = c;
						if (dict.find(word) != dict.end()) {
							if (word == endWord) {
								return length;
							}
							Q.push(word);
							dict.erase(word);
						}
					}
					word[i] = oldChar;
				}
			} // for size
			length++;
		}
		return 0;
    }
    

};
```

