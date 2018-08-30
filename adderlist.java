// A program to add two long integers, using linked lists

import java.util.Scanner;
class node{
	int data;
	node next;

	int count(int n)
	{
		int c=0;
		while(n>0)
		{
			n=n/10;
			c++;
		}
		return c;
	}

node createNode(int x)
{
	node newNode=new node();
	newNode.data=x;
	newNode.next=null;

	return newNode;
}

node createList(int n)
{
	int size=count(n);
	node start=createNode(n%10);
	n=n/10;
	node ptr=start;
	int i;
	for(i=1;i<size;i++)
	{
		ptr.next=createNode(n%10);
		ptr=ptr.next;
		n=n/10;
	}

	return start;

}

void addList(node list1, node list2)
{
	node list=createNode(0);
	String sum="";
	while(list1!=null)
	{
		list.data+ =(list2!=null)?( list1.data + list2.data ): list1.data ;
		list.next=createNode(0);
		if(list.data > 9)
		{
			list.data-=10;
			(list.next).data+=1;
		}
		sum= list.data+ sum;
		list=list.next;
		list1=list1.next;
		if(list2!=null)
			list2=list2.next;
	}
	System.out.println("The sum is ="+ sum);
}
	 public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("enter two nos:");
		int n1=in.nextInt();
		int n2=in.nextInt();
		node ob=new node();
		ob.addList(ob.createList(n1), ob.createList(n2));
	}
}
