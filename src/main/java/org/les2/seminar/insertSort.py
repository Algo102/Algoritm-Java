# сортировка вставками

def insertSort(arr):
    for i in range(len(arr)-1):
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[i]:
                arr[j], arr[i] = arr[i], arr[j]
    return arr


array = [9, 7, 6, 3, 4, 5, 12, 0, 30]
print(insertSort(array))
