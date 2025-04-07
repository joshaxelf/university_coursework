{-
A String is a long list of Characters. The type String is same as Char

: -> This lets us stick an element onto a list

Char1:Char2:Char3:CharN:[]

[] -> This lets us build a list
-}

length1 :: String -> Int
length1 [] = 0
length1 (x:xs) = 1 + length xs 
-- (x:xs) means Look at something with : to something else