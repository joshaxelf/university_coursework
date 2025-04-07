{-
List comprehension allows us to build more complex lists involving predicates
generally [x | x <- [1..]] condition 1 on x, condition 2, ...]

elements will only be added to the list if they 

    1) are produced as elements from the generator
    2) meet all of the logical conditions
-}

-- List all numbers div by 6 up to 100
divBy6 :: [Integer]
divBy6 = [x | x <- [1,2..100], mod x 6 == 0]

-- List all numbers div by 6 and 7 up to 100
divBy6and7 :: [Integer]
divBy6and7 = [x | x <- [1,2..100], mod x 6 == 0, mod x 7 == 0]

-- generate odd and even numbers up till 10 
oddEven = [(x, y) | x <- [1,3..10], y <- [2,4..10]]

{- 
this generates Tuples

These are collection of values grouped together, two elements of x and y
so first few tuples are 

(1,2)
(1,4)
(1,6)
etc
-}

-- We can turn this into a function by using n instead of x
-- Now we input whatever number we want for the list
oddEven1 n = [(x, y) | x <- [1,3..n], y <- [2,4..n]]

-- This will generate a list of characters that dont double up
listChar = [x:y:[] | x <- ['a'..'z'], y <- ['a'..'z'], x/=y]