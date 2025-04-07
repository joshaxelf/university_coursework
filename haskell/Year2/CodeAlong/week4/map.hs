import Data.Char
{-
How do we abstract the process of transforming lists? 
Given a list I want to apply a transformation to each 
element, how do I abstract the standard loop away?
-}

x = ["Hard Target","Demons","Blood Rage","Chopping Mall","Miami Connection"]

{-
Maps is useful to change data from one time to another

Using in terminal we can use map length x to get the length of our strings in the list x
[11,6,10,13,16]

Using in terminal we can use map toUpper to change the string "asfsJDHJhdj"
into "ASFSJDHJHDJ"

Using in terminal we can use map (map toUpper) x to change the case of our list of strings
["HARD TARGET","DEMONS","BLOOD RAGE","CHOPPING MALL","MIAMI CONNECTION"]
-}