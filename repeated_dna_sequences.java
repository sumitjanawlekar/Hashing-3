// Time Complexity :O(n), where n is the size of the string
// Space Complexity :O(n), where n is the size of the string (exactly 2(n), space for 2 sets)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner approach of your code in plain English
//Intuition -> Create all subStrings of length 10 and add it to set, whilst checking if the current subString was already added
                //to the set. If yes, then that is one of your resultant repeating DNA
//1. Create 2 hashSets, 1 to store all the continous substrings of length 10, and other set to store the unqiue repeating sunString 
        //in set 1
//2. Iterate over the String s, form subStrings of length 10. Check if that subtring is already present in set1, if yes, add it to 
        //the 2nd set, as it is one of our resultant subString. At each iteration, also add the subString in set1(as it contains 
        //all the possible continous subStrings)
//3. In the end convert the 2nd set into Arraylist and return

// Your code here along with comments explaining your approach

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //edge case
        if(s == null || s.length() == 0) return new ArrayList<>();
        
        //create a hashSet to store all the continuous substrings of length 10
        Set<String> set = new HashSet<>();
        //create a set to only store the unquie results
        Set<String> result = new HashSet<>();
        
        //iterate over the substring(s) in String s
        for(int i=0; i<=s.length()-10; i++){
            //make substrings of length 10
            String subString = s.substring(i, i+10);
            //add to the result, if the current subString has previously being explored
            if(set.contains(subString)){
                result.add(subString);
            }
            //everytime add to the set containing all the subStrings
            set.add(subString);
        }
        
        //convert set to arrayList before returning
        return new ArrayList<>(result);
    }
}