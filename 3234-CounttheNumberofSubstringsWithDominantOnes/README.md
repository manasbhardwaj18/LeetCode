You are given a binary string s.

Return the number of substrings with dominant ones.

A string has dominant ones if the number of ones in the string is greater than or equal to the square of the number of zeros in the string.

 
Example 1:


Input: s = "00011"

Output: 5

Explanation:

The substrings with dominant ones are shown in the table below.


ijs[i..j]Number of ZerosNumber of Ones33101441012301113411022401112

Example 2:


Input: s = "101101"

Output: 16

Explanation:

The substrings with non-dominant ones are shown in the table below.

Since there are 21 substrings total and 5 of them have non-dominant ones, it follows that there are 16 substrings with dominant ones.


ijs[i..j]Number of ZerosNumber of Ones110104401014011022041011023150110123

 
Constraints:


	1 <= s.length <= 4 * 104
	s consists only of characters '0' and '1'.

