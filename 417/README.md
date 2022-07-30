# 417 Pacific AtlanticWater Flow

https://leetcode.com/problems/pacific-atlantic-water-flow/



## 思路

给定一个m*n的二维数组，数组保存的为i,j 处的高度。水流从高往低流，求可以流向大西洋和太平洋的index。左上边连接太平洋，右下边连接大西洋。思路的话，设置2个数组，一个是can_reach_太平洋，一个是can_reach_大西洋。

我们从终点开始遍历，即大西洋和太平洋的四条边，更新这个数组。



