# Hack_Fest_2020
Code Solution for all the 4 Problems of HackFest 2020 held on HackerRank

## Problem 1 : Cyclic Binary String

**Problem Statement** <br><br>
The Problem is based on Bit Manipulation. The Problem wants us to tell the maximum power of 2 from which a binary string can be divisible if we are free to cyclically shift it any number of times.
 
 **Solution**<br><br>
 When we observe a binary string it can be found that if a string is divisible by 2^n then its last n digits must be 0. So now the problem comes down simply to   compute the largest continous substring of 0s present in the current binary String. Remember to check the leftmost and rightmost substrings together as there can be any number of rotations. The maximum value obtained will be the desired answer. 

## Problem 2 : Game of Maximization

**Problem Statement** <br><br>
The Problem is fairly simple. There are n piles and each pile have some amount of stones in it. We need to pick maximum stones from the piles in such a way that the number of stones picked from piles at even positions is equal to that of at odd positions.

**Solution** <br><br>
Compute the sum of stones present in the piles at odd indices and same for the even indices. Lets say them **oddSum** and **evenSum**. Now compute the minimum of the two and return ***2 x min(oddSum, evenSum)***.

## Problem 3 : Strictly Increasing Sequence

**Problem Statement** <br><br>
The problem is based on Game Theory. We have been given an array of length N. There are 2 Players. On each turn a player can reorder the sequence into a strictly increasing one and win the game, or else he can choose any element and remove it.

**Solution** <br><br>
Here we can observe that if the given array does not contains any duplicate numbers then it can be re-arranged into a strictly increasing sequence and first player wins. But if there is any duplicate element then we can keep the game running till only 2 elements are left in the array (an interesting observation). So if incase of duplicates we only need to check the size of the array i.e. **N**. If it's even then Second player wins or else First Player wins the game.
