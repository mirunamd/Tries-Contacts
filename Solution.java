import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        Trie t = new Trie();
        
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            if(op.equals("add")) {
            	t.add(contact);
            }else {
            	System.out.println(t.find(contact));
            }
        }
    }
}

class Trie{
	Node root;
	
	Trie(){
		root = new Node();
	}
	
	int find(String contact) {
		Node curr = root;
		
		for(char c : contact.toCharArray()) {
			if(curr.getChild(c) == null)
				return 0;
			curr = curr.getChild(c);
		}
		
		return curr.size;
	}

	void add(String s) {
		Node curr = root;
		
		for(char c : s.toCharArray()) {
			curr.add(c);
			curr = curr.getChild(c);
			curr.size++;
		}
	}
}

class Node{
	int size = 0;
	HashMap<Character, Node> children = new HashMap<>();
	
	void add(Character c) {
		children.putIfAbsent(c, new Node());
	}

	Node getChild(Character c) {
		return children.get(c);
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(size + " ");
		
		for(Character c : children.keySet()) {
			s.append(c + " ");
		}
		
		return s.toString();
	}
}