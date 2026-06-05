class LinkedList:
    
    class Node:
            def __init__(self, value):
                self.value = value
                self.next = None


    def __init__(self):
        self.head = None      
    
    def get(self, index: int) -> int:
        cur = self.head
        for i in range(index): 
            if cur == None:
                return -1
            cur = cur.next
        
        if cur == None:
                return -1
        else:
            return cur.value

    def insertHead(self, val: int) -> None:
        head = self.Node(val)
        head.next = self.head
        self.head = head

    def insertTail(self, val: int) -> None:
        if self.head == None:
            self.head = self.Node(val)
            return
        cur = self.head
        while (cur.next != None):
            cur = cur.next
        cur.next = self.Node(val)

    def remove(self, index: int) -> bool:
        if index == 0:
            if self.head is not None:
                self.head = self.head.next
                return True
            else:
                return False

        prev = self.head
        cur = self.head.next
        for i in range(1, index):
            if cur == None:
                return False
            cur = cur.next
            prev = prev.next
        if cur == None:
            return False
        else:
            prev.next = cur.next
            return True

        

    def getValues(self) -> List[int]:
        cur = self.head
        arr = []
        while cur:
            arr.append(cur.value)
            cur = cur.next
        return arr
