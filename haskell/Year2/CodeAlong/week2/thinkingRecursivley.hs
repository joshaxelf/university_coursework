{-
swapElem which swaps elements frome even indices to odd and vice versa
If the list is of the odd length, the final element should be left in its position

swapElem [1,2,3,4] = [2,1,4,3]
swapElem [1,2,3,4,5] = [2,1,4,3,5]

Do I need a base case?

What cases can I encounter?

Can I simplify?

Can I generalise?
-}

swapElem :: [Int] -> [Int]
swapElem [] = []
swapElem [x] = [x]
swapElem [x,y] = [y,x] -- This case can actually be removed for simplicity but it is worth going through and thinking about cases FIRST
swapElem (x:y:xs) = y:x:(swapElem xs) 