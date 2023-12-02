import heapq

def taxicab_numbers(n) -> list:
    heap = []
    seen = set()

    for a in range(1, n):
        for b in range(a, n):
            result = a**3 + b**3
            if result in seen:
                heapq.heappush(heap, result)
            seen.add(result)

    taxicabs = []
    while heap:
        current = heapq.heappop(heap)
        taxicabs.append(current)

    return taxicabs

# Example usage
n = 15;  # You can adjust the value of n
result = taxicab_numbers(n)
print(result)
