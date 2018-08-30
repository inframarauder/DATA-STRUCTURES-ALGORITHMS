import java.util.*;
class brackets{


static	char counterPart(char c){
		if(c == ')')
			return '(';
		else if (c == '}')
			return '{';
		else  if(c == ']')
			return '[';
		else 
			return '\0';
	}

	static boolean matchBrackets(String exp){
		boolean flag;
		Stack<Character> stack=new Stack<Character>();
		for(int i=0; i<exp.length(); i++)
		{
			char c=exp.charAt(i);
			if(c == '(' || c == '{' || c == '[')
				stack.push(c);
			else if(c == ')' || c == '}' || c == ']')
			{
				if( counterPart(c) ==  stack.peek())
					stack.pop();
				else
				{
					flag = false;
					break;
				}
			}
		}
		if (stack.empty() ==  true)
			flag = true;
		else
			 flag =  false;

			return flag;
	}

	 public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("ENTER AN EXPRESSION WITH BRACKETS :");
		String exp=in.nextLine();
		if(matchBrackets(exp) == true)
			System.out.println("BRACKETS ARE BALANCED!");
		else
			System.out.println("BRACKETS ARE UNBALANCED!");
		in.close();
	}
}