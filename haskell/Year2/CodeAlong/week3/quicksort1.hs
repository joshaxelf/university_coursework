{-
Quicksort Alogrithim

1-  If lsit is empty then done
2-  Select pivot element
3-  Sort list around pivot elelemtn, less than on the left
    and greater or equal to the right
4-  Repeat until every element has been sorted 

Using Ord Typeclass
-}

lessThan :: Ord a => a -> [a] -> [a]
lessThan a [] = []
lessThan a (x:xs) | x < a = x : lessThan a xs
                  | otherwise = lessThan a xs

moreThan :: Ord a => a -> [a] -> [a]
moreThan a [] = []
moreThan a (x:xs) | a > x = moreThan a xs
                  | otherwise = x : moreThan a xs

quickSort :: Ord a => [a] -> [a]
quickSort [] = []
quickSort (p:xs) = (quickSort(lessThan p xs)) ++ [p] ++ (quickSort(moreThan p xs)) -- p for Pivot in list 