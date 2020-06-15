Possible improvements

The attributes of Item are public, as well as GildedRose. I wanted to change it to private, but the goblin around the corner doesn't 
allow me to. The reason I would like to do so is because we could use the setters and getters to make the editing of the values more 
structured and ensure encapsulation.

I would have liked to do polymorphism with Item, Conjured Item, and others (e.g., Aged Brie). Each of them behave differently when it 
comes to updating their quality. The polymorphism would have made the code simpler and readable. We would have to create multiple objects
which could occupy more memory space, but for this case it would have been a small number. But in the end, it depends what we value more,
the performance, the code readability, the memory, the quality, etc.

I don't like the comparison of the items' names as Strings, it can lead to a problem quickly (the spaces, the capitals, typos, etc).
Comparison between Strings is strict. 
I was thinking I could create an enum to categorize the items and use Category as a way to check which item it is.
Comparison with enums is simple and is less prone to error.
