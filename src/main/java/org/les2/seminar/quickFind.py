# Быстрый поиск

def binarFind(arr, start, end, value):
    if end < start:
        return -1

    pivot = (start + end) // 2

    if arr[pivot] > value:
        return binarFind(arr, start, pivot-1, value)
    elif arr[pivot] < value:
        return binarFind(arr, pivot+1, end, value)
    else:
        return pivot


arr = [9, 7, 6, 3, 4, 5, 12, 0, 42, 23]
# предварительно нужно отсортировать
sortArr = sorted(arr)
print(sortArr)
# Поиск работает только в отсортированном массиве
print(binarFind(sortArr, 0, len(sortArr), 12))
