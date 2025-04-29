def count(s: str, c: str) -> int:
    sum = 0
    for i in range(len(s)):
        if s[i] == c:
            sum += 1
    return sum

if __name__ == '__main__':
    # Numerics
    x = 2
    y = 4.0
    print(x ** y)

    # Fixed size list
    a = [1, 2, 3, 4]
    for n in a:
        print(n, end = ' ')
    print()

    # String
    b = 'mochimochimochi'
    found = count(b, "o")
    print(found)

    # Variable sized list
    c = []
    c.append(1.2)
    c.append(3.4)
    c.append(5.6)
    for i in range(len(c)):
        print(c[i])