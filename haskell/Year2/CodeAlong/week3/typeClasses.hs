equals :: Eq a => a -> a -> Bool
equals x y = x == y -- == needs to have Eq typeclass if generic

add :: Num a => a -> a -> a
add x y = x + y -- + Needs to have Num typeclass when generic

greaterThan :: Ord a => a -> a -> Bool
greaterThan x y = x > y -- > Needs Ord typeclass when generic

genList :: Enum a => a -> a -> [a]
genList x y = [x..y] -- List needs Enum typeclass when generic


-- When in doubt, hover over errors and typeclass will show
-- Typeclass info  can be found with :i