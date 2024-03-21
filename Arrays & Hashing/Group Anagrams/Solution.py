class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        groupedAnagrams: list[list[str]] = []
        groupedWords: dict[int, list[str]] = {}

        for i in strs:
            if groupedWords.get(len(i)):
                groupedWords[len(i)].append(i)
                continue

            groupedWords[len(i)] = [i]
        
        for length, sameLengthWords in groupedWords.items():
            while len(sameLengthWords) > 0:
                word = sameLengthWords.pop(0)
                sameLengthAnagrams = [word]

                # bug with same input
                # example in main
                for i, e in enumerate(sameLengthWords):
                    if self.isAnagram(word, sameLengthWords[i]):
                        sameLengthAnagrams.append(sameLengthWords[i])
                        sameLengthWords.remove(sameLengthWords[i])
                
                groupedAnagrams.append(sameLengthAnagrams)

        return groupedAnagrams

    def isAnagram(self, word: str, anagram: str) -> bool:
        if len(word) != len(anagram):
            return False
        
        charsWord = list(word)
        charsAnagram = list(anagram)

        charsWord.sort()
        charsAnagram.sort()

        return charsWord == charsAnagram
    
if __name__ == "__main__":
    strs = ["", "",""]
    print(Solution().groupAnagrams(strs))