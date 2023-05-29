# Сортировка выбором

def directSort(arr):
    for i in range(len(arr)-1):
        minPos = i
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[minPos]:
                minPos = j
        if (minPos != i):
            arr[minPos], arr[i] = arr[i], arr[minPos]
    return arr


array = [9, 7, 6, 3, 4, 5, 12, 0, 30]
print(directSort(array))
