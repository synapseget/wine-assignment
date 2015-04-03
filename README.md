# wine-assignment
Program reads an input text file consisting of person id and wine id.
Input text file is processed to map it on a hashmap.
Wine id is taken as unique and placed each wine id with the set  of requested person in a hash map.
Hash map comprises of wine id as key and hash set as key value.
Based on the constraint to be satisfied three sets are created ,the above hashmap is parsed randomly with the key value.
When a key value is obtained its particular hashset is again parsed randomly.
Each person is checked for the recieved number of wine if it exceeds three move on to the next person or wineid based on the occasion.
Each time when a person is assigned a wineid it is updated in a output hashmap.
The output hash map is reviewed and the datas are inputted in a text file.
