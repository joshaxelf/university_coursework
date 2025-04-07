
-- 1) Count the occurences of a given character in a string

checkChars :: Char -> String -> Int
checkChars c [] = 0
checkChars c (x:xs) | c == x = 1 + (checkChars c xs)
                    | otherwise = checkChars c xs

{-
Base case = if empty, return 0
Next Case = When C is equal to X, 1 + start recurring
Otherwise case = When C is not equal to X, start recurring 
-}


-- 2) Write a function which will return the second last element of a list of integers

secondLast :: [Int] -> Int
secondLast [x,y] = x
secondLast (x:xs) = secondLast xs

{-
Only needs one case really as its just checking the end of the list [...x,y]
Second case works through until it finds [x,y]
-}

-- 3) Write a function which will reverse a given string

reverseString :: String -> String
reverseString [] = []
-- reverseString [x] = [x]
-- reverseString [x,y] = [y,x]
reverseString (x:xs) = (reverseString xs) ++ [x]

{-
By putting recursion first, we can then add x onto the end and recurse again
-}

-- 4) Write a function that checks if a given string is a palindrome returning a boolean

isPalin :: String -> Bool
isPalin xs = xs == (reverseString xs)

-- Calls the reverse function to reverse the input and check it against itself

-- 5) Write a function which will flatten a lsit of lists of integers returning a list of integers

flattenInt :: [[Int]] -> [Int]
flattenInt [] = []
flattenInt (xs:xss) = xs ++ flattenInt xss

-- xs is a list
-- xss is a list of lists
