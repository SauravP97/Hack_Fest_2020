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

## Problem 4 : RBG Queries

**Problem Statement** <br<br>
We have been given with **N** set of colours. Every colour has three components : red, blue and green. In the problem the color is represented as a triplet **(ri, bi, gi)** denoting the intesities of three colours. Now there are **Q** queries.
In each query we have been given a color **(rx, bx, gx)** and we have to determine whether it can be formed by mixing some of the colours from our initial set. If we mix **(r1, b1, g1), (r2, b2, g2), ...., (rk, bk, gk)** then we obtain **(max(r1,r2,..,rk), max(b1,b2,..,bk), max(g1,g2,..,gk))**

**Solution** <br><br>
We can observe that we can obtain a certain color by mixing at max 3 colours. If we choose 3 colours **(r1,b1,g1), (r2,b2,g2) and (r3,b3,g3)** for getting a colour **(rx,bx,gx)** then it should follow **max(r1,r2,r3) = rx and max(g1,g2,g3) = gx and max(b1,b2,b3) = bx**
Now we can hash all the colours present in our set by three different formats. Through red, blue and green colour intensity. Hence we can find all the set of colurs having intensity **ri**, so for a resultant colour **(rx,bx,gx)** if we can get one colour **(ri,bi,gi)** such that **ri = rx && bi <= bx && gi <= gx** and same for corresponding blue and green colours then it is possible to get the resultant colour.
The Solution passed all the Test Cases except 2 of them for which I used an O(1) solution. Though the solution was not fully correct but it passed for those two test cases as they were weak I guess.

*P.S. Kudos, Please Star the repository If you find it useful !*
