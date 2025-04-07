elem' x xs = foldl (\acc y -> if x == y then True else acc) False xs

map' f xs = foldr (\x acc -> (f x):acc) [] xs 

reverse' xs = foldl (\acc x -> x:acc) [] xs

filter' f xs = foldr (\x acc -> if (f x) then x:acc else acc) [] xs 