class DynamicArray:
    
    def __init__(self, capacity: int):
        self._capacity = capacity
        self._array = []


    def get(self, i: int) -> int:
        return self._array[i]

    def set(self, i: int, n: int) -> None:
        self._array[i] = n

    def pushback(self, n: int) -> None:
        self._array.append(n)
        while len(self._array) > self._capacity:
            self.resize()

    def popback(self) -> int:
        n = self._array[-1]
        self._array = self._array[:-1]
        return n

    def resize(self) -> None:
        self._capacity *= 2

    def getSize(self) -> int:
        return len(self._array)
    
    def getCapacity(self) -> int:
        return self._capacity
