# linked-list-hw
Analysis of a Doubly and Singly Linked List, speed and efficiency comparisons, and additions.
Computer Science HW 7
Jack Cavanaugh
In attached code

Pseudocode:

secondtolast()
	if (head == null or head.next == null)
		print(“Unable to find value”)
		return
	Node current = head
	Node previous = null
	while (current.next != null)
		previous = current
		current = current.next
	print(previous)

To find the second to last variable in the list, we need to traverse through the whole list while remembering the Node directly previous to the one we are currently traversing. Once we reach the end of the list then, we will naturally look to this variable as it will be the second to list Node in the list. The edge case that we look out for here is if the list we are trying to traverse does not exist. 

In attached code

I see two possible solutions to this problem. The first is to iterate through the entire list while counting these iterations and then finding the midpoint of this index as the middle value. Another way to do it would be to sort the list in ascending or descending order and then again find the midpoint value. Unless we were trying to find multiple values I don’t see an advantage to the second method, so I will write out the first method.

Pseudocode:

middlevalue()
	if (head == null)
		print(“List has no values”)
		return
	current = head
	count = 1
	while (current.next != null) 
		current = current.next
		count += 1
	if (count % 2 = 0)
		midpoint = (count/2)
	else
		midpoint = (count/2) + 0.5
	iterate = head
	for (i = 0; i < midpoint; i++)
		iterate = iterate.next
	print(iterate)

As described this method counts every item in the list, and then funds the midpoint of the index depending on whether the number is odd or even. Once we find this value we iterate through the list again and reach the midpoint Node. 

Runtime: It took me 50,000 nodes for the time elapsed to be greater than 0.0 seconds. Even after 300,000 nodes, the time was still a few milliseconds at most. 

Pseudocode:

concat(SinglyLinkedList M)
	if M == null
		print(M is empty)
		return
	Node lastNode = head
	while lastNode != null
		lastNode = lastNode.next
	lastNode.next = M.head

Explanation: In this block, we are effectively taking the items of linked list M and placing them at the rear of our other selected list. We find the final node in this list by traversing through the entire list, and at the end, we set this last Node equal to the first node of M, which effectively combines the two lists. The only edge case we have to worry about is if M is empty, in which we print the normal list as it was. 

Pseudocode:

Edge cases: We need to look out for instances where one of the values is the head to ensure we keep the head pointer intact. We also need to check that both x and y exist and are a part of the linked list. 

Public void swap(Node x, Node y)
	if (x == null OR y == null)
		print(“X or Y does not exist)
		return
	Node valueBeforeX = null
	Node valueBeforeY = null
	Node current = head
	while current != x
		valueBeforeX = current
		current = current.next
	current = head
	while current != y
		valueBeforeY = current
		current = current.next
	if valueBeforeX != null
		valueBeforeX.next = y
	else 
		head = y
	if valueBeforeY != null
		valueBeforeY.next = x
	else
		head = x
	Node pointer = x.next
	x.next = y.next
	Y.next = pointer

Pseudocode:

swap(Node x Node y)
	Assign the Nodes next and prev for both x and y to a variable
	Conditionals if XPrev or YPrev is null
	Assign XNext.next to y and vice versa
	Assign all values at the end to respective variables

In this question, we are swapping in both doubly and singly-linked lists. The code is considerably lighter in the doubly linked list as we do not need to iterate all the way forwards to reach the end of the code nd find each value to the other. Each code however works similarly in that they assign values to the previous and forward nodes to x and y, and swaps these assignments from x to y and y to x, effectively swapping them in the list. When comparing the time unsurprisingly the doubly linked list was about twice as fast on average, but neither swap took a large amount of time by any means. To even get a timeable result the items had to be buried deep into very long lists.

Pseudocode:

reverse()
	Node prev = null
	Node current = head
Node next = null
	while (current != null)
		next = current.next
		current.next = prev
		prev = current
		current = next
	head = prev

Edge cases: No outliers we need to look out for in this case, if the list is empty the code handles it without needing a special if statement. 

Explanation: The code works by iterating through a current node variable keeping track of the node previous and following this node. As long as we are not at the end of the list (current != null), we point the next item in the list to the previous item, effectively reversing the order of every Node as we progress through the list. 

Pseudocode:

clone()
	SinglyLinkedList M = new SinglyLinkedList()
	Node current = head
	Node tail = null
	while current != null
		Node new_node = new Node()
		new_node.value = current.value
		if M.head == null
			tail.next = new_node
			Tail = new_node
		current = next

Explanation: This code tracks the head and tail of the list we are trying to copy. In the while loop, we iterate through the list, creating a new Node with the value of its counterpart as we go and storing it in the new Singly Linked List we instantiated in the first line. It checks to ensure the list exists and as long as we don’t reach the end of that list the while loop continues. 
