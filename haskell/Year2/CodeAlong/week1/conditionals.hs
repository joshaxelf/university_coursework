{-
public String checkChar (Char x){
    if (x == 'a')
        return 'the char is a'
    if (x == 'z')
        return 'the char is z'
    else
        return 'the char is not z or a'
}

This function checks whether input character is Z or A
-}

checkChar :: Char -> String
checkChar x = if x == 'a' then "the char is a" else (if x == 'z' then "the char is z" else "the char is not a or z")

-- The above works, but is messy and easy to get lost

checkChar1 :: Char -> String
checkChar1 x | x == 'a' = "the char is a"
             | x == 'z' = "the char is z"
             | otherwise = "the char is not a or z"

-- The guard -> | takes one logical condition and specifies the behaviour that should happen
-- Essentially if(this then that)

checkChar2 :: Char -> String
checkChar2 'a' = "the char is a"
checkChar2 'z' = "the char is a"
checkChar2 _ = "the char is not a or z"

-- The underscore is a wildcard, meaning anything else