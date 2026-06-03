# Leetcode Blind 75 Programs
## 1) Contains Duplicate

Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

Example 1:

```
Input: nums = [1, 2, 3, 3]
Output: true
```
Example 2:
```
Input: nums = [1, 2, 3, 4]
Output: false
```
Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9


```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            if(!set.add(n)){
                return true;
            }
        }
        return false;
    }
}
```

## 2) Valid Anagram

Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:
```
Input: s = "racecar", t = "carrace"
Output: true
```

Example 2:
```
Input: s = "jar", t = "jam"
Output: false
```

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sa = new char[26];
        char[] ta = new char[26];
        for(char c : s.toCharArray()){
            sa[c-'a']++;
        }
        for(char c : t.toCharArray()){
            ta[c-'a']++;
        }
        return new String(sa).equals(new String(ta));
    }
}
```
## 3) Two Sum

Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.

You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

Return the answer with the smaller index first.

Example 1:
```
Input: 
nums = [3,4,5,6], target = 7
Output: [0,1]
```
Explanation: nums[0] + nums[1] == 7, so we return [0, 1].

Example 2:
```
Input: nums = [4,5,6], target = 10
Output: [0,2]
```
Example 3:
```
Input: nums = [5,5], target = 10
Output: [0,1]
```
Constraints:

* 2 <= nums.length <= 1000
* -10,000,000 <= nums[i] <= 10,000,000
* -10,000,000 <= target <= 10,000,000
*  Only one valid answer exists.

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length;  i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;       
    }
}
```

## 4) Group Anagrams

Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:
```
Input: strs = ["act","pots","tops","cat","stop","hat"]
Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
```
Example 2:
```
Input: strs = ["x"]
Output: [["x"]]
```
Example 3:
```
Input: strs = [""]
Output: [[""]]
```

Constraints:

* 1 <= strs.length <= 1000.
* 0 <= strs[i].length <= 100
* strs[i] is made up of lowercase English letters.

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
```

## 5) Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements within the array.

The test cases are generated such that the answer is always unique.

You may return the output in any order.

Example 1:
```
Input: nums = [1,2,2,3,3,3], k = 2
Output: [2,3]
```
Example 2:
```
Input: nums = [7,7], k = 1
Output: [7]
```
Constraints:

*  1 <= nums.length <= 10^4.
* -1000 <= nums[i] <= 1000
* 1 <= k <= number of distinct elements in nums.

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fre = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> fre.get(b) - fre.get(a));
        for(int n : nums){
            fre.put(n, fre.getOrDefault(n,0)+1);
        }
        for(int key : fre.keySet()){
            queue.add(key);
        }

        int[] v = new int[k];
        while(k-- > 0){
            v[k] = queue.poll();
        }
        return v;
    }
}
```
