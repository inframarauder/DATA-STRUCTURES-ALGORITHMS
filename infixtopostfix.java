//A program to convert an infix expression to postfix

import java.util.Scanner;
import java.util.Stack;

class infixtopostfix
{

	public static boolean isOperator(char C) {
    if (C == '+' || C == '-' || C == '*' || C == '/' || C == '%' )
        return  true;
    return false;
}

public static boolean isOperand(char C){                                // This solution is for single character operands only.
    if (C >= '0' && C<='9' || C >= 'a' && C<='z' || C >= 'A' && C<='Z')
        return true;
    return false;
}

public static boolean hasHigherPrecedence(char op1, char op2){
    int op1Weight = GetOperatorWeight(op1);
    int op2Weight = GetOperatorWeight(op2);
    if (op1Weight == op2Weight){
        return true;
    }
    return op1Weight>op2Weight? true : false;
}

public static int GetOperatorWeight(char op){
    int weight = -1;
    switch (op)
    {
        case '+':
        case '-':
            weight = 1;
            break;
        case '*':
        case '/':
        case '%':
            weight = 2;
    }
    return weight;
}
static String getPostfix(String infix)
	{
		Stack <Character> stack=new Stack <Character>();
		String postfix="";
		for(int i=0; i<infix.length();i++)
		{
			char c=infix.charAt(i);
			if(isOperator(c))
			{
				while(!stack.empty() && stack.peek()!='(' && hasHigherPrecedence(stack.peek(),c))
				{
					postfix+=stack.peek();
					stack.pop();
				}
				stack.push(c);
			}
			else if(isOperand(c))
				postfix+=c;
			else if(c=='(')
				stack.push(c);
			else if( c == ')')
			{
				while(!stack.empty() && stack.peek()!='(')
				{
					postfix+=stack.peek();
					stack.pop();
				}
				stack.pop();
			}
		}

		while(!stack.empty()){
			postfix+=stack.peek();
			stack.pop();
		}
		return postfix;
			
		}
}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("ENTER AN INFIX EXPRESSION :");
		String infix=in.nextLine();
		System.out.println("POSTIFIX :" +getPostfix(infix));
	}
}
